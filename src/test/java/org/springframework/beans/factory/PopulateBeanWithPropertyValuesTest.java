package org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.Propertyvalues;
import org.springframework.beans.factory.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/28 20:14
 */
public class PopulateBeanWithPropertyValuesTest {

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
