package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/30 18:11
 */


public class ApplicationContextTest {

    @Test
    public void testApplicationContext(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Person person = applicationContext.getBean("person",Person.class);
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("PTN");
        assertThat(person.getAge()).isEqualTo(18);

        Car car = applicationContext.getBean("car",Car.class);
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("lamborghini");


    }
}
