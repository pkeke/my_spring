package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.Propertyvalues;
import org.springframework.test.ioc.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.bean.Car;

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

    /***
     *
     * 为bean对象注入bean
     *
     */


    @Test
    public void testPopulateBeanWithBean(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册Car实例
        Propertyvalues propertyValuesForCar = new Propertyvalues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand","porsche"));
        BeanDefinition beanDefinition = new BeanDefinition(Car.class,propertyValuesForCar);
        beanFactory.registerBeanDefinition("car",beanDefinition);

        // 注册Person实例
        Propertyvalues propertyValuesForPerson = new Propertyvalues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name","pke"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age",18));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car",new BeanReference("car")));
        BeanDefinition beanDefinition1 = new BeanDefinition(Person.class,propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person",beanDefinition1);

        Person person = (Person) beanFactory.getBean("person");

        System.out.println(person);
        assertThat(person.getName()).isEqualTo("pke");
        assertThat(person.getAge()).isEqualTo(18);
        Car car = person.getCar();
        assertThat(car).isNotNull();
        assertThat(car.getBrand()).isEqualTo("porsche");



    }
}
