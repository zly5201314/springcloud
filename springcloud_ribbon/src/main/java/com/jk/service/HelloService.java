package com.jk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>项目名称：springcloud
 * 类名称：HelloService
 * 类描述：
 * 创建人：张利瑶
 * 创建时间：2019/4/12 20:24
 * 修改人：张利瑶
 * 修改时间：2019/4/12 20:24
 * 修改备注：
 * @version </pre>
 */
@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name="+name,String.class);
    }

}
