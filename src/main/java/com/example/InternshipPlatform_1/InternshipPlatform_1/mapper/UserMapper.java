package com.example.InternshipPlatform_1.InternshipPlatform_1.mapper;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    String getfromCCX(String userName, String passWord);
}
