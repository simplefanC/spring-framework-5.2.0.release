package com.simplefanc.service.impl;

import com.simplefanc.entity.bo.HeadLine;
import com.simplefanc.entity.dto.Result;
import com.simplefanc.service.HeadLineService;
import org.springframework.stereotype.Service;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
//        log.info("addHeadLine执行了, lineName[{}], lineLink[{}], lineImg[{}], priority[{}]",
//                headLine.getLineName(), headLine.getLineLink(), headLine.getLineImg(), headLine.getPriority());
        Result<Boolean> result = new Result<>();
        result.setData(true);
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }
}
