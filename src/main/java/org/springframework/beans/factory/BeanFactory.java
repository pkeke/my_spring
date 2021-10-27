package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * @author pke
 * @data 2021/10/27
 *
 */

// bean 工厂
public class BeanFactory {

    private Map<String,Object> beanMap = new HashMap<>();
    public void registerBean(String name, Object bean){
        beanMap.put(name,bean);
    }
    public Object getBean(String name){
        return beanMap.get(name);
    }
}
