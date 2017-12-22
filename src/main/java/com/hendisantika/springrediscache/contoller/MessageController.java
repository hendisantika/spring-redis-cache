package com.hendisantika.springrediscache.contoller;

import com.hendisantika.springrediscache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-redis-cache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/12/17
 * Time: 06.07
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class MessageController {
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public List<String> greeting(String user) {

        List<String> messages = cacheService.listMessages(user);

        return messages;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(String user, String message) {

        cacheService.addMessage(user, message);

        return "OK";

    }
}
