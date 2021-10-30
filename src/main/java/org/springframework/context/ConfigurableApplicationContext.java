package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * @author pke
 * @data 2021/10/30 10:21
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /***
     *  刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
