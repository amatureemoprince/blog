package com.lj.blog.application.controller.test;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lj.blog.common.exception.exceptions.BusinessException;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.common.utils.MailUtils;
import com.lj.blog.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/22 18:00
 * @Version JDK 17
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MailUtils mailUtils;
    @PostMapping("/redis")
    public String redis(){
        redisUtils.set("test", "你好redis", 10, TimeUnit.HOURS);
        return "设置成功";
    }
    @GetMapping("/error")
    public void error(){
        throw new BusinessException("测试全局异常捕获");
    }
    @SaIgnore
    @GetMapping("/hello")
    public String hello(){
        return StpUtil.getTokenValue();
    }
    @SaIgnore
    @GetMapping("/email")
    public String email(){
        mailUtils.sendBlogReminder("2069057986@qq.com");
        return "发送邮箱成功";
    }

    @SaIgnore
    @RequestMapping("/admin/login")
    public String login(@RequestParam("userName") String userName){
        if("lj".equals(userName)){
            StpKit.ADMIN.login("1");
            return String.valueOf(StpKit.ADMIN.isLogin());
        }
        boolean login = StpKit.ADMIN.isLogin();
        return String.valueOf(login);
    }



    @RequestMapping("/admin")
    @SaCheckLogin(type = StpKit.ADMIN_ROLE)
    public String admin(){
        return "验证成功";
    }
    @SaIgnore
    @RequestMapping("/token")
    public String token(){
        return StpKit.ADMIN.getTokenValueByLoginId(1);
    }

    @SaIgnore
    @GetMapping("/html")
    public String html(){
        mailUtils.sendHtmlMail("2069057986@qq.com", "测试HTML", "<div\n" +
                "      id=\"app\"\n" +
                "      style=\"max-width: 600px; font-family: “Microsoft YaHei” !important\"\n" +
                "    >\n" +
                "      <table\n" +
                "        width=\"100%\"\n" +
                "        border=\"0\"\n" +
                "        cellspacing=\"0\"\n" +
                "        cellpadding=\"0\"\n" +
                "        style=\"font-family: '微软雅黑'\"\n" +
                "      >\n" +
                "        <tbody>\n" +
                "          <tr>\n" +
                "            <td>\n" +
                "              <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\n" +
                "                <tbody>\n" +
                "                  <tr>\n" +
                "                    <td>\n" +
                "                      <div\n" +
                "                        class=\"header\"\n" +
                "                        style=\"\n" +
                "                          height: 50px;\n" +
                "                          text-align: right;\n" +
                "                          width: 95%;\n" +
                "                          margin: 0 auto;\n" +
                "                        \"\n" +
                "                      ><img src=\"\"></img></div>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                  <tr>\n" +
                "                    <td>\n" +
                "                      <table\n" +
                "                        width=\"100%\"\n" +
                "                        border=\"0\"\n" +
                "                        cellpadding=\"5\"\n" +
                "                        cellspacing=\"0\"\n" +
                "                        style=\"width: 90%; margin: 0 auto\"\n" +
                "                      >\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <span\n" +
                "                                style=\"\n" +
                "                                  font-size: 14px;\n" +
                "                                  color: #333;\n" +
                "                                  font-weight: bold;\n" +
                "                                  margin-top: 20px;\n" +
                "                                \"\n" +
                "                              >\n" +
                "                                您好，<br />Hello,\n" +
                "                              </span>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <table\n" +
                "                                width=\"100%\"\n" +
                "                                border=\"0\"\n" +
                "                                cellpadding=\"5\"\n" +
                "                                cellspacing=\"0\"\n" +
                "                                style=\"\n" +
                "                                  font-size: 12px;\n" +
                "                                  color: #818181;\n" +
                "                                  padding-bottom: 20px;\n" +
                "                                \"\n" +
                "                              >\n" +
                "                                <tbody>\n" +
                "                                  <tr>\n" +
                "                                    <td>\n" +
                "                                      <span>欢迎订阅《XXX》！</span><br />\n" +
                "                                      <span>\n" +
                "                                        今后我们将为您带来游戏的最新动态、幕后花絮、独家情报，以及其他更多内容。 </span\n" +
                "                                      ><br />\n" +
                "                                      <span>请点击按钮，确认订阅。</span>\n" +
                "                                    </td>\n" +
                "                                  </tr>\n" +
                "                                </tbody>\n" +
                "                              </table>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "    </div>\n");
        return "发送成功";
    }
}
