package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.pojo.Headline;
import com.example.pojo.vo.PortalVo;
import com.example.service.HeadlineService;
import com.example.mapper.HeadlineMapper;
import com.example.utils.JwtHelper;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline> implements HeadlineService {

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;

    // Retrieve headlines with pagination
    @Override
    public Result findNewsPage(PortalVo portalVo) {
        IPage<Map<String, Object>> page = new Page<>(portalVo.getPageNum(), portalVo.getPageSize());
        headlineMapper.selectMyPage(page, portalVo);

        List<Map<String, Object>> records = page.getRecords();

        Map<String, Object> data = new HashMap<>();
        data.put("pageData", records);
        data.put("pageNum", page.getCurrent());
        data.put("pageSize", page.getSize());
        data.put("totalPage", page.getPages());
        data.put("totalSize", page.getTotal());

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageInfo", data);

        return Result.ok(pageInfo);
    }

    // Retrieve headline details and update its view count
    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map<String, Object> data = headlineMapper.queryDetailMap(hid);

        Map<String, Object> headlineMap = new HashMap<>();
        headlineMap.put("headline", data);

        Headline headline = new Headline();
        headline.setHid((Integer) data.get("hid"));
        headline.setVersion((Integer) data.get("version"));
        headline.setPageViews((Integer) data.get("pageViews") + 1);

        headlineMapper.updateById(headline);

        return Result.ok(headlineMap);
    }

    // Publish a new headline
    @Override
    public Result publish(Headline headline, String token) {
        int userId = jwtHelper.getUserId(token).intValue();

        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);

        return Result.ok(null);
    }

    // Update an existing headline
    @Override
    public Result updateData(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();

        headline.setVersion(version);
        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}