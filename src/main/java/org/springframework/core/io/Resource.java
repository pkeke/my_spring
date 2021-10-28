package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 *
 * 资源的抽象类
 * @author pke
 * @data 2021/10/28 20:37
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
