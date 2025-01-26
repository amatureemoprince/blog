
package com.lj.blog.infra.basic.service;
import com.lj.blog.infra.basic.entity.BlogRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 博客角色表(BlogRole)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 18:17:10
 */
public interface BlogRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BlogRole> queryByPage(BlogRole blogRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    BlogRole insert(BlogRole blogRole);

    /**
     * 修改数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    BlogRole update(BlogRole blogRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
