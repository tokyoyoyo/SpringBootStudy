package com.coder.service.Impl;

import com.coder.bean.City;
import com.coder.mapper.CityMapper;
import com.coder.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    CityMapper cityMapper;

    public City getById(long id){
        return cityMapper.getById(id);
    }

    public void insertCity(City city){
        cityMapper.insert(city);
    }

    public void deleteCityById(Long id){
        cityMapper.deleteById(id);

    }

}
