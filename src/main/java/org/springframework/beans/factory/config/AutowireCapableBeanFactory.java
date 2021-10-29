package org.springframework.beans.factory.config;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

/**
 * @author pke
 * @data 2021/10/29 20:17
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /***
     * 执行BeanPostProcessors的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param name
     * @return
     * @throws BeansException
     */

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    /***
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param name
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beaNName) throws BeansException;

}
