package org.springframework.test.ioc.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.test.ioc.bean.Car;

/**
 * @author pke
 * @data 2021/10/31 20:10
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(this.brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
