package org.springframework.beans.factory;

import java.util.Map;

/**
 * @author pke
 * @data 2021/10/29 19:12
 */
public interface ListableBeanFactory extends BeanFactory{

    /***
     * 返回指定类型的所有实例
     * @param type
     * @param <T>
     * @return
     */

    <T> Map<String,T> getBeanOfType(Class<T> type);
}
