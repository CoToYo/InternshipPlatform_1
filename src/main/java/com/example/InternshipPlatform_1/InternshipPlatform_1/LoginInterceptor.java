package com.example.InternshipPlatform_1.InternshipPlatform_1;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.JWTUtils;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

//        System.out.println("token: "+token);

        if(request.getMethod().equals("OPTIONS") || request.getMethod().equals("options")) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        if(token == null || token.equals("")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"用户未登录");
            return false;
        }
        Map<String, Object> parsedToken = JWTUtils.parseToken(token);
//        System.out.println("parsedToken: "+parsedToken);
        if(parsedToken == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"用户未登录");
            return false;
        }
        User user = new User();
        user.setUserId((Integer) parsedToken.get("uid"));
        user.setUserName((String) parsedToken.get("userName"));
        UserHolder.add(user);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
