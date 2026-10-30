package com.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class User {

    private Integer uid;

    private String username;

    private String userPwd;

    private String nickName;

    @Version
    private Integer version;

    private Integer isDeleted;
}