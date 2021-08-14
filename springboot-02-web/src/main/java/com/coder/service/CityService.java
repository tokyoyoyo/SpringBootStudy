package com.coder.service;

import com.coder.bean.City;

public interface CityService {
    City getById(long id);

    void insertCity(City city);

    void deleteCityById(Long id);
}
