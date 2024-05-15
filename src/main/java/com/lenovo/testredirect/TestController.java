package com.lenovo.testredirect;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/redirect")
    public void toRedirect(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("-------------------redirect-------------start------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String heardName = headerNames.nextElement();
            String headerValue = request.getHeader(heardName);
            System.out.println(heardName + ": "  + headerValue);
        }
        System.out.println("-------------------redirect-------------end------------");
        response.sendRedirect("/redirectSecond");
    }

    @GetMapping("/redirectFirst")
    public void redirectFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("-------------------redirectFirst-------------start------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String heardName = headerNames.nextElement();
            String headerValue = request.getHeader(heardName);
            System.out.println(heardName + ": "  + headerValue);
        }
        System.out.println("-------------------redirectFirst-------------end------------");
        response.sendRedirect("/redirect");
    }

    @GetMapping("/redirectSecond")
    public String redirectSecond(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("-------------------redirectSecond-------------start------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String heardName = headerNames.nextElement();
            String headerValue = request.getHeader(heardName);
            System.out.println(heardName + ": "  + headerValue);
        }
        System.out.println("-------------------redirectSecond-------------end------------");
        return "hello  world";
    }

    @GetMapping("/actuator/health")
    public String health() throws IOException {

        return "hello ";
    }


    @GetMapping("/whoami")
    public String whoAmi(HttpServletRequest request){
        System.out.println("I am gray service");
        System.out.println("start： 请求头信息");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String heardName = headerNames.nextElement();
            String headerValue = request.getHeader(heardName);
            System.out.println(heardName + ": "  + headerValue);
        }
        System.out.println("end： 请求头信息");
        return "I am ori service";
    }




}
