package com.souhu.filecollector.api.dao;

import com.souhu.filecollector.api.controller.request.SearchFileReq;
import com.souhu.filecollector.api.entity.UserFileItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (UserFileItem)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-31 13:32:02
 */
@Component
public interface UserFileItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserFileItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserFileItem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userFileItem 实例对象
     * @return 对象列表
     */
    List<UserFileItem> queryAll(UserFileItem userFileItem);

    /**
     * 新增数据
     *
     * @param userFileItem 实例对象
     * @return 影响行数
     */
    int insert(UserFileItem userFileItem);

    /**
     * 修改数据
     *
     * @param userFileItem 实例对象
     * @return 影响行数
     */
    int update(UserFileItem userFileItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<UserFileItem> queryByCondition(SearchFileReq req);

}
