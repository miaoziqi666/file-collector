package com.souhu.filecollector.api.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * desc : 查询文件请求体
 * date : 2020-10-31
 * @param
 * @param
 * @return
 * <pre>
 */
@Data
public class SearchFileReq {

    /**
     * 当前页码
     */
    private int pageNum = 0;
    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 用户uid
     */
    @NotNull(message = "uid不能为空")
    private String uid;
    /**
     * 上传开始时间
     */
    @NotNull(message = "查询开始时间不能为空")
    private String startTime;

    /**
     * 上传截止时间
     */
    @NotNull(message = "查询截止时间不能为空")
    private String endTime;
}
