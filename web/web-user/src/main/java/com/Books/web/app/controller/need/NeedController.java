package com.Books.web.app.controller.need;


import com.Books.model.entity.BookNeed;
import com.Books.web.app.service.NeedService;
import com.Books.web.app.vo.NeedDetailVo;
import com.Books.web.app.vo.NeedItemQueryVo;
import com.Books.web.app.vo.NeedItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Books.common.result.Result;

import java.util.List;


@RestController
@RequestMapping("/app/needs")
@Tag(name="我需要")
public class NeedController {

    @Autowired
    private NeedService needService;


    @Operation(summary = "保存新需求",description = "新增需求")
    @PostMapping("save")
    public Result save(BookNeed bookNeed) {
        needService.save(bookNeed);
        return Result.ok();
    }

    @Operation(summary = "更改需求",description = "用于在没有服务响应时修改需求")
    @PostMapping("update")
    public Result update(@RequestBody BookNeed bookNeed) {
        needService.updateNeed(bookNeed);
        return Result.ok();
    }

    @Operation(summary = "删除已发布且无响应的我需要",description = "删除需求")
    @PostMapping("deleteById")
    public Result deleteById(@RequestParam Long id) {
        needService.removeNeedById(id);
        return Result.ok();
    }

    @Operation(summary = "查看需求详情",description = "根据需求Id查看需求详情")
    @GetMapping("getDetailNeedById")
    public Result<NeedDetailVo> getDetailNeedById(@RequestParam Long id){
        NeedDetailVo result=needService.getDetailById(id);
        return Result.ok(result);
    }

    @Operation(summary = "查看我的需求",description = "根据用户id分页查看需求列表")
    @GetMapping("getNeedListByUserId")
    public Result<IPage<NeedItemVo>> getNeedListByUserId(@RequestParam Long userId,@RequestParam Long current,@RequestParam Long size){
        Page<NeedItemVo> page = new Page<>(current,size);
        IPage<NeedItemVo> result=needService.getItemListById(page,userId);
        return Result.ok(result);
    }

    @Operation(summary="查询全部需求",description="根据条件查询我需要列表")
    @PostMapping("getNeedList")
    public Result<IPage<NeedItemVo>> getNeedList(@RequestParam long current, @RequestParam long size, NeedItemQueryVo queryVo){
        Page<NeedItemVo>page=new Page<>(current,size);
        IPage<NeedItemVo>result=needService.getNeedList(page,queryVo);
        return Result.ok(result);
    }
}
