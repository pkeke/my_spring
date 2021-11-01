package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/31 20:08
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception{

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
        Car car = applicationContext.getBean("car",Car.class);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
