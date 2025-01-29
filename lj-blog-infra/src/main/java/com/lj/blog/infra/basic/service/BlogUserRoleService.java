package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Set;

/**
 * 用户角色表(BlogUserRole)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 15:15:24
 */
@Mapper
public interface BlogUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogUserRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BlogUserRole> queryByPage(BlogUserRole blogUserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    BlogUserRole insert(BlogUserRole blogUserRole);

    /**
     * 修改数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    BlogUserRole update(BlogUserRole blogUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据主键获取角色Set集合
     *
     * @param userId 用户id
     * @return 角色Set集合
     */
    Set<String> getRoleSetByUserId(Integer userId);
}
