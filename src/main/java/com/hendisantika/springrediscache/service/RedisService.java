package com.hendisantika.springrediscache.service;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/12/17
 * Time: 06.04
 * To change this template use File | Settings | File Templates.
 */

@Service("cacheService")
public class RedisService implements CacheService {
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> messageList;

    @Resource(name = "redisTemplate")
    private RedisOperations<String, String> latestMessageExpiration;

    @Override
    public void addMessage(String user, String message) {

        messageList.leftPush(user, message);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = Date.from(zonedDateTime.plus(1, ChronoUnit.MINUTES).toInstant());
        latestMessageExpiration.expireAt(user, date);
    }

    @Override
    public List<String> listMessages(String user) {
        return messageList.range(user, 0, -1);
    }
}
