package com.stylefeng.guns.modular.app.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.AppInfo;
import com.stylefeng.guns.modular.app.service.IAppInfoService;

/**
 * 应用管理控制器
 *
 * @author fengshuonan
 * @Date 2017-12-03 22:24:33
 */
@Controller
@RequestMapping("/AppInfo")
public class AppInfoController extends BaseController {

    private String PREFIX = "/app/AppInfo/";

    @Autowired
    private IAppInfoService AppInfoService;

    /**
     * 跳转到应用管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "AppInfo.html";
    }

    /**
     * 跳转到添加应用管理
     */
    @RequestMapping("/AppInfo_add")
    public String AppInfoAdd() {
        return PREFIX + "AppInfo_add.html";
    }

    /**
     * 跳转到修改应用管理
     */
    @RequestMapping("/AppInfo_update/{AppInfoId}")
    public String AppInfoUpdate(@PathVariable Integer AppInfoId, Model model) {
        AppInfo AppInfo = AppInfoService.selectById(AppInfoId);
        model.addAttribute("item",AppInfo);
        LogObjectHolder.me().set(AppInfo);
        return PREFIX + "AppInfo_edit.html";
    }

    /**
     * 获取应用管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return AppInfoService.selectList(null);
    }

    /**
     * 新增应用管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(AppInfo AppInfo) {
        AppInfoService.insert(AppInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除应用管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer AppInfoId) {
        AppInfoService.deleteById(AppInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改应用管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(AppInfo AppInfo) {
        AppInfoService.updateById(AppInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 应用管理详情
     */
    @RequestMapping(value = "/detail/{AppInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("AppInfoId") Integer AppInfoId) {
        return AppInfoService.selectById(AppInfoId);
    }
}
