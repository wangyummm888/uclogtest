package com.uclog.service.impl;/**
 * Created by wangyu on 2017/8/10.
 */

import com.uclog.dao.NavsMapper;
import com.uclog.model.Navs;
import com.uclog.service.NavsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 左侧导航栏
 *
 * @author yu.wang15
 * @create 2017-08-10 16:25
 **/
@Service
public class NavsServiceImpl implements NavsService {

    @Resource
    NavsMapper navsMapper;



    @Override
    public List<Navs> getNavs(){
        return navsMapper.getNavs();
    };





}
