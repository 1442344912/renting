package com.qf.dao;

import com.qf.domain.Homeinfo;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface HomeinfoDao {

    /*根据城市搜索酒店*/
    List<Homeinfo> selectAll(String cityname, Integer size, Integer page);

   /* 模糊搜索酒店*/
    List<Homeinfo> selectAllhouse(String description, Integer size, Integer page);

    /* 进入城市的模糊搜索酒店*/
    List<Homeinfo> selectAllByCityName(String description, Integer size ,Integer page);



}
