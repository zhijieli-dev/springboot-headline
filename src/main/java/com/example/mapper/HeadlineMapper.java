package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author zhijie
* @createDate 2026-10-30 17:09:26
* @Entity com.example.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    IPage<Map<String, Object>> selectMyPage(IPage page, @Param("portalVo") PortalVo portalVo);

    @MapKey("hid")
    Map<String, Object> queryDetailMap(Integer hid);
}




