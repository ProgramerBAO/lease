package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.app.mapper.*;
import com.springbootProject.lease.web.app.service.ApartmentInfoService;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* @author 86183
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
    implements ApartmentInfoService {

    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;
    @Resource
    private GraphInfoMapper graphInfoMapper;
    @Resource
    private FacilityInfoMapper facilityInfoMapper;
    @Resource
    private LabelInfoMapper labelInfoMapper;
    @Resource
    private RoomInfoMapper roomInfoMapper;

    @Override
    public ApartmentDetailVo getApartmentDetailById(Long id) {
        //1.查询公寓基本信息
        ApartmentInfo apartmentInfo = super.getById(id);
        //2.查询公寓图片信息
        LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId,apartmentInfo.getId());
        List<GraphInfo> graphInfoList = graphInfoMapper.selectList(graphInfoLambdaQueryWrapper);
        //3.查询公寓标签信息
        List<LabelInfo> labelInfoList=labelInfoMapper.listLabelInfobyApartmentId(id);
        //4.查询公寓配套信息
        List<FacilityInfo> facilityInfoList=facilityInfoMapper.listFacilityInfoByApartmentId(id);
        //5.查询最小租金
        BigDecimal minRent=roomInfoMapper.selectMinRentByApartmentId(id);
        //6.装配查询结果
        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo,apartmentDetailVo);
        apartmentDetailVo.setGraphInfoList(graphInfoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        apartmentDetailVo.setMinRent(minRent);
        return apartmentDetailVo;

    }
}




