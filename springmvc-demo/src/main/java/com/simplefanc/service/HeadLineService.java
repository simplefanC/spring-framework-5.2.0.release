package com.simplefanc.service;

import com.simplefanc.entity.bo.HeadLine;
import com.simplefanc.entity.dto.Result;

public interface HeadLineService {
    /**
     * 添加
     *
     * @param headLine
     * @return
     */
    Result<Boolean> addHeadLine(HeadLine headLine);
}
