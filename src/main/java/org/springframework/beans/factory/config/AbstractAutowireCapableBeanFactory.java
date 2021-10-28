package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * @author pke
 * @data 2021/10/27 17:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{


 @Override
 protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
      return doCreateBean(name,beanDefinition);
 }

 protected Object doCreateBean(String name, BeanDefinition beanDefinition){
       Class beanClass = beanDefinition.getBeanClass();
       Object bean = null;
     try {
         bean = beanClass.newInstance();
     } catch (Exception e) {
         throw new BeansException("Instantiation of bean failed",e);
     }
     addSingleton(name,bean);
     return bean;
 }

}
