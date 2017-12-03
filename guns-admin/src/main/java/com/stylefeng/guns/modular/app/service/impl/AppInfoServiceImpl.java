package com.stylefeng.guns.modular.app.service.impl;

import com.stylefeng.guns.common.persistence.model.AppInfo;
import com.stylefeng.guns.common.persistence.dao.AppInfoMapper;
import com.stylefeng.guns.modular.app.service.IAppInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-12-03
 */
@Service
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements IAppInfoService {
	
}
