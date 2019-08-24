package com.springmvc.utils;

import com.github.pagehelper.PageInfo;

public class BeanUtil {


    public static <T> PagedResult<T> toPagedResult(PageInfo<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        result.setPageNo(datas.getPageNum());
        result.setPageSize(datas.getPageSize());
        result.setDataList(datas.getList());
        result.setTotal(datas.getTotal());
        result.setPages(datas.getPages());
        return result;
    }
}
