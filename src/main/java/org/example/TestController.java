package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/custom-login")
    public String login(){
        return "login";
    }

    @GetMapping("/all")
    public ModelAndView all(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("all");
        return mav;
    }


    @GetMapping("/user")
    public ModelAndView user(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user");
        return mav;
    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        return mav;
    }
}
