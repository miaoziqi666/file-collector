package com.souhu.filecollector.api.service;

import com.souhu.filecollector.api.controller.request.SearchFileReq;
import com.souhu.filecollector.api.controller.response.PageResult;
import com.souhu.filecollector.api.entity.UserFileItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <pre>
 * desc : 文件处理接口
 * date : 2020-10-31
 * @param
 * @param
 * @return
 * <pre>
*/
public interface FileProcessService {

    /**
     * 文件上传
     * @param uid
     * @param file
     */
    void uploadFile(String uid , MultipartFile file);

    /**
     * 查询
     * @param req
     * @return
     */
    PageResult serchFile(SearchFileReq req);
}
