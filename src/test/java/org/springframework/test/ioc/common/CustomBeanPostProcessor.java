package org.springframework.test.ioc.common;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.test.ioc.bean.Car;

/**
 * @author pke
 * @data 2021/10/29 21:36
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");

        // 换兰博基尼
        if ("car".equals(beanName)){
            ((Car)bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
