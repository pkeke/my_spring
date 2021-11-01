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

    public static String SCOPE_SINGLETON = "singleton";
    public static String SCOPE_PROTOTYPE = "prototype";

    private Class beanClass;

    private Propertyvalues propertyvalues;

    private String initMethodName;

    private String destoryMethodName;

    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;

    private boolean prototype = false;

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

    public String getInitMethodName() {
        return initMethodName;
    }

    public boolean isSingleton(){
        return this.singleton;
    }

    public boolean isPrototype(){
        return this.prototype;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
        this.singleton = SCOPE_SINGLETON.equals(scope);
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestoryMethodName() {
        return destoryMethodName;
    }

    public void setDestoryMethodName(String destoryMethodName) {
        this.destoryMethodName = destoryMethodName;
    }
}
