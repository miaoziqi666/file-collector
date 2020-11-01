package com.souhu.filecollector.api.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * desc : 文件上传请求体
 * date : 2020-10-31
 * <pre>
*/
@Data
public class UploadFileReq {

    /**
     * 用户uid
     */
    @NotNull(message = "uid不能为空")
    private String uid;
    /**
     * 文件名称
     */
    @NotNull(message = "文件名称不能为空")
    private String fileName;
}
