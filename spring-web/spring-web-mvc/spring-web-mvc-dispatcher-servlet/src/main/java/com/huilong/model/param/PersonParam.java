package com.huilong.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
@ApiModel(description = "人员")
public class PersonParam {

    @ApiModelProperty(value = "人员 id")
    private Integer id;

    @ApiModelProperty(value = "人员名称")
    private String name;
}
