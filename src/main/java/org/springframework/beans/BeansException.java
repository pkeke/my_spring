package org.springframework.beans;

/***
 *
 * @author pke
 * @data 2021/10/27
 *
 */


public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }
    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
