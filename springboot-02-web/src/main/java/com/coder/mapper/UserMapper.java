package com.coder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
