package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(String userName, String passWord) {

        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, userName).
                eq(User::getPassword, passWord));
        return user;
    }
}
