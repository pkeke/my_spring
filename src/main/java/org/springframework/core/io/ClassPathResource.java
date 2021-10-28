package org.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * 类路径下的资源
 * @author pke
 * @data 2021/10/28 20:48
 */
public class ClassPathResource implements Resource{

    private final String path;


    public ClassPathResource(String path) {
        this.path = path;
    }



    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (is == null){
            throw new FileNotFoundException("resource cannot be opened because it does not exist");
        }
        return is;
    }

    public String getPath() {
        return path;
    }
}
