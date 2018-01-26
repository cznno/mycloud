package person.cznno.admin.service;

import person.cznno.admin.entity.PermissionEntity;
import person.cznno.admin.entity.RolePermissionEntity;
import person.cznno.admin.entity.UserEntity;
import person.cznno.admin.entity.UserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 权限控制
 * Created by cznno
 * Date: 18-1-9
 */
public interface AccessControlService {

    /**
     * 修改角色-权限关联
     *
     * @param rolePermissionList 角色权限List
     * @return 修改的条数
     */
    int updateRolePermissionRelations(List<RolePermissionEntity> rolePermissionList);

    /**
     * 修改角色-菜单关联
     *
     * @param userRoleList 角色菜单List
     * @return 修改的条数
     */
    int updateUserRoleRelations(List<UserRoleEntity> userRoleList);

    /**
     * 查询所有用户,按角色id区分是否有角色,分为两组
     *
     * @param roleId 角色id
     * @return Boolean 有无权限, List 用户
     */
    Map<Boolean, List<UserEntity>> selectUserGroupByRoleId(Integer roleId);

    /**
     * 按角色id查询全部权限，并按照是否有权限分类
     *
     * @param roleId 角色id
     * @return 权限信息
     */
    Map<Boolean, List<PermissionEntity>> selectPermissionGroupByRoleId(Integer roleId);
}
