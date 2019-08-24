package com.springmvc.utils;

import java.io.Serializable;
import java.util.List;

public class PagedResult<T> implements Serializable {

    private List<T> data;

    private long pageNo;

    private long pageSize;

    private long total;

    private long pages;

    public List<T> getDataList() {
        return data;
    }

    public void setDataList(List<T> data) {
        this.data = data;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
