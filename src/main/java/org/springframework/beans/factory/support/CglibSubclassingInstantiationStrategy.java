package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 使用CGLIB动态生成子类
 *
 * @author pke
 * @data 2021/10/28 16:46
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        throw new BeansException("CGLIB instantiation strategy is not support");
    }
}
