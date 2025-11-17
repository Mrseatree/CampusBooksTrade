package com.Books.web.app.mapper;

import com.Books.model.entity.BookNeed;
import com.Books.web.app.vo.NeedItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface NeedMapper extends BaseMapper<BookNeed> {

    IPage<NeedItemVo> getItemListById(Page<NeedItemVo> page, String userId);
}
