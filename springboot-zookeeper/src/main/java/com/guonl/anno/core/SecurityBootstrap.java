package com.guonl.anno.core;

import com.guonl.anno.MyAnno;
import com.guonl.enums.StorageEnum;
import com.guonl.spi.CoordinatorStorage;
import com.guonl.utils.LogUtils;
import com.guonl.utils.ServiceBootstrapUtils;
import com.guonl.utils.SpringBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * Created by guonl
 * Date 2018/7/2 下午4:38
 * Description: 注解的解析与拦截到注解之后的实现
 */
public class SecurityBootstrap implements ImportAware, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityBootstrap.class);
    private String storage;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtils.getInstance().setCfgContext((ConfigurableApplicationContext) applicationContext);
        this.start();

    }

    // 关于spi的介绍：https://www.jianshu.com/p/7601ba434ff4
    private void start() {
        try {
            final StorageEnum storageSupportEnum = StorageEnum.acquire(storage);
            final ServiceLoader<CoordinatorStorage> recoverRepositories = ServiceBootstrapUtils
                    .loadAll(CoordinatorStorage.class);
            final Optional<CoordinatorStorage> repositoryOptional = StreamSupport
                    .stream(recoverRepositories.spliterator(), false).filter(recoverRepository -> Objects
                            .equals(recoverRepository.getStorage(), storageSupportEnum.getStorage()))
                    .findFirst();
            repositoryOptional.ifPresent(repository -> {
                SpringBeanUtils.getInstance().registerBean(CoordinatorStorage.class.getName(), repository);
            });
        } catch (Exception e) {
            LOGGER.error("=== security init fail,print error:" + e.getMessage(), e);
            // no normal exit
            System.exit(1);
        }
        LogUtils.info(LOGGER, () -> "=== security init success");
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        Map<String, Object> enableAttrMap = importMetadata
                .getAnnotationAttributes(MyAnno.class.getName());
        AnnotationAttributes enableAttrs = AnnotationAttributes.fromMap(enableAttrMap);
        String storage = enableAttrs.getString("storage");
        System.out.println(storage);


    }
}
