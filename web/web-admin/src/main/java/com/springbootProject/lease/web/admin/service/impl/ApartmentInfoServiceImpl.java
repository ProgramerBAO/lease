package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.common.exception.LeaseException;
import com.springbootProject.lease.common.result.ResultCodeEnum;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.model.enums.ItemType;
import com.springbootProject.lease.web.admin.mapper.*;
import com.springbootProject.lease.web.admin.service.*;
import com.springbootProject.lease.web.admin.vo.ApartmentItemVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.springbootProject.lease.web.admin.vo.apartment.FeeValueVo;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86183
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2024-06-18 22:50:27
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {
    // 引入公寓配套信息service
    @Resource
    private ApartmentFacilityService apartmentFacilityService;

    @Resource
    private ApartmentLabelService apartmentLabelService;

    @Resource
    private ApartmentFeeValueService apartmentFeeValueService;

    @Resource
    private GraphInfoService graphInfoService;

    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;

    @Resource
    private GraphInfoMapper graphInfoMapper;

    @Resource
    private ApartmentFacilityMapper apartmentFacilityMapper;

    @Resource
    private ApartmentLabelMapper apartmentLabelMapper;

    @Resource
    private ApartmentFeeValueMapper apartmentFeeValueMapper;

    @Resource
    private RoomInfoService roomInfoService;

    @Override
    public void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo) {
        //新增公寓基本信息
        boolean isUpdate = apartmentSubmitVo.getId() != null;// 判断是否是修改操作
        super.saveOrUpdate(apartmentSubmitVo); // 保存或更新公寓基本信息

        if (isUpdate) {/*修改公寓信息 */
            //1.删除公寓配套列表
            LambdaQueryWrapper<ApartmentFacility> facilityInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            facilityInfoLambdaQueryWrapper.eq(ApartmentFacility::getApartmentId, apartmentSubmitVo.getId());
            apartmentFacilityService.remove(facilityInfoLambdaQueryWrapper);
            //2.删除公寓标签列表
            LambdaQueryWrapper<ApartmentLabel> labelInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            labelInfoLambdaQueryWrapper.eq(ApartmentLabel::getApartmentId, apartmentSubmitVo.getId());
            apartmentLabelService.remove(labelInfoLambdaQueryWrapper);
            //3.删除公寓杂费列表
            LambdaQueryWrapper<ApartmentFeeValue> feeValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
            feeValueLambdaQueryWrapper.eq(ApartmentFeeValue::getApartmentId, apartmentSubmitVo.getId());
            apartmentFeeValueService.remove(feeValueLambdaQueryWrapper);
            //4.删除公寓图片列表
            LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId, apartmentSubmitVo.getId());
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
            graphInfoService.remove(graphInfoLambdaQueryWrapper);
        }
        /*新增公寓信息 配套信息也要更新吧*/
        //1.新增公寓配套列表
        List<Long> facilityInfoIds = apartmentSubmitVo.getFacilityInfoIds();
        ArrayList<ApartmentFacility> apartmentFacilityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(facilityInfoIds)) {
            for (Long facilityInfoId : facilityInfoIds) {
                ApartmentFacility apartmentFacility = new ApartmentFacility();
                apartmentFacility.setApartmentId(apartmentSubmitVo.getId());
                apartmentFacility.setFacilityId(facilityInfoId);
                apartmentFacilityList.add(apartmentFacility);
            }
            apartmentFacilityService.saveBatch(apartmentFacilityList);
        }
        //2.新增公寓标签列表
        List<Long> labelIds = apartmentSubmitVo.getLabelIds();
        //判断标签列表是否为空 如果没有标签也就不用加了 下同
        if (!CollectionUtils.isEmpty(labelIds)) {
            ArrayList<ApartmentLabel> apartmentLabelList = new ArrayList<>();
            for (Long labelId : labelIds) {
                ApartmentLabel apartmentLabel = new ApartmentLabel();
                apartmentLabel.setApartmentId(apartmentSubmitVo.getId());
                apartmentLabel.setLabelId(labelId);
                apartmentLabelList.add(apartmentLabel);
            }
            apartmentLabelService.saveBatch(apartmentLabelList);
        }
        //3.新增公寓杂费列表
        List<Long> feeValueIds = apartmentSubmitVo.getFeeValueIds();
        if (!CollectionUtils.isEmpty(feeValueIds)) {
            ArrayList<ApartmentFeeValue> apartmentFeeValueList = new ArrayList<>();
            for (Long feeValueId : feeValueIds) {
                ApartmentFeeValue apartmentFeeValue = new ApartmentFeeValue();
                apartmentFeeValue.setApartmentId(apartmentSubmitVo.getId());
                apartmentFeeValue.setFeeValueId(feeValueId);
                apartmentFeeValueList.add(apartmentFeeValue);
            }
            apartmentFeeValueService.saveBatch(apartmentFeeValueList);
        }
        //4.新增公寓图片列表
        List<GraphVo> graphVoList = apartmentSubmitVo.getGraphVoList();
        if (!CollectionUtils.isEmpty(graphVoList)) {
            ArrayList<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemId(apartmentSubmitVo.getId());
                graphInfo.setItemType(ItemType.APARTMENT);
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfoList.add(graphInfo);
            }
            graphInfoService.saveBatch(graphInfoList);
        }

    }

    @Override
    public IPage<ApartmentItemVo> pageApartmentListByQuery(IPage<ApartmentItemVo> page, ApartmentQueryVo apartmentQueryVo) {
        return apartmentInfoMapper.pageApartmentListByQuery(page, apartmentQueryVo);
    }

    @Override
    public ApartmentDetailVo getApartmentDetailById(Long id) {
        //1.查询ApartmentInfo
        ApartmentInfo apartmentInfo = super.getById(id);
        if (apartmentInfo == null) {
            return null;
        }
        //2.查询公寓图片信息
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(id, ItemType.APARTMENT);
        //3.查询公寓配套信息
        List<FacilityInfo> facilityInfoList = apartmentFacilityMapper.selectListByItemTypeAndId(id);
        //4.查询公寓标签信息
        List<LabelInfo> labelInfoList = apartmentLabelMapper.selectListByItemTypeAndId(id);
        //5.查询公寓杂费信息
        List<FeeValueVo> feeValueVoList = apartmentFeeValueMapper.selectListByItemTypeAndId(id);

        ApartmentDetailVo adminApartmentDetailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo, adminApartmentDetailVo);
        adminApartmentDetailVo.setGraphVoList(graphVoList);
        adminApartmentDetailVo.setFacilityInfoList(facilityInfoList);
        adminApartmentDetailVo.setLabelInfoList(labelInfoList);
        adminApartmentDetailVo.setFeeValueVoList(feeValueVoList);

        return adminApartmentDetailVo;
    }

    @Override
    public void removeApartmentById(Long id) {
        //查询公寓下面是否有房间，有房间不能删除
        LambdaQueryWrapper<RoomInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RoomInfo::getApartmentId, id);
        long count = roomInfoService.count(lambdaQueryWrapper);
        if (count > 0) {
            throw new LeaseException(ResultCodeEnum.ADMIN_APARTMENT_DELETE_ERROR);
        }
        //删除公寓基本信息
        super.removeById(id);

        //1.删除公寓配套列表
        LambdaQueryWrapper<ApartmentFacility> facilityInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        facilityInfoLambdaQueryWrapper.eq(ApartmentFacility::getApartmentId, id);
        apartmentFacilityService.remove(facilityInfoLambdaQueryWrapper);
        //2.删除公寓标签列表
        LambdaQueryWrapper<ApartmentLabel> labelInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        labelInfoLambdaQueryWrapper.eq(ApartmentLabel::getApartmentId, id);
        apartmentLabelService.remove(labelInfoLambdaQueryWrapper);
        //3.删除公寓杂费列表
        LambdaQueryWrapper<ApartmentFeeValue> feeValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
        feeValueLambdaQueryWrapper.eq(ApartmentFeeValue::getApartmentId, id);
        apartmentFeeValueService.remove(feeValueLambdaQueryWrapper);
        //4.删除公寓图片列表
        LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId, id);
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
        graphInfoService.remove(graphInfoLambdaQueryWrapper);
    }
}




