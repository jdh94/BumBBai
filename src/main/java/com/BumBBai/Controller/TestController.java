package com.BumBBai.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/")
public class TestController {
    @GetMapping(value = {"/", "/main"})
    public ModelAndView TestPage() throws Exception {
        System.out.println("TestPage on");
        return new ModelAndView("test");
    }
}
