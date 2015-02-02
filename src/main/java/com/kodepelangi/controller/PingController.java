package com.kodepelangi.controller;

import com.google.gson.Gson;
import com.kodepelangi.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Raka Teja<rakatejaa@gmail.com>
 */

@Controller
@RequestMapping("/ping")
public class PingController {

    private final AtomicLong counter = new AtomicLong();
    private Gson gson;

    public PingController()
    {
        this.gson = new Gson();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{from}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String findByName(@PathVariable("from") String name)
    {
        return this.gson.toJson(new Message(counter.incrementAndGet(), "Hi", name), Message.class);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(
            value="",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String create(@RequestBody String json)
    {
        Message message = this.gson.fromJson(json, Message.class);
        return this.gson.toJson(message, Message.class);
    }

}
