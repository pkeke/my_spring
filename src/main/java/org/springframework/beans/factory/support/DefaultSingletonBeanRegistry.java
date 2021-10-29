package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pke
 * @data 2021/10/27 17:00
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistory {

    Map<String,Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    public void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
