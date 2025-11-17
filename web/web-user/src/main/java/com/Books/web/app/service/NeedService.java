package com.Books.web.app.service;

import com.Books.model.entity.BookNeed;
import com.Books.web.app.vo.NeedDetailVo;
import com.Books.web.app.vo.NeedItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface NeedService extends IService<BookNeed> {

    void removeNeedById(String id);

    NeedDetailVo getDetailById(String id);

    IPage<NeedItemVo> getItemListById(Page<NeedItemVo>page, String userId);
}
