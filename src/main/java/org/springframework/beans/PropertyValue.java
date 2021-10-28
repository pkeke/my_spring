package org.springframework.beans;

/**
 *
 * bean属性信息
 * @author pke
 * @data 2021/10/28 16:52
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
