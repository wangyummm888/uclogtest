package com.uclog.controller;/**
 * Created by wangyu on 2017/8/8.
 */

import com.uclog.model.User;
import com.uclog.utils.MD5Tools;
import com.uclog.utils.VerifyCodeUtils;
import org.apache.commons.lang.StringUtils;
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

    public static final String LOGIN_ERROR_PAGE="page/error/loginError";

    public static final String INDEX_PAGE="index";


    public static final  String LOGIN_PAGE="page/login/login";

    private Logger logger=Logger.getLogger(this.getClass());



    @RequestMapping(value = "/toLogin.do")
    public String  toLogin(){
        return LOGIN_PAGE;
    }


    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String isLogin(HttpServletRequest request, User passwordAuthcInfo,String code) {
        HttpSession session = request.getSession(true);
        String errorMessage = "";
        String verCode =(String)session.getAttribute("verCode");
        //验证码校验
        if(StringUtils.isBlank(code)){
            errorMessage = "验证码不能为空：";
            logger.info(errorMessage);
            return LOGIN_ERROR_PAGE;
        }else if(StringUtils.isBlank(verCode)){
            errorMessage = "服务器不存在验证码";
            logger.info(errorMessage);
            return LOGIN_ERROR_PAGE;
        }else if(!code.toLowerCase().equals(verCode.toLowerCase())){
            errorMessage = "验证码不正确";
            logger.info(errorMessage);
            session.setAttribute("errorMessage", errorMessage);
            return LOGIN_ERROR_PAGE;
        }
        String loginName = passwordAuthcInfo.getLoginName();
        String loginPassword = passwordAuthcInfo.getPassWord();
        logger.info("loginName:" + loginName + ";loginPassword:" + loginPassword);
        Subject user = SecurityUtils.getSubject();
        String md5Pass=MD5Tools.MD5(loginPassword).toLowerCase();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,md5Pass);
        token.setRememberMe(true);
        try {
            user.login(token);
            String userID = (String) user.getPrincipal();
            logger.info("User [" + userID + "] logged in successfully.");
            session.setAttribute("USERNAME", userID);
            return  "redirect:/index/toIndex.do";
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
        session.setAttribute("errorMessage", errorMessage);
        return LOGIN_ERROR_PAGE;
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
