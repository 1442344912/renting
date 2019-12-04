package com.qf.service;

import com.qf.Msg.Msg;
import com.qf.domain.Homeinfo;

import java.util.List;

public interface HomeinfoService {

    Msg findAll(Integer size, Integer page);

    Homeinfo findById(Integer id);

    Homeinfo saveAndFlush(Homeinfo homeinfo);

    String deleteById(Integer id);


    /*根据城市名搜索酒店*/
    List<Homeinfo> selectAll(String cityname, Integer size, Integer page);

    /*模糊所搜酒店*/
    List<Homeinfo> selectAllhose(String description, Integer size, Integer page);

    /* 进入城市的模糊搜索酒店*/
    List<Homeinfo> selectAllByCityName(String description, Integer size ,Integer page);


}
