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
 * @Date 2017-12-03 22:42:59
 */
@Controller
@RequestMapping("/appInfo")
public class AppInfoController extends BaseController {

    private String PREFIX = "/app/appInfo/";

    @Autowired
    private IAppInfoService appInfoService;

    /**
     * 跳转到应用管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "appInfo.html";
    }

    /**
     * 跳转到添加应用管理
     */
    @RequestMapping("/appInfo_add")
    public String appInfoAdd() {
        return PREFIX + "appInfo_add.html";
    }

    /**
     * 跳转到修改应用管理
     */
    @RequestMapping("/appInfo_update/{appInfoId}")
    public String appInfoUpdate(@PathVariable Integer appInfoId, Model model) {
        AppInfo appInfo = appInfoService.selectById(appInfoId);
        model.addAttribute("item",appInfo);
        LogObjectHolder.me().set(appInfo);
        return PREFIX + "appInfo_edit.html";
    }

    /**
     * 获取应用管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return appInfoService.selectList(null);
    }

    /**
     * 新增应用管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(AppInfo appInfo) {
        appInfoService.insert(appInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除应用管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer appInfoId) {
        appInfoService.deleteById(appInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改应用管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(AppInfo appInfo) {
        appInfoService.updateById(appInfo);
        return super.SUCCESS_TIP;
    }

    /**
     * 应用管理详情
     */
    @RequestMapping(value = "/detail/{appInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("appInfoId") Integer appInfoId) {
        return appInfoService.selectById(appInfoId);
    }
}
