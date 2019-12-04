package com.qf.service.impl;

import com.qf.Msg.Msg;
import com.qf.dao.HomeinfoDao;
import com.qf.domain.Homeinfo;
import com.qf.repository.HomeinfoRepository;
import com.qf.service.HomeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service("homeinfoService")
public class HomeinfoServiceImpl implements HomeinfoService {

    @Autowired
    private HomeinfoDao homeinfoDao;
    @Autowired
    private HomeinfoRepository homeinfoRepository;

    /*全表且分页*/
    @Override
    public Msg findAll(Integer size, Integer page) {
        if (page<0){
            page=0;
        }else {
            page= page-1;
        }
        Pageable pages = PageRequest.of(page,size);
        Page<Homeinfo> all = homeinfoRepository.findAll(pages);
        List<Homeinfo> content = all.getContent();
        Msg msg=new Msg();
        msg.setList(content);
        msg.setTotal(all.getTotalElements());
        msg.setPage(all.getTotalPages());
        return msg;
    }

    /*根据城市id查询*/
    @Override
    public Homeinfo findById(Integer id) {
        Optional<Homeinfo> byId = homeinfoRepository.findById(id);
        Homeinfo homeinfo=null;
        if (byId.isPresent()) {
           homeinfo= byId.get();
        }
        return homeinfo;
    }

   /*新增或者修改*/
    @Override
    public Homeinfo saveAndFlush(Homeinfo homeinfo) {
        return homeinfoRepository.saveAndFlush(homeinfo);
    }

    /*删除*/
    @Override
    public String deleteById(Integer id) {
        try{
            homeinfoRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "error";
    }

    /*城市名查询且分页*/
    @Override
    public List<Homeinfo> selectAll(String cityname, Integer size, Integer page) {
        List<Homeinfo> homeinfos = homeinfoDao.selectAll(cityname, size, page);
        return homeinfos;
    }

    /*模糊城市名查询且分页*/
    @Override
    public List<Homeinfo> selectAllhose(String description, Integer size, Integer page) {


        List<Homeinfo> homeinfos = homeinfoDao.selectAllhouse(description, size, page);
        return homeinfos;
    }

    /*确定城市名条件下的模糊搜索且分页*/
    @Override
    public List<Homeinfo> selectAllByCityName(String description, Integer size, Integer page) {
        List<Homeinfo> homeinfos = homeinfoDao.selectAllByCityName(description,size,page);
        return homeinfos;
    }


}
