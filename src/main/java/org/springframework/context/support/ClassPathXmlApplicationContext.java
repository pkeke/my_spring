package org.springframework.context.support;

import org.springframework.beans.BeansException;

/**
 * @author pke
 * @data 2021/10/30 17:21
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;


    /***
     * 从xml文件中加载BeanDefinition, 并且自动刷新上下文
     *
     * @param configLoaction xml配置信息
     * @throws BeansException 应用上下文创建失败
     */

    public ClassPathXmlApplicationContext(String configLoaction) throws BeansException {
        this(new String[]{configLoaction});
    }


    /***
     * 从xml文件加载BeanDefinition，并且自动刷新上下文
     * @param configLocations xml配置文件
     * @throws BeansException 应用上下文创建失败
     */

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException{
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}
