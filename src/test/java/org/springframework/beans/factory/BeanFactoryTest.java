package org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.Person;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.Propertyvalues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {

    @Test
    public void testBeanFactory(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Propertyvalues propertyvalues = new Propertyvalues();
        propertyvalues.addPropertyValue(new PropertyValue("foo","hello"));
        propertyvalues.addPropertyValue(new PropertyValue("bar","world"));
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class,propertyvalues);
        beanFactory.registerBeanDefinition("helloService",beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        System.out.println(helloService.toString());
        assertThat(helloService.getFoo()).isEqualTo("hello");
        assertThat(helloService.getBar()).isEqualTo("world");
    }

    @Test
    public void testPopulateBeanWithPropertyValues(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Propertyvalues propertyvalues = new Propertyvalues();
        propertyvalues.addPropertyValue(new PropertyValue("name","pke"));
        propertyvalues.addPropertyValue(new PropertyValue("age",18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class,propertyvalues);
        beanFactory.registerBeanDefinition("person",beanDefinition);
        Person person = (Person) beanFactory.getBean("person");

        System.out.println(person.toString());
        assertThat(person.getAge()).isEqualTo(18);
        assertThat(person.getName()).isEqualTo("pke");
    }
}
