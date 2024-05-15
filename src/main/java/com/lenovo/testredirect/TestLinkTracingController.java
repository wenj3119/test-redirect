package com.lenovo.testredirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wenjun4
 * @Date 2023/10/18
 * @Description
 */

@RestController
@RequestMapping(value = "/linkTracing")
public class TestLinkTracingController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(
            String url
    ) {
        System.out.println("-------------------redirect-------------start------------");
        System.out.println("-------------------url-------------:" +url);
        return restTemplate.getForObject(url, String.class);
    }


}
