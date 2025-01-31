package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.CityInfo;
import com.springbootProject.lease.web.app.mapper.CityInfoMapper;
import com.springbootProject.lease.web.app.service.CityInfoService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【city_info】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService {

}




