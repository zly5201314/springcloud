package com.jk.controller;

import com.jk.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>项目名称：springcloud
 * 类名称：HelloController
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 20:23
 * 修改人：张利瑶
 * 修改时间：2019/4/12 20:23
 * 修改备注：
 * @version </pre>
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

}
