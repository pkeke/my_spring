package org.springframework.beans.factory;

/**
 * @author pke
 * @data 2021/10/31 8:31
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
