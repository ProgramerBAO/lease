package com.springbootProject.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springbootProject.lease.model.entity.LeaseAgreement;
import com.springbootProject.lease.model.enums.LeaseStatus;
import com.springbootProject.lease.web.admin.service.LeaseAgreementService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//定时任务，每天00:00:00执行一次 检查租约状态是否到期
@Component
public class ScheduledTasks {
    @Resource
    private LeaseAgreementService leaseAgreementService;

    /**
     * @discription: 检查租约状态是否到期 实现方式是将租约的到期时间与当前时间对比,检查是否过期
     */
    @Scheduled(cron = "* 30 17 * * ?") // 每天17:03:00执行
    public void checkLeaseStatus() {
        System.out.println("检查租约状态");
        Date now = new Date();
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED)
                .in(LeaseAgreement::getStatus, LeaseStatus.SIGNED,LeaseStatus.WITHDRAWING)
                .le(LeaseAgreement::getLeaseEndDate, now)
                ;
        leaseAgreementService.update(updateWrapper);
    }
}
