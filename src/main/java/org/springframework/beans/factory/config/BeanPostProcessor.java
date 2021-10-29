package org.springframework.beans.factory.config;

/**
 *
 * 用于修改实例化后的bean的修改扩展点
 * @author pke
 * @data 2021/10/29 20:07
 */
public interface BeanPostProcessor {


    /***
     * 在bean执行初始化方法之前执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /***
     *在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);

}
