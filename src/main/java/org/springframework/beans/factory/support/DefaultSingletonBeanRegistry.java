package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.SingletonBeanRegistory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pke
 * @data 2021/10/27 17:00
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistory {

    Map<String,Object> singletonObjects = new HashMap<>();
    Map<String, DisposableBean> disposableBeans = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean){
        disposableBeans.put(beanName,bean);
    }


    public void destroySingletons() {
        Set<String> beanNames = disposableBeans.keySet();
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

}
