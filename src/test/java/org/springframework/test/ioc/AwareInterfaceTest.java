package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.service.HelloService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pke
 * @data 2021/10/31 13:10
 */
public class AwareInterfaceTest {

    @Test
    public void testAwareInterface(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService",HelloService.class);
        assertThat(helloService.getApplicationContext()).isNotNull();
        assertThat(helloService.getBeanFactory()).isNotNull();
    }
}
