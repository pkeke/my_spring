package org.springframework.beans.factory.config;

import org.springframework.beans.Propertyvalues;

/**
 *
 * BeanDefinition实例保存bean的信息，包括class类型
 * 方法构造参数，是否为单例等。
 * 此处为了简化只包含了class类型
 * @author pke
 * @data 2021/10/27 16:43
 */
public class BeanDefinition {

    private Class beanClass;

    private Propertyvalues propertyvalues;

    public BeanDefinition(Class beanClass){
        this(beanClass,null);
    }

    public BeanDefinition(Class beanClass, Propertyvalues propertyvalues) {
        this.beanClass = beanClass;
        this.propertyvalues = propertyvalues != null ? propertyvalues : new Propertyvalues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Propertyvalues getPropertyvalues() {
        return propertyvalues;
    }

    public void setPropertyvalues(Propertyvalues propertyvalues) {
        this.propertyvalues = propertyvalues;
    }
}
