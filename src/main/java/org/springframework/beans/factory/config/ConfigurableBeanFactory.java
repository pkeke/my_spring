package org.springframework.beans.factory.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author pke
 * @data 2021/10/29 20:21
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistory {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
