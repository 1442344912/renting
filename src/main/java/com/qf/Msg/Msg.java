package com.qf.Msg;

import com.qf.domain.Homeinfo;
import lombok.Data;

import java.util.List;

@Data
public class Msg {

    private List<Homeinfo> list;
    private Integer page;
    private Long total;

}
