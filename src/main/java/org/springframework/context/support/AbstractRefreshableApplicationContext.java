package org.springframework.context.support;

import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author pke
 * @data 2021/10/30 17:24
 */
public abstract class AbstractRefreshableApplicationContext extends  AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;


    protected final void refreshBeanFactory() throws BeansException{
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /***
     * 加载BeanDefinition
     *
     * @param beanFactory
     */

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /***
     * 创建bean工厂
     * @return
     */

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
