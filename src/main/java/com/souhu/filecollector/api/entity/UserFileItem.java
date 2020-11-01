package com.souhu.filecollector.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserFileItem)实体类
 *
 * @author makejava
 * @since 2020-10-31 13:32:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFileItem implements Serializable {
    private static final long serialVersionUID = -18375371093961196L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String uid;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件存储路径
     */
    private String filePath;
    /**
     * 创建时间
     */
    private Date createTime;

}
