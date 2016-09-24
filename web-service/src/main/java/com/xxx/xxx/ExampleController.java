package com.xxx.xxx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liushuang on 2016/9/24.
 */
@Controller
public class ExampleController {
    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String index() {
        return "example/index";
    }
}
