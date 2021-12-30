package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Evaluation;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.EvaluationMapper;
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
    //    写入评价，向数据库存入新的评价记录
    LocalDateTime evaluation_time = LocalDateTime.now();

    @PostMapping(value = "/confirm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String Evaluation(@RequestBody Evaluation evaluation){

        evaluation.setEvaluationTime(evaluation_time);

        int result;
        result = evaluationMapper.insert(evaluation);

        System.out.println(evaluation);

        return "The evaluation record of user: "+evaluation.getAppraiseeId()+" has been successfully created!";
    }

    }
