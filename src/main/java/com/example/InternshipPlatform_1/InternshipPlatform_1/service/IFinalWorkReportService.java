package com.example.InternshipPlatform_1.InternshipPlatform_1.service;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.FinalWorkReport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author harry
 * @since 2022-01-02
 */
public interface IFinalWorkReportService extends IService<FinalWorkReport> {

    boolean newOne(FinalWorkReport finalWorkReport);

    FinalWorkReport getOne(Integer id);
}
