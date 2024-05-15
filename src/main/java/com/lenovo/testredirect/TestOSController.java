package com.lenovo.testredirect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author wenjun4
 * @Date 2024/5/11
 * @Description
 */
@RestController
@RequestMapping(value = "/os")
public class TestOSController {

    @Value("${service.version}")
    private String version;

    @GetMapping("/get")
    public String get(

    ) {
        String osArch = System.getProperty("os.arch");
        System.out.println("Operating System Architecture: " + osArch);
        return "当前芯片架构： "+  osArch + "当前服务版本： " + version ;
    }
}
