package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author pke
 * @data 2021/10/27 17:06
 */
public interface BeanDefinitionRegistry {

    /***
     * 向注册表中注册BeanDefinition信息
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /***
     * 根据名称查找BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /***
     *
     * 是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containBeanDefinition(String beanName);

    /***
     * 返回定义的所有bean的名称
     * @return
     */
    String[] getBeanDefomotionNames();
}
