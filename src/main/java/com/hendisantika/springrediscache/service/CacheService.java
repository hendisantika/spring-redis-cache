package com.hendisantika.springrediscache.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/12/17
 * Time: 06.03
 * To change this template use File | Settings | File Templates.
 */
public interface CacheService {
    void addMessage(String user, String message);

    List<String> listMessages(String user);
}
