package com.hanmz.wechat.web;

import com.hanmz.wechat.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by hanmz on 2016/9/25.
 */

@Slf4j
@RestController
public class WechatSecurityController {
  /**
   * 用于接收 get 参数，返回验证参数
   */
  @RequestMapping("/security")
  public String doGet(@RequestParam(value = "signature") String signature,
                      @RequestParam(value = "timestamp") String timestamp,
                      @RequestParam(value = "nonce") String nonce,
                      @RequestParam(value = "echostr") String echostr) {
    try {
      if (SignUtil.checkSignature(signature, timestamp, nonce)) {
        return echostr;
      }
    } catch (Exception e) {
      log.error("Error {}", e);
    }
    return "这里存在非法请求!";
  }

  // post 方法用于接收微信服务端消息
  @RequestMapping(value = "/security", method = RequestMethod.POST)
  public String DoPost() {
    System.out.println("这是 post 方法！");
    return "这是 post 方法！";
  }
}
