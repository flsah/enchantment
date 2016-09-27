package com.xxx.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liushuang on 2016/9/24.
 */
@Controller
public class ExampleController {
    private EAAService eaaService;

    @Autowired
    public ExampleController(EAAService eaaService) {
        this.eaaService = eaaService;
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String index() {
        return "example/index";
    }

    @RequestMapping(value = "/login", produces = "application/json")
    public ResponseEntity login(@RequestBody String name) {
        return eaaService.login(name);
    }
}
