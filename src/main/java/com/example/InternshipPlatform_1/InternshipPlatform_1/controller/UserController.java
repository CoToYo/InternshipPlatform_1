package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    final
    private IUserService userService;

    @PostMapping(value = "/confirm", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateUser(@RequestBody User user){
//        R r = new R();
//        r.setData()
        userService.updateById(user);
        return "updated";
    }
}
