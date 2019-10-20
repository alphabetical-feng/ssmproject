package com.springmvc.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class PageUtil {

    private static final int DEFAULT_NO = 1;
    private static final int DEFAULT_PAGE = 20;

    /**
     * 分页返回结果封装
     *
     * @param datas
     * @param <T>
     * @return
     */
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

    public static void startPages(int pageNo, int pageSize) {
        pageNo = pageNo == 0 ? DEFAULT_NO : pageNo;
        pageSize = pageSize == 0 ? DEFAULT_PAGE : pageSize;
        PageHelper.startPage(pageNo, pageSize);
    }

    public static void startPages(String pageNo, String pageSize) {
        int pageNos = 0;
        int pageSizes = 0;
        if (StringUtils.isEmpty(pageNo)) {
            pageNos = Integer.parseInt(pageNo);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSizes = Integer.parseInt(pageSize);
        }
        startPages(pageNos, pageSizes);
    }

    public static void startPages(int pageNo, int pageSize, String orderBy) {
        pageNo = pageNo == 0 ? DEFAULT_NO : pageNo;
        pageSize = pageSize == 0 ? DEFAULT_PAGE : pageSize;
        PageHelper.startPage(pageNo, pageSize, orderBy);
    }

    public static void startPages(String pageNo, String pageSize, String orderBy) {
        int pageNos = 0;
        int pageSizes = 0;
        if (StringUtils.isEmpty(pageNo)) {
            pageNos = Integer.parseInt(pageNo);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSizes = Integer.parseInt(pageSize);
        }
        startPages(pageNos, pageSizes, orderBy);
    }

}
