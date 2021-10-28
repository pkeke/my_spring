package org.springframework.beans.factory.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pke
 * @data 2021/10/27 17:30
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);

    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }
}
