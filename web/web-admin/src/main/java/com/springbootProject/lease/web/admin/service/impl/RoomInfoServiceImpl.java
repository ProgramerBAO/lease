package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.model.enums.ItemType;
import com.springbootProject.lease.web.admin.mapper.*;
import com.springbootProject.lease.web.admin.service.*;
import com.springbootProject.lease.web.admin.vo.graph.GraphVo;
import com.springbootProject.lease.web.admin.vo.room.*;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.List;

/**
* @author BobShen
* @description 针对表【room_info(房间信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
    implements RoomInfoService {

    @Resource
    private GraphInfoService graphInfoService;
    @Resource
    private RoomLabelService roomLabelService;
    @Resource
    private RoomAttrValueService roomAttrValueService;
    @Resource
    private RoomFacilityService roomFacilityService;
    @Resource
    private RoomLeaseTermService roomLeaseTermService;
    @Resource
    private RoomPaymentTypeService roomPaymentTypeService;

    @Resource
    private RoomInfoMapper roomInfoMapper;

    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;

    @Resource
    private RoomLeaseTermMapper roomLeaseTermMapper;

    @Resource
    private RoomPaymentTypeMapper roomPaymentTypeMapper;

    @Resource
    private RoomAttrValueMapper roomAttrValueMapper;

    @Resource
    private LabelInfoMapper labelInfoMapper;

    @Resource
    private FacilityInfoMapper facilityInfoMapper;

    @Resource
    private GraphInfoMapper graphInfoMapper;

    @Override
    public void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo) {
        //判断是新增还是修改
        boolean isUpdate = roomSubmitVo.getId() != null;
        //1.保存房间基本信息
        super.saveOrUpdate(roomSubmitVo);
        if (isUpdate) {//修改房间信息
            //2.删除房间图片信息
            LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM);
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId, roomSubmitVo.getId());
            graphInfoService.remove(graphInfoLambdaQueryWrapper);
            //3.删除房间标签信息
            LambdaQueryWrapper<RoomLabel> roomLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLabelLambdaQueryWrapper.eq(RoomLabel::getRoomId, roomSubmitVo.getId());
            roomLabelService.remove(roomLabelLambdaQueryWrapper);
            //4.删除房间属性信息
            LambdaQueryWrapper<RoomAttrValue> roomAttrValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomAttrValueLambdaQueryWrapper.eq(RoomAttrValue::getRoomId, roomSubmitVo.getId());
            roomAttrValueService.remove(roomAttrValueLambdaQueryWrapper);
            //5.删除房间配套信息
            LambdaQueryWrapper<RoomFacility> roomFacilityLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomFacilityLambdaQueryWrapper.eq(RoomFacility::getRoomId, roomSubmitVo.getId());
            roomFacilityService.remove(roomFacilityLambdaQueryWrapper);
            //6.删除房间租期信息
            LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLeaseTermLambdaQueryWrapper.eq(RoomLeaseTerm::getRoomId, roomSubmitVo.getId());
            roomLeaseTermService.remove(roomLeaseTermLambdaQueryWrapper);
            //7.删除房间支付方式信息
            LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomPaymentTypeLambdaQueryWrapper.eq(RoomPaymentType::getRoomId, roomSubmitVo.getId());
            roomPaymentTypeService.remove(roomPaymentTypeLambdaQueryWrapper);
        }else{//新增房间信息
            //2.新增房间图片信息
            List<GraphVo> graphVoList = roomSubmitVo.getGraphVoList();
            ArrayList<GraphInfo> graphInfos = new ArrayList<>();
            if(!CollectionUtils.isEmpty(graphVoList)){
                graphVoList.forEach(graphVo -> {
                    GraphInfo graphInfo = new GraphInfo();
                    graphInfo.setItemType(ItemType.ROOM);
                    graphInfo.setItemId(roomSubmitVo.getId());
                    graphInfo.setUrl(graphVo.getUrl());
                    graphInfos.add(graphInfo);
                });
                graphInfoService.saveBatch(graphInfos);
            }
            //3.新增房间标签信息
            List<Long> roomLabelIds = roomSubmitVo.getRoomLabelIds();
            ArrayList<RoomLabel> roomLabels = new ArrayList<>();
            if(!CollectionUtils.isEmpty(roomLabelIds)){
                roomLabelIds.forEach(roomLabelId -> {
                    RoomLabel roomLabel = new RoomLabel();
                    roomLabel.setRoomId(roomSubmitVo.getId());
                    roomLabel.setLabelId(roomLabelId);
                    roomLabels.add(roomLabel);
                });
                roomLabelService.saveBatch(roomLabels);
            }
            //4.新增房间属性信息
            List<Long> roomAttrValueIds = roomSubmitVo.getRoomAttrValueIds();
            ArrayList<RoomAttrValue> roomAttrValues = new ArrayList<>();
            if (!CollectionUtils.isEmpty(roomAttrValueIds)){
                for (Long roomAttrValueId : roomAttrValueIds) {
                    RoomAttrValue roomAttrValue = new RoomAttrValue();
                    roomAttrValue.setRoomId(roomSubmitVo.getId());
                    roomAttrValue.setAttrValueId(roomAttrValueId);
                    roomAttrValues.add(roomAttrValue);
                }
                roomAttrValueService.saveBatch(roomAttrValues);
            }
            //5.新增房间配套信息
            List<Long> roomFacilityIds = roomSubmitVo.getRoomFacilityIds();
            ArrayList<RoomFacility> roomFacilities = new ArrayList<>();
            if (!CollectionUtils.isEmpty(roomFacilityIds)){
                for (Long roomFacilityId : roomFacilityIds) {
                    RoomFacility roomFacility = new RoomFacility();
                    roomFacility.setRoomId(roomSubmitVo.getId());
                    roomFacility.setFacilityId(roomFacilityId);
                    roomFacilities.add(roomFacility);
                }
                roomFacilityService.saveBatch(roomFacilities);
            }
            //6.新增房间租期信息
            List<Long> roomLeaseTermIds = roomSubmitVo.getRoomLeaseTermIds();
            ArrayList<RoomLeaseTerm> roomLeaseTerms = new ArrayList<>();
            if (!CollectionUtils.isEmpty(roomLeaseTermIds)){
                for (Long roomLeaseTermId : roomLeaseTermIds) {
                    RoomLeaseTerm roomLeaseTerm = new RoomLeaseTerm();
                    roomLeaseTerm.setRoomId(roomSubmitVo.getId());
                    roomLeaseTerm.setLeaseTermId(roomLeaseTermId);
                    roomLeaseTerms.add(roomLeaseTerm);
                }
                roomLeaseTermService.saveBatch(roomLeaseTerms);
            }
            //7.新增房间支付方式信息
            List<Long> roomPaymentTypeIds = roomSubmitVo.getRoomPaymentTypeIds();
            ArrayList<RoomPaymentType> roomPaymentTypes = new ArrayList<>();
            if (!CollectionUtils.isEmpty(roomPaymentTypeIds)){
                for (Long roomPaymentTypeId : roomPaymentTypeIds) {
                    RoomPaymentType roomPaymentType = new RoomPaymentType();
                    roomPaymentType.setRoomId(roomSubmitVo.getId());
                    roomPaymentType.setPaymentTypeId(roomPaymentTypeId);
                    roomPaymentTypes.add(roomPaymentType);
                }
                roomPaymentTypeService.saveBatch(roomPaymentTypes);
            }
        }

    }

    @Override
    public IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo roomQueryVo) {
        return roomInfoMapper.pageRoomItemByQuery(page, roomQueryVo);
    }

    @Override
    public RoomDetailVo getRoomDetailById(Long id) {
        //1.查询房间基本信息
        RoomInfo roomInfo = roomInfoMapper.selectById(id);
        //2.查询房间所属公寓信息
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(roomInfo.getApartmentId());
        //3.查询房间租期列表信息
        List<LeaseTerm> roomLeaseTermList = roomLeaseTermMapper.selectListByRoomId(id);
        RoomDetailVo adminRoomDetailVo = new RoomDetailVo();
        //4.查询房间支付方式列表信息
        List<PaymentType> roomPaymentTypeList = roomPaymentTypeMapper.selectListByRoomId(id);
        BeanUtils.copyProperties(roomInfo,adminRoomDetailVo);
        //5.查询房间属性列表信息
        List<AttrValueVo> roomAttrValueList = roomAttrValueMapper.selectListByRoomId(id);
        //6.查询房间标签列表信息
        List<LabelInfo> roomLabelList = labelInfoMapper.selectListByRoomId(id);
        adminRoomDetailVo.setApartmentInfo(apartmentInfo);//设置公寓信息
        //6.查询房间配套列表信息
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
        //7.查询房间图片列表信息
        //List<GraphVo> graphInfoList = graphInfoMapper.selectListByItemTypeAndId(id,ItemType.ROOM);
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(id, ItemType.ROOM);

        adminRoomDetailVo.setLeaseTermList(roomLeaseTermList);//设置房间租期信息
        adminRoomDetailVo.setPaymentTypeList(roomPaymentTypeList);//设置支付方式信息
        adminRoomDetailVo.setRoomAttrValueList(roomAttrValueList);//设置房间属性信息
        adminRoomDetailVo.setRoomLabelList(roomLabelList);//设置房间标签信息
        adminRoomDetailVo.setFacilityInfoList(facilityInfoList);//设置房间配套信息
        adminRoomDetailVo.setGraphInfoList(graphVoList);//设置房间图片信息

        return adminRoomDetailVo;
    }

    @Override
    public void removeRoomById(Long id) {
        //1.删除房间基本信息
        super.removeById(id);

        //2.删除房间图片信息
        LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM);
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId, id);
        graphInfoService.remove(graphInfoLambdaQueryWrapper);
        //3.删除房间标签信息
        LambdaQueryWrapper<RoomLabel> roomLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomLabelLambdaQueryWrapper.eq(RoomLabel::getRoomId, id);
        roomLabelService.remove(roomLabelLambdaQueryWrapper);
        //4.删除房间属性信息
        LambdaQueryWrapper<RoomAttrValue> roomAttrValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomAttrValueLambdaQueryWrapper.eq(RoomAttrValue::getRoomId, id);
        roomAttrValueService.remove(roomAttrValueLambdaQueryWrapper);
        //5.删除房间配套信息
        LambdaQueryWrapper<RoomFacility> roomFacilityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomFacilityLambdaQueryWrapper.eq(RoomFacility::getRoomId, id);
        roomFacilityService.remove(roomFacilityLambdaQueryWrapper);
        //6.删除房间租期信息
        LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomLeaseTermLambdaQueryWrapper.eq(RoomLeaseTerm::getRoomId, id);
        roomLeaseTermService.remove(roomLeaseTermLambdaQueryWrapper);
        //7.删除房间支付方式信息
        LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomPaymentTypeLambdaQueryWrapper.eq(RoomPaymentType::getRoomId, id);
        roomPaymentTypeService.remove(roomPaymentTypeLambdaQueryWrapper);
    }

}




