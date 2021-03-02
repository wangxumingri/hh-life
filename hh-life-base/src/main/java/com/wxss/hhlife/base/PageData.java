package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



public class PageData<T> {
    private int pageSize;
    private int pageNum;
    private int rowTotal;
    private int pageCount;
    private List<T> data;

    public PageData() {
    }

    public PageData(int pageSize, int pageNum, int rowTotal, List<T> data) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.rowTotal = rowTotal;
        // 计算页数
        this.pageCount = (int)Math.ceil((double)rowTotal/pageSize) ;
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(int rowTotal) {
        this.rowTotal = rowTotal;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageCount(){
        this.pageCount = (int)Math.ceil((double)rowTotal/pageSize);
    }
}
