package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * 实现该接口，能感知所属的BeanFactory
 *
 * @author pke
 * @data 2021/10/31 12:41
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
