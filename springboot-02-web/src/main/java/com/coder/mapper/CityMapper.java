package com.coder.mapper;

import com.coder.bean.City;
import org.apache.ibatis.annotations.*;


public interface CityMapper {

    @Select("select * from city where id=#{id}")
    City getById(long id);

//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    void insert(City city);

    @Delete("DELETE FROM city WHERE id = #{id}")
    void deleteById(long id);

}
