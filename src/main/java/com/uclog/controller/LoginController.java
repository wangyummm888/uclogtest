package com.uclog.controller;/**
 * Created by wangyu on 2017/8/8.
 */

import com.uclog.model.User;
import com.uclog.utils.VerifyCodeUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 登录相关的LogController
 *
 * @author yu.wang15
 * @create 2017-08-08 17:48
 **/
@Controller
@RequestMapping("/login")
public class LoginController {



    private Logger logger=Logger.getLogger(this.getClass());

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String isLogin(HttpServletRequest request, User passwordAuthcInfo) {
        String loginName = passwordAuthcInfo.getLoginName();
        String loginPassword = passwordAuthcInfo.getPassWord();
        logger.info("loginName:" + loginName + ";loginPassword:" + loginPassword);
        HttpSession session = request.getSession(true);
        String errorMessage = "";
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPassword);
        token.setRememberMe(true);
        try {
            user.login(token);
            String userID = (String) user.getPrincipal();
            logger.info("User [" + userID + "] logged in successfully.");
            session.setAttribute("USERNAME", userID);
            return "success";
        } catch (UnknownAccountException uae) {
            errorMessage = "用户认证失败：" + "username wasn't in the system.";
            logger.info(errorMessage);
        } catch (IncorrectCredentialsException ice) {
            errorMessage = "用户认证失败：" + "password didn't match.";
            logger.info(errorMessage);
        } catch (LockedAccountException lae) {
            errorMessage = "用户认证失败：" + "account for that username is locked - can't login.";
            logger.info(errorMessage);
        } catch (AuthenticationException e) {
            errorMessage = "登录失败错误信息：" + e;
            //LOGGER.error(errorMessage);
            e.printStackTrace();
            token.clear();
        }
        session.setAttribute("ErrorMessage", errorMessage);
        return "error";
    }




    /**
     * 获取验证二维码
     */
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
            System.out.print("生成二维码失败");
        }
    }
}
