package org.springframework.beans.factory;

/**
 * @author pke
 * @data 2021/10/27 17:36
 */
public class HelloService {

    public String sayHello(){
        System.out.println("hello");
        return "hello";
    }
}
