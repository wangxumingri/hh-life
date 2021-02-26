package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseFacadePageResp<T> extends BaseFacadeResp<T> {
    private int pageSize;
    private int pageNum;
    private int rowTotal;

    public BaseFacadePageResp(Boolean success, String requestId, T data,Page page) {
        super(success,requestId,data);
        this.pageSize = page.getPageSize();
        this.pageNum = page.getPageNum();
        this.rowTotal = page.getRowTotal();
    }
}
