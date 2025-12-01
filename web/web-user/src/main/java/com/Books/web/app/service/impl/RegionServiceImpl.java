package com.Books.web.app.service.impl;

import com.Books.model.entity.Region;
import com.Books.web.app.mapper.RegionMapper;
import com.Books.web.app.service.RegionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public Region parseRegion(String regionString) {
        String[] regionInfo = regionString.split("-");
        String provinceName = regionInfo[0];
        String cityName = regionInfo[1];
        LambdaQueryWrapper<Region> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Region::getName, cityName).eq(Region::getLevel, 2);
        Region region = this.getOne(queryWrapper);
        return region;
    }
}
