package com.hanmz.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * home controller
 * Created by hanmz on 2016/7/31.
 */
@Controller
public class HomeController {

  @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
  public String home() {
    System.out.println(123);
    return "home";
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() {
    return "test";
  }
}
