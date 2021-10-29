package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author pke
 * @data 2021/10/29 19:16
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory{


    /***
     * 根据名称查找BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /***
     *
     * 提前实例化所有单例实例
     * @throws BeansException
     */

    void preInstantiateSingletons() throws BeansException;
}
