package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", "Hello Spring MVC!!");
        mav.setViewName("/view/hello"); // WEB-INF/view/hello.jsp (prefix, subfix 적용시)
        return mav;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String welcome() {

        return "쿠쿠루삥뽕"; // 단순 String을 return 하는 경우 JSP 파일명으로 인식 // 단순 문자열 원하면 @ResponseBody
    }
}
