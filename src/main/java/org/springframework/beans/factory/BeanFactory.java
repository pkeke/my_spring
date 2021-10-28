package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/***
 *
 * @author pke
 * @data 2021/10/27
 *
 */
public interface BeanFactory {
    /***
     *  获取bean
     * @param name
     * @return
     * @throws BeansException bean不存在时
     */
    Object getBean(String name) throws BeansException;
}
