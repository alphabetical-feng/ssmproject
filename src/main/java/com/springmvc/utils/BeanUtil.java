package com.springmvc.utils;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public class BeanUtil {


    public static <T> PagedResult<T> toPagedResult(PageInfo<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas == null) {
            result.setPageNo(0);
            result.setPageSize(0);
            result.setDataList(new ArrayList<T>());
            result.setTotal(0);
            result.setPages(0);
        } else {
            result.setPageNo(datas.getPageNum());
            result.setPageSize(datas.getPageSize());
            result.setDataList(datas.getList());
            result.setTotal(datas.getTotal());
            result.setPages(datas.getPages());
        }
        return result;
    }
}
