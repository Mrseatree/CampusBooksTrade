package com.Books.web.app.service;

import com.Books.model.entity.BookNeed;
import com.Books.web.app.vo.NeedDetailVo;
import com.Books.web.app.vo.NeedItemQueryVo;
import com.Books.web.app.vo.NeedItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface NeedService extends IService<BookNeed> {

    void updateNeed(BookNeed bookNeed);

    void removeNeedById(Long id);

    NeedDetailVo getDetailById(Long id);

    IPage<NeedItemVo> getItemListById(Page<NeedItemVo>page, Long userId);

    IPage<NeedItemVo> getNeedList(Page<NeedItemVo>page, NeedItemQueryVo queryVo);
}
