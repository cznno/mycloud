package person.cznno.admin.service;

import person.cznno.admin.entity.RolePermissionEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 角色权限业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface RolePermissionService {

    /**
     * 查询所有角色权限
     *
     * @param entity 分页参数
     * @return 分页查询结果
     */
    PageInfo<RolePermissionEntity> selectAll(RolePermissionEntity entity);

    /**
     * 按id查询角色权限
     *
     * @param id 主键
     * @return 角色权限实体
     */
    RolePermissionEntity selectById(Integer id);

    /**
     * 按角色id查询角色权限
     * @param roleId 角色id
     * @return 角色权限实体集合
     */
    List<RolePermissionEntity> selectByRoleId(Integer roleId);

    /**
     * 插入角色权限
     *
     * @param entity 角色权限实体
     * @return 插入结果数
     */
    int insertSelective(RolePermissionEntity entity);

    /**
     * 批量插入角色权限
     *
     * @param rolePermissionList 角色权限实体
     * @return 插入结果数
     */
    int insertBatchSelective(List<RolePermissionEntity> rolePermissionList);

    /**
     * 按id更新角色权限
     *
     * @param entity 角色权限实体
     * @return 更新结果数
     */
    int updateByIdSelective(RolePermissionEntity entity);

    /**
     * 按id删除角色权限
     *
     * @param id 主键
     * @return 删除结果数
     */
    int deleteById(Integer id);

    /**
     * 从角色权限List中取出id, 批量删除角色权限
     * @param rolePermissionList 角色权限集合
     * @return 删除数量
     */
    int deleteBatchByRoleId(List<RolePermissionEntity> rolePermissionList);
}
