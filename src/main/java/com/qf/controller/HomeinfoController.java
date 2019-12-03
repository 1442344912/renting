package com.qf.controller;


import com.qf.Msg.Msg;
import com.qf.domain.Homeinfo;
import com.qf.service.HomeinfoService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class HomeinfoController {

    @Autowired
    private HomeinfoService homeinfoService;

    @Value("${qiniu.url}")
    private  String url;

    @Autowired
    private UploadUtils up;


    /*城市名查询且分页*/
    @RequestMapping("/selectAll/{cityname}/{size}/{page}")
    public Msg selectAll(@PathVariable("cityname")String cityname,@PathVariable("size")Integer size, @PathVariable("page")Integer page){
        List<Homeinfo> homeinfos = homeinfoService.selectAll(cityname, size, page);
        Msg m=new Msg();
        m.setList(homeinfos);
        m.setPage(page);
        return  m;
    }

    /*模糊酒店描述查询且分页*/
    @RequestMapping("/selectAllhose/{description}/{size}/{page}")
    public Msg selectHouse(@PathVariable("description")String description,@PathVariable("size")Integer size, @PathVariable("page")Integer page){
        List<Homeinfo> homeinfos = homeinfoService.selectAllhose(description, size, page);
        Msg msg=new Msg();
        msg.setList(homeinfos);
        msg.setPage(page);
        return msg;
    }


    @RequestMapping("/findAll/{size}/{page}")
    public Msg findAll(@PathVariable("size")Integer size, @PathVariable("page")Integer page){
        Msg all = homeinfoService.findAll(size, page);
        return all;
    }

    @RequestMapping(value = "/saveHouse",method = RequestMethod.POST)
    public Homeinfo saveHouse(Homeinfo homeinfo, @RequestParam("file") MultipartFile muli){
        try {
            //上传图片
            String upload = up.upload(muli);
            homeinfo.setPicture(url+upload);
            Homeinfo homeinfo1 = homeinfoService.saveAndFlush(homeinfo);
            return  homeinfo1;
        }catch (Exception e){

        }
        return homeinfo;
    }


    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.POST)
    public String findOne(@PathVariable("id")Integer id, Model model){
        Homeinfo byId = homeinfoService.findById(id);
        Model model1 = model.addAttribute(byId);
       /* return "model1";*/
        return "/updateHouse";
    }


    @RequestMapping(value = "/updateHouse",method = RequestMethod.POST)
    public Homeinfo updateUser(@RequestParam("file")MultipartFile multipartFile, Homeinfo homeinfo){
        String originalFilename = multipartFile.getOriginalFilename();

        if (!originalFilename.equals("")){
            String upload = up.upload(multipartFile);
            homeinfo.setPicture(url+upload);
        }
        return   homeinfoService.saveAndFlush(homeinfo);
    }
}
