package org.springframework.beans.factory;

/**
 * @author pke
 * @data 2021/10/31 19:45
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;
    boolean isSingleton();
}
