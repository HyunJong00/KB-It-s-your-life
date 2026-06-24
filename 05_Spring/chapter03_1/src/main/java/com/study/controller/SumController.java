package com.study.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.study.bean.SumDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SumController {
    //    @RequestMapping(value = "/input", method = RequestMethod.GET)
    @GetMapping(value = "/input")
    public String input() {
        return "/sum/input";
    }

//    @GetMapping(value = "/result")
//    public String result(){
//        return "/sum/result";
//    }
//    @GetMapping(value = "/result")
//    public ModelAndView result(@RequestParam int x, @RequestParam int y){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("x", x);
//        mav.addObject("y", y);
//        mav.setViewName("/sum/result");
//        return mav;
//    }

//    @GetMapping(value = "/result")
//    public ModelAndView result(@RequestParam (required = false, defaultValue="0") int x,
//                               @RequestParam(required = false, defaultValue="0") int y){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("x", x);
//        mav.addObject("y", y);
//        mav.setViewName("/sum/result");
//        return mav;
//    }

//    @GetMapping(value = "/result")
//    public String result(@RequestParam Map<String, String> map, ModelMap modelMap){
//        modelMap.put("x", map.get("x"));
//        modelMap.put("y", map.get("y"));
//        return "/sum/result";
//    }

    //클라이언트에서 전달된 요청 파라미터(form, query string, POST body)를 자동으로 자바 객체에 바인딩 해준다.
    //기본형이 아닌 자바 객체는 @ModelAttrivute 생략 가능(자동으로 뷰에 전달 됨)
    @GetMapping(value = "/result")
    public String result(SumDTO sumDTO, @ModelAttribute int page, Model model) {
        model.addAttribute("sumDTO", sumDTO);
        model.addAttribute("page", page);
        return "/sum/result2";
    }
}

