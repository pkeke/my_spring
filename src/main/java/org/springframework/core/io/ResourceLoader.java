package org.springframework.core.io;

/**
 * @author pke
 * @data 2021/10/28 21:02
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
