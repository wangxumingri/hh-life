package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageData<T> {
    private int pageSize;
    private int pageNum;
    private int rowTotal;
    private int pageCount;
    private List<T> data;

    public PageData(int pageSize, int pageNum, int rowTotal, List<T> data) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.rowTotal = rowTotal;
        // 计算页数
        this.pageCount = (int)Math.ceil((double)rowTotal/pageSize) ;
        this.data = data;
    }
}
