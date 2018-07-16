package com.guonl.anno;

import com.guonl.anno.core.SecurityBootstrap;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * Created by guonl
 * Date 2018/7/2 下午3:59
 * Description: 我的自定义注解
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableCaching
@Import(value = {SecurityBootstrap.class})
public @interface MyAnno {
    String storage() default "";
}
