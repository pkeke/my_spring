package org.springframework.beans.factory.support;

import cn.hutool.cache.CacheUtil;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.BeanReference;

/**
 * @author pke
 * @data 2021/10/27 17:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {


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

             // 为bean填充属性
             applyPropertyValues(beanName,bean,beanDefinition);

             //执行bean的初始化方法和BeanPostProcessor的前置和后置处理方法
             initializeBean(beanName,bean,beanDefinition);
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

    protected Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition){

         // 执行BeanPostProcessor的前置处理
         Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean,beanName);
         invokeInitMethods(beanName,wrappedBean,beanDefinition);

         // 执行BeanPostProcessor的后置处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean,beanName);
        return wrappedBean;
    }

    /***
     * 执行bean的初始化方法
     *
     * @param beanName
     * @param wrappedBean
     * @param beanDefinition
     */

    protected  void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition){
        System.out.println("执行bean[" + beanName + "]的初始化方法");
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result,beanName);
            if (current == null)
                return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result,beanName);
            if (current == null)
                return result;
            result = current;
        }
        return result;
    }
}
