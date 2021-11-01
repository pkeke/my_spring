package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pke
 * @data 2021/10/27 17:12
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String,Object> factoryBeanObjectCache = new HashMap<>();

    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null)
            // 如果是FactoryBean, 从FactoryBean#getObject中创建bean
            return getObjectForBeanInstance(name,sharedInstance);
        BeanDefinition beanDefinition = getBeanDefinition(name);
        sharedInstance = createBean(name,beanDefinition);
        return getObjectForBeanInstance(name,sharedInstance);
    }


    /***
     *
     * 如果是FactoryBean, 从FactoryBean#getObject中创建
     * @param beanName
     * @param beanInstance
     * @return
     */
    protected Object getObjectForBeanInstance(String beanName, Object beanInstance){
        Object object = beanInstance;
        if (beanInstance instanceof FactoryBean){
            FactoryBean factoryBean = (FactoryBean) beanInstance;
            try {
                if (factoryBean.isSingleton()){
                    object = factoryBeanObjectCache.get(beanName);
                    if (object == null){
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName,object);
                    }
                }else {
                    object = factoryBean.getObject();
                }
            } catch (Exception e) {
                throw new BeansException("FactoyBean throw exception on object[ " + beanName + "] creation");
            }
        }
        return object;
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

        // 有则覆盖
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }
}
