package org.springframework.beans.factory.config;

/**
 * @author pke
 * @data 2021/10/27 16:49
 */
public interface SingletonBeanRegistory {

    Object getSingleton(String beanName);
}
