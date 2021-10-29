package org.springframework.test.ioc.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.Propertyvalues;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author pke
 * @data 2021/10/29 21:33
 */
public class CustomBeanFactoryPostcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition personBeanDefinition = beanFactory.getBeanDefinition("person");

        Propertyvalues propertyvalues = personBeanDefinition.getPropertyvalues();
        propertyvalues.addPropertyValue(new PropertyValue("name","PTN"));
    }
}
