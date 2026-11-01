package com.example.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.example.pojo.Headline;
import com.example.pojo.vo.PortalVo;
import com.example.utils.Result;

/**
 * @author zhijie
 * @createDate 2026-10-30 17:09:26
 */
public interface HeadlineService extends IService<Headline> {
    Result findNewsPage(PortalVo portalVo);
    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline, String token);
    Result updateData(Headline headline);
}