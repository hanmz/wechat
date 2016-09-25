package com.hanmz.wechat.web;

import com.hanmz.wechat.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by hanmz on 2016/9/25.
 */

@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatSecurityController {
  /**
   * 用于接收 get 参数，返回验证参数
   */
  @RequestMapping(value = "security", method = RequestMethod.GET)
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response,
                    @RequestParam(value = "signature", required = true) String signature,
                    @RequestParam(value = "timestamp", required = true) String timestamp,
                    @RequestParam(value = "nonce", required = true) String nonce,
                    @RequestParam(value = "echostr", required = true) String echostr) {
    try {
      if (SignUtil.checkSignature(signature, timestamp, nonce)) {
        PrintWriter out = response.getWriter();
        out.print(echostr);
        out.close();
      } else {
        log.info("这里存在非法请求！");
      }
    } catch (Exception e) {
      log.error("Error {}", e);
    }
  }

  @RequestMapping(value = "security", method = RequestMethod.POST)
  // post 方法用于接收微信服务端消息
  public void DoPost() {
    System.out.println("这是 post 方法！");
  }
}
