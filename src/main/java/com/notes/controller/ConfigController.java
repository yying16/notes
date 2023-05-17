package com.notes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.boot.web.context.WebServerInitializedEvent;

import javax.annotation.Resource;

@RestController
public class ConfigController {

    @Value("${server.port}")
    String port;

    /**
     * 获取当前服务器公网ip
     * */

    @GetMapping("/getHostAddress")
    public String getHostAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }
    /**
     * 获取当前端口号
     * */
    @GetMapping("/getPort")
    public String getPort(){
        return port;
    }

    /**
     * 获取ip+端口号
     * */
    @GetMapping("/getAddress")
    public String getAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress() + ":"+port;
    }
}
