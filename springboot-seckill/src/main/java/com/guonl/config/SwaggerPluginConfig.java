package com.guonl.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
@Profile("!production")
public class SwaggerPluginConfig {

	  @Autowired
	  private TypeResolver typeResolver;
	  
	@Bean
	  public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	          .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
	          .paths(PathSelectors.any())
	          .build()
	        .pathMapping("/")
	        .genericModelSubstitutes(ResponseEntity.class)
	        .alternateTypeRules(
	            newRule(typeResolver.resolve(DeferredResult.class,
	                    typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
	                typeResolver.resolve(WildcardType.class)))
	        .useDefaultResponseMessages(false)
	        .globalResponseMessage(RequestMethod.GET,
	            newArrayList(new ResponseMessageBuilder()
	                .code(500)
	                .message("Server Error")
	                .responseModel(new ModelRef("Error"))
	                .build()))
//	        .enableUrlTemplating(true)
	        .tags(new Tag("API", "HTTP接口"))
	        .apiInfo(apiInfo());
	  }
	    private ApiInfo apiInfo() {
	        ApiInfo apiInfo = new ApiInfo(
	        		"我的秒杀 HTTP API",	//标题
	                "",								//描述
	                "1.0.0",							//版本
	                "springboot 联合测试项目",
	                "",//联系人
	                "",								//协议
	                ""									//协议地址
	        );
	      return apiInfo;  
	    }  
}
