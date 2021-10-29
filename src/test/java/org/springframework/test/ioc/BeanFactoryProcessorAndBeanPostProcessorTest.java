package org.springframework.test.ioc;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;
import org.springframework.test.ioc.common.CustomBeanFactoryPostcessor;
import org.springframework.test.ioc.common.CustomBeanPostProcessor;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/29 21:31
 */
public class BeanFactoryProcessorAndBeanPostProcessorTest {


    @Test
    public void testBeanFactoryPostProcessor() throws Exception{
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 在所有BeanDefintion加载完成后，但在bean实例化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostcessor beanFactoryPostcessor = new CustomBeanFactoryPostcessor();
        beanFactoryPostcessor.postProcessBeanFactory(beanFactory);

        Person person = (Person) beanFactory.getBean("person");

        System.out.println(person);
        assertThat(person.getName()).isEqualTo("PTN");
    }


    @Test
    public void testBeanPostProcessor() throws Exception{

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 添加bean实例化后的处理器
        CustomBeanPostProcessor beanPostProcessor = new CustomBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }
}
