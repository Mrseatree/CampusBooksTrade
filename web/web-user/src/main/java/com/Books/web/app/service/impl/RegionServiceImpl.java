package com.Books.web.app.service.impl;

import com.Books.model.entity.Region;
import com.Books.web.app.mapper.RegionMapper;
import com.Books.web.app.service.RegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region>
implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public String getRegionName(Long id) {
        Region region = regionMapper.selectById(id);
        return region.getName();
    }
}
