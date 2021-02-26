package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Page {
    private int pageSize;
    private int pageNum;
    private int rowTotal;
}
