package com.springbootProject.lease.web.app.vo.viewappointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "预约详情实体")
public class ViewAppointmentDetailVo extends ViewAppointment {
    @Schema(description = "公寓基本信息")
    private ApartmentItemVo apartmentItemVo;
}
