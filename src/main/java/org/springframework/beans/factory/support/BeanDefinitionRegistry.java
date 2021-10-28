package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author pke
 * @data 2021/10/27 17:06
 */
public interface BeanDefinitionRegistry {

    /***
     * 向注册表中注册BeanDefinition信息
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
