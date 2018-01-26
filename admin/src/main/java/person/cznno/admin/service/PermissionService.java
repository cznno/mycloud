package person.cznno.admin.service;

import person.cznno.admin.entity.PermissionEntity;
import com.github.pagehelper.PageInfo;

/**
 * 权限业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface PermissionService {

    /**
     * 查询所有权限
     * @param entity 分页参数
     * @return 权限分页查询结果
     */
    PageInfo<PermissionEntity> selectAll(PermissionEntity entity);

    /**
     * 查询所有权限
     * @param page 页码
     * @param rows 每页大小
     * @return 权限分页查询结果
     */
    PageInfo<PermissionEntity> selectAll(int page, int rows);

    /**
     * 按id查询权限
     *
     * @param id 主键
     * @return 权限实体
     */
    PermissionEntity selectById(Integer id);

    /**
     * 插入权限
     * @param entity 权限实体
     * @return 插入结果数
     */
    int insertSelective(PermissionEntity entity);

    /**
     * 按id更新权限
     * @param entity 权限实体
     * @return 更新结果数
     */
    int updateByIdSelective(PermissionEntity entity);

    /**
     * 按id删除权限
     * @param id 主键
     * @return 删除结果数
     */
    int deleteById(Integer id);
}