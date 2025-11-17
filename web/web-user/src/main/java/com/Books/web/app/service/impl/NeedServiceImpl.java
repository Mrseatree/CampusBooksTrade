package com.Books.web.app.service.impl;

import com.Books.common.exception.BookException;
import com.Books.common.result.ResultCodeEnum;
import com.Books.model.entity.BookNeed;
import com.Books.model.entity.BookService;
import com.Books.model.enums.NeedStatus;
import com.Books.web.app.mapper.NeedGraphMapper;
import com.Books.web.app.mapper.NeedMapper;
import com.Books.web.app.mapper.ServiceMapper;
import com.Books.web.app.service.RegionService;
import com.Books.web.app.service.UserService;
import com.Books.web.app.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Books.web.app.service.NeedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class NeedServiceImpl extends ServiceImpl<NeedMapper,BookNeed>
    implements NeedService {

    @Autowired
    private NeedMapper needMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private NeedGraphMapper needGraphMapper;

    @Autowired
    private RegionService regionService;

    @Autowired
    private UserService userService;

    @Override
    public void removeNeedById(String id) {
        BookNeed bookNeed = this.getById(id);
        if(bookNeed.getStatus()!=NeedStatus.PUBLIC){
            throw new BookException(ResultCodeEnum.NEED_DOES_NOT_PUBLIC);
        }

        LambdaQueryWrapper<BookService> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookService::getNeedId, id);
        Long count=serviceMapper.selectCount(queryWrapper);

        if(count>0){
            throw new BookException(ResultCodeEnum.NEED_HAS_SERVICE);
        }

        //可以删除我需要
        this.removeById(id);

    }

    @Override
    public NeedDetailVo getDetailById(String id) {
        //获取我需要信息
        BookNeed bookNeed = needMapper.selectById(id);

        //ToDo:User的服务需提供一个根据用户id返回头像及昵称的接口
        //获取用户昵称及头像
        String userId=bookNeed.getUserId();
        UserVo userVo = new UserVo();

        //ToDo:图片模块需提供一个根据我服务id返回相关图片列表的接口
        //查询图片
        List<GraphVo>graphVoList=new ArrayList<>();

        //ToDo:我服务模块需提供一个能够根据需求id返回对应列表的接口
        //查询我服务列表
        List<ServiceVo>serviceVoList=new ArrayList<ServiceVo>();

        //根据地区id查询地区名称
        String regionId=bookNeed.getRegionId();
        String regionName=regionService.getRegionName(regionId);

        //组装
        NeedDetailVo needDetailVo=new NeedDetailVo();
        BeanUtils.copyProperties(bookNeed,needDetailVo);
        needDetailVo.setRegionName(regionName);
        needDetailVo.setUserVo(userVo);
        needDetailVo.setGraphVoList(graphVoList);
        needDetailVo.setServiceVoList(serviceVoList);

        return null;
    }

    @Override
    public IPage<NeedItemVo> getItemListById(Page<NeedItemVo>page,String userId) {
        return needMapper.getItemListById(page,userId);
    }
}
