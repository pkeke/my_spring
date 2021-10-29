package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pke
 * @data 2021/10/27 17:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
     @Override
     protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
          return doCreateBean(name,beanDefinition);
     }

     protected Object doCreateBean(String beanName, BeanDefinition beanDefinition){
           Class beanClass = beanDefinition.getBeanClass();
           Object bean = null;
         try {
             bean = createBeanInstance(beanDefinition);
             applyPropertyValues(beanName,bean,beanDefinition);
         } catch (Exception e) {
             throw new BeansException("Instantiation of bean failed",e);
         }
         addSingleton(beanName,bean);
         return bean;
     }

     protected void applyPropertyValues(String beanName,Object bean, BeanDefinition beanDefinition){

         try {
             Class beanClass = beanDefinition.getBeanClass();
             for (PropertyValue propertyVaule : beanDefinition.getPropertyvalues().getPropertyVaules()) {
                 String name = propertyVaule.getName();
                 Object value = propertyVaule.getValue();
                 if (value instanceof BeanReference){

                     // beanA依赖beanB，先实例化beanB
                     BeanReference beanReference = (BeanReference) value;
                     value = getBean(beanReference.getBeanName());
                 }

                 // 通过反射设置属性
                 BeanUtil.setFieldValue(bean,name,value);

             }
         } catch (Exception e) {
             throw new BeansException("Error setting property values for bean: " + beanName, e);
         }
     }

     protected Object createBeanInstance(BeanDefinition beanDefinition){
         return getInstantiationStrategy().instantiate(beanDefinition);
     }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
