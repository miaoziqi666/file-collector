package com.souhu.filecollector.api.controller;

import com.souhu.filecollector.api.controller.request.SearchFileReq;
import com.souhu.filecollector.api.controller.response.PageResult;
import com.souhu.filecollector.api.entity.UserFileItem;
import com.souhu.filecollector.api.service.FileProcessService;
import com.souhu.filecollector.common.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/file")
public class FileProcessController {


    @Autowired
    private FileProcessService fileProcessService;

    /**
     * 文件上传及保存接口
     *
     * @param uid
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public RespData upload(@RequestParam(value = "uid",required = false) String uid,
                           @RequestParam("file") MultipartFile file) {

        if (StringUtils.isEmpty(uid)) {
            return RespData.fail("uid不能为空");
        }
        if (file == null) {
            return RespData.fail("文件不能为空");
        }

        fileProcessService.uploadFile(uid, file);
        return RespData.ok();
    }

    /**
     * 文件查询接口
     *
     * @param req
     * @param results
     * @return
     */
    @PostMapping("/search")
    public RespData search(@Valid @RequestBody SearchFileReq req, BindingResult results) {

        if (results.hasErrors()) {
            return RespData.fail(Objects.requireNonNull(results.getFieldError()).getDefaultMessage());
        }

        PageResult response = fileProcessService.serchFile(req);

        return RespData.ok(response);
    }
}
