package org.springframework.beans.factory.config;

import org.springframework.beans.factory.BeanFactory;

/**
 * @author pke
 * @data 2021/10/29 20:21
 */
public interface ConfigurableBeanFactory extends BeanFactory,SingletonBeanRegistory {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
