package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pke
 * @data 2021/10/28 16:57
 */
public class Propertyvalues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue pv){
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyVaules(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyVaule(String propertyName){
        for (int i = 0; i < propertyValueList.size(); i++){
            PropertyValue pv = propertyValueList.get(i);
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

}
