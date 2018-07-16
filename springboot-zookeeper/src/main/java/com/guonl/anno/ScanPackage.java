package com.guonl.anno;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * Created by guonl
 * Date 2018/7/2 下午4:01
 * Description: 加载扫描包路径（暂时还使用不到）
 */
public class ScanPackage extends ClassPathBeanDefinitionScanner {

    public ScanPackage(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        String[] packagePaths = {"com.guonl"};
        return doScan(basePackages);
    }
}
