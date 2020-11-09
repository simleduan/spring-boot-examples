package com.neo.source.cache;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * create by xiaocai on 2020/10/22 10:58
 **/
public class FCacheException extends PersistenceException {
    public FCacheException() {
        super();
    }

    public FCacheException(String message) {
        super(message);
    }

    public FCacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public FCacheException(Throwable cause) {
        super(cause);
    }
}
