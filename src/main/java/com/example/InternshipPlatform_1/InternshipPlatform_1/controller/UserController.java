package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IUserService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/InternshipPlatform_1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
//        System.out.println(user);
        User user1 = userService.get(user.getUserName(), user.getPassword());
        Map<String, Object> res = new HashMap<>();
        if(user1 == null) {
            res.put("code", 400);
            return res;
        }
        res.put("code", 200);
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user1.getUserId());
        map.put("userName", user1.getUserName());
        String s = JWTUtils.creatToken(map);
        res.put("token", s);
        return res;
    }

}
