package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.core.io.ResourceLoader;

/**
 * @author pke
 * @data 2021/10/30 10:20
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
