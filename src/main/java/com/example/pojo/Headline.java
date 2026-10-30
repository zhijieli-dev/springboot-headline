package com.example.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Headline {

    private Integer hid;

    private String title;

    private String article;

    private Integer type;

    private Integer publisher;

    private Integer pageViews;

    private Date createTime;

    private Date updateTime;

    @Version
    private Integer version;

    private Integer isDeleted;
}