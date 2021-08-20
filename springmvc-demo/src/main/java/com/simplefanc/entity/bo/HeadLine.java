package com.simplefanc.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadLine {
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
}
