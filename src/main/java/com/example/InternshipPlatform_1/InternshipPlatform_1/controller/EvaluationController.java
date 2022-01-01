package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Evaluation;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.EvaluationMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.EvaluationServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
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
@ResponseBody
@RequestMapping(value="/InternshipPlatform_1/evaluation", method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
public class EvaluationController {

    @Autowired
    EvaluationMapper evaluationMapper;
    @Autowired
    EvaluationServiceImpl evaluationService;
    @Autowired
    UserMapper userMapper;


    //    写入评价，向数据库存入新的评价记录
    LocalDateTime evaluation_time = LocalDateTime.now();

    @PostMapping(value = "/confirm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String Evaluation(@RequestBody Evaluation evaluation){ //evaluation中只有evaluationContent、evaluatedName

        //当前操作的用户(评价人)信息
        User evaluatorUser = UserHolder.getUser();

        evaluation.setEvaluatorId(evaluatorUser.getUserId());//记录当前操作用户(评价人)的ID
        evaluation.setEvaluationTime(evaluation_time);//记录评价时间

        Integer evaluatedID = evaluationService.selectByUserName(evaluation.getEvaluatedName()).getUserId();//查询受评价人ID
        evaluation.setEvaluatedId(evaluatedID);//记录受评价人ID


        //向数据库写入评价信息
        int result;
        result = evaluationMapper.insert(evaluation);

        System.out.println(evaluation);

        return "The evaluation record of user: "+evaluation.getEvaluatedName()+" has been successfully created!";
    }

    }
