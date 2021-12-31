package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Evaluation;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.EvaluationMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IEvaluationService;
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
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements IEvaluationService {

    @Autowired
    UserMapper userMapper;

    //利用姓名查找对应用户信息
    public User selectByUserName(String userName){
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.likeRight("userName", userName);
        User user = userMapper.selectOne(wrapper);

        return user;
    }

}
