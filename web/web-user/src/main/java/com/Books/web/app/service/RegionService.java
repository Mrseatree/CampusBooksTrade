package com.Books.web.app.service;

import com.Books.model.entity.Region;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RegionService extends IService<Region> {

    public String getRegionName(Long id);
}
