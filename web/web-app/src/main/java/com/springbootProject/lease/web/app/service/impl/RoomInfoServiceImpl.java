package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.common.constant.RedisConstant;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.model.entity.*;
import com.springbootProject.lease.web.app.mapper.*;
import com.springbootProject.lease.web.app.service.BrowsingHistoryService;
import com.springbootProject.lease.web.app.service.RoomInfoService;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;
import com.springbootProject.lease.web.app.vo.attrvalue.AttrValueVo;
import com.springbootProject.lease.web.app.vo.feevalue.FeeValueVo;
import com.springbootProject.lease.web.app.vo.graph.GraphVo;
import com.springbootProject.lease.web.app.vo.room.RoomDetailVo;
import com.springbootProject.lease.web.app.vo.room.RoomItemVo;
import com.springbootProject.lease.web.app.vo.room.RoomQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

/**
* @author 86183
* @description 针对表【room_info(房间信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
    implements RoomInfoService {

    @Resource
    private RoomInfoMapper roomInfoMapper;

    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;

    @Resource
    private LeaseTermMapper leaseTermMapper;

    @Resource
    private PaymentTypeMapper paymentTypeMapper;

    @Resource
    private AttrValueMapper attrValueMapper;

    @Resource
    private LabelInfoMapper labelInfoMapper;

    @Resource
    private FacilityInfoMapper facilityInfoMapper;

    @Resource
    private GraphInfoMapper graphInfoMapper;

    @Resource
    private FeeValueMapper feeValueMapper;

    @Resource
    private BrowsingHistoryService browsingHistoryService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo) {
        return roomInfoMapper.pageRoomItemByQuery(page,queryVo);
    }

    @Override
    public RoomDetailVo getRoomDetailById(Long id) {
        String key = RedisConstant.APP_ROOM_PREFIX + id;
        RoomDetailVo roomDetailVo = (RoomDetailVo)redisTemplate.opsForValue().get(key);
        if(roomDetailVo==null) {
            //1.房间基本信息 从父类继承
            RoomInfo roomInfo = super.getById(id);
            if (roomInfo == null) {
                return null;
            }
            //2.房间所属公寓信息
            ApartmentItemVo apartmentItemVo = apartmentInfoMapper.getApartmentByRoomId(roomInfo.getApartmentId());
            //3.房间租期信息
            List<LeaseTerm> leaseTermList = leaseTermMapper.getLeaseTermByRoomId(id);
            //4.房间支付类型信息
            List<PaymentType> paymentTypeList = paymentTypeMapper.getPaymentTypeByRoomIt(id);
            //5.房间属性值信息
            List<AttrValueVo> attrValueVoList = attrValueMapper.getAttrValueByRoomId(id);
            //6.房间标签信息
            List<LabelInfo> labelInfoList = labelInfoMapper.getLabelInfoByRoomId(id);
            //7.房间配套信息
            List<FacilityInfo> facilityInfoList = facilityInfoMapper.getFacilityInfoByRoomId(id);
            //8.房间图片信息
            List<GraphVo> graphVoList = graphInfoMapper.getGraphByRoomId(id);
            //9.杂费列表
            List<FeeValueVo> feeValueVoList = feeValueMapper.getFeeValueByRoomId(roomInfo.getApartmentId());

            roomDetailVo = new RoomDetailVo();

            BeanUtils.copyProperties(roomInfo, roomDetailVo);
            roomDetailVo.setApartmentItemVo(apartmentItemVo);
            roomDetailVo.setLeaseTermList(leaseTermList);
            roomDetailVo.setPaymentTypeList(paymentTypeList);
            roomDetailVo.setAttrValueVoList(attrValueVoList);
            roomDetailVo.setLabelInfoList(labelInfoList);
            roomDetailVo.setFacilityInfoList(facilityInfoList);
            roomDetailVo.setGraphVoList(graphVoList);
            roomDetailVo.setFeeValueVoList(feeValueVoList);

            System.out.println("获取房间详情"+Thread.currentThread().getName());
            //写入内存缓存
            redisTemplate.opsForValue().set(key,roomDetailVo);
        }
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        browsingHistoryService.saveHistory(userId,id);
        return roomDetailVo;
    }

    @Override   //根据公寓ID分页查询房间列表
    public IPage<RoomItemVo> pageRoomItemByApartmentId(IPage<RoomItemVo> page, Long apartmentId) {
        return roomInfoMapper.roomListByApartmentId(page,apartmentId);
    }
}




