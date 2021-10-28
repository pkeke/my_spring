package org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.Propertyvalues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.service.HelloService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/28 20:15
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Propertyvalues propertyvalues = new Propertyvalues();
        propertyvalues.addPropertyValue(new PropertyValue("foo","hello"));
        propertyvalues.addPropertyValue(new PropertyValue("bar","world"));
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class,propertyvalues);
        beanFactory.registerBeanDefinition("helloService",beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        System.out.println(helloService.toString());
        assertThat(helloService.getFoo()).isEqualTo("hello");
        assertThat(helloService.getBar()).isEqualTo("world");
    }
}
