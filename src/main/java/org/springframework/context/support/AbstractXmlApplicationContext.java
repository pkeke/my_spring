package org.springframework.context.support;

import cn.hutool.core.util.XmlUtil;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author pke
 * @data 2021/10/30 17:32
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }

    }

    protected abstract String[] getConfigLocations();
}
