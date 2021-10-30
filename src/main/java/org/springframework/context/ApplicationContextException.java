package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * @author pke
 * @data 2021/10/30 10:23
 */
public class ApplicationContextException extends BeansException {
    public ApplicationContextException(String msg) {
        super(msg);
    }

    public ApplicationContextException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
