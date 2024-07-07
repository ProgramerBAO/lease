package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.web.admin.vo.ApartmentItemVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentSubmitVo;

/**
* @author BobShen
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {
    // 保存或更新公寓信息 这里很好理解
    // 因为除了更新公寓的基本信息还要更新其他的配套信息
    // 基本信息使用saveOrUpdate方法 其他信息应该单独使用各自表的方法
    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);
    // 这个就是自定义了一个selectPage

    /**
     * 通过ApartmentQueryVo来分页查询公寓信息
     * 不理解看这里 <a href="https://www.bilibili.com/video/BV12R4y157Be?t=145.9&p=44">教学视频</a>
     * @param page 分页对象
     * @param apartmentQueryVo 查询条件 或者说分页的依据
     * @return 分页对象(分页后的结果)
     */
    IPage<ApartmentItemVo> pageApartmentListByQuery(IPage<ApartmentItemVo> page, ApartmentQueryVo apartmentQueryVo);

    ApartmentDetailVo getApartmentDetailById(Long id);

    void removeApartmentById(Long id);
}
