package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pke
 * @data 2021/10/31 10:47
 */
public class InitAndDestoryMethodTest {


 @Test
 public void testInitAndDestroyMethod() throws Exception{
  ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
  applicationContext.registerShutdownHook();
 }
}
