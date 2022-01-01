package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.LoginUser;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.result.Result;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IUserService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.JWTUtils;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    final IUserService userService;



    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody LoginUser loginuser, HttpSession session) {
        String userName = loginuser.getUserName();
        userName = HtmlUtils.htmlEscape(userName);

        User user = userService.get(userName, loginuser.getPassWord());
        if (null == user) {
            return new Result(400, "");
        } else {
//            session.setAttribute("user", user);
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("uid", user.getUserId());
            userMap.put("userName", user.getUserName());
            String s = JWTUtils.creatToken(userMap);
            return new Result(200, s);
        }
    }

    @GetMapping("test")
    public String test() {
        User id = UserHolder.getUser();
        System.out.println(id);
        return "success";
    }
}
