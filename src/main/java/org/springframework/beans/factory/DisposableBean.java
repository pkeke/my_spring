package org.springframework.beans.factory;

/**
 * @author pke
 * @data 2021/10/31 8:33
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
