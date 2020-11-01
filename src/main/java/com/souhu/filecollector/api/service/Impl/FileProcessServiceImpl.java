package com.souhu.filecollector.api.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.souhu.filecollector.api.controller.request.SearchFileReq;
import com.souhu.filecollector.api.controller.response.PageResult;
import com.souhu.filecollector.api.dao.UserFileItemDao;
import com.souhu.filecollector.api.entity.UserFileItem;
import com.souhu.filecollector.api.service.FileProcessService;
import com.souhu.filecollector.utils.PageUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileProcessServiceImpl implements FileProcessService {

    @Value("${filePath}")
    private String filePath;

    @Autowired
    private UserFileItemDao fileItemDao;

    @Override
    public void uploadFile(String uid, MultipartFile file) {

        String filename = file.getOriginalFilename();
        File newFile = new File(filePath + filename);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(newFile);
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        UserFileItem userFileItem = UserFileItem.builder()
                .uid(uid)
                .fileName(filename)
                .filePath(newFile.getAbsolutePath())
                .createTime(new Date())
                .build();

        fileItemDao.insert(userFileItem);
    }

    @Override
    public PageResult serchFile(SearchFileReq req) {

        int pageNum = req.getPageNum();
        int pageSize = req.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        List<UserFileItem> fileItemList = fileItemDao.queryByCondition(req);

        return PageUtils.getPageResult(new PageInfo<UserFileItem>(fileItemList));
    }
}
