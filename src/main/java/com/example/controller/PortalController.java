package com.example.controller;

import com.example.pojo.vo.PortalVo;
import com.example.service.HeadlineService;
import com.example.service.TypeService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes() {
        return typeService.findAllTypes();
    }

    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo) {
        return headlineService.findNewsPage(portalVo);
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid) {
        return headlineService.showHeadlineDetail(hid);
    }
}