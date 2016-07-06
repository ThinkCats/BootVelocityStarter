package com.busi.controller;

import com.busi.service.TestAopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wanglei25 on 2016/4/7.
 */
@Slf4j
@RequestMapping("/")
@Controller
public class IndexController {

    @Autowired
    private TestAopService testAopService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(HttpServletResponse response, HttpServletRequest request) {

        //Cookie
        Cookie cookie = new Cookie("foo", "bar");
        cookie.setMaxAge(300);
        response.addCookie(cookie);

        //Session
        HttpSession session = request.getSession();
        session.setAttribute("testSession", "hello Session");
        session.setMaxInactiveInterval(60);

        testAopService.testAop();
        return "index";
    }

    @RequestMapping(value = "session", method = RequestMethod.GET)
    public String testSession(HttpServletRequest request) {
        String sessionContent = (String) request.getSession().getAttribute("testSession");
        log.info("Session Now:" + sessionContent);
        String msg = StringUtils.isEmpty(sessionContent) ? "session not existed" : sessionContent;
        request.setAttribute("msg", msg);
        return "index";
    }
}
