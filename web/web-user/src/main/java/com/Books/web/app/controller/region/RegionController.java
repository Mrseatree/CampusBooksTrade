package com.Books.web.app.controller.region;

import com.Books.common.result.Result;
import com.Books.model.entity.Region;
import com.Books.web.app.service.RegionService;
import com.Books.web.app.vo.RegionSimpleVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/region")
@Tag(name="地区数据")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Operation(summary = "获取城市列表",description = "返回所有城市")
    @PostMapping("cities")
    public Result getCities(@RequestParam Long provinceId) {
        List<Region> list = regionService.list(
                Wrappers.<Region>lambdaQuery()
                        .eq(Region::getLevel, 2)
                        .eq(Region::getParentId, provinceId)
        );

        List<RegionSimpleVo> result = list.stream().map(r -> {
            RegionSimpleVo vo = new RegionSimpleVo();
            vo.setId(r.getId());
            vo.setName(r.getName());
            return vo;
        }).toList();

        return Result.ok(result);
    }

    @Operation(summary = "获取省份列表",description = "返回所有省份")
    @PostMapping("provinces")
    public Result getProvince() {
        List<Region> list = regionService.list(
                Wrappers.<Region>lambdaQuery()
                        .eq(Region::getLevel, 1)
                        .eq(Region::getParentId, 0)
        );

        List<RegionSimpleVo> result = list.stream().map(r -> {
            RegionSimpleVo vo = new RegionSimpleVo();
            vo.setId(r.getId());
            vo.setName(r.getName());
            return vo;
        }).toList();

        return Result.ok(result);
    }
}
