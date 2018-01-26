package person.cznno.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;
import person.cznno.admin.entity.PermissionEntity;
import person.cznno.admin.entity.RolePermissionEntity;
import person.cznno.admin.entity.UserEntity;
import person.cznno.admin.entity.UserRoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import person.cznno.admin.service.*;
import person.cznno.common.exception.ParamErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 权限控制实现
 * Created by cznno
 * Date: 18-1-9
 */
@Service
@Slf4j
@Transactional
public class AccessControlServiceImpl implements AccessControlService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public int updateRolePermissionRelations(List<RolePermissionEntity> rolePermissionList) {

        int insRes = 0;
        Boolean doUpdate = true;

        try {
            for (RolePermissionEntity rolePermission : rolePermissionList) {
                if (null == rolePermission.getPermissionId())
                    doUpdate = false;
                if (null == rolePermission.getRoleId())
                    throw new ParamErrorException();
            }
            int delRes = rolePermissionService.deleteBatchByRoleId(rolePermissionList);
            log.info("删除角色菜单关联数据：" + delRes + "条");

            if (doUpdate) {
                insRes = rolePermissionService.insertBatchSelective(rolePermissionList);
                log.info("增加角色菜单关联数据：" + insRes + "条");
            }
        } catch (Exception e) {
            log.error("修改用户-角色关联失败", e);
        }
        return insRes;
    }

    @Override
    public int updateUserRoleRelations(List<UserRoleEntity> userRoleList) {

        int insRes = 0;
        Boolean doUpdate = true;
        try {

            for (UserRoleEntity userRole : userRoleList) {
                if (null == userRole.getUserId())
                    doUpdate = false;
                if (null == userRole.getRoleId())
                    throw new ParamErrorException();
            }

            int delRes = userRoleService.deleteBatchByRoleId(userRoleList);
            log.info("删除角色菜单关联数据：" + delRes + "条");

            if (doUpdate) {
                insRes = userRoleService.insertBatch(userRoleList);
                log.info("增加角色菜单关联数据：" + insRes + "条");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insRes;
    }

    @Override
    public Map<Boolean, List<UserEntity>> selectUserGroupByRoleId(Integer roleId) {

        List<UserRoleEntity> userRoleList = new ArrayList<>(userRoleService.selectByRoleId(roleId));

        List<Integer> userIdList = userRoleList.stream()
                .map(UserRoleEntity::getUserId)
                .collect(Collectors.toList());

        List<UserEntity> userList = new ArrayList<>(userService.selectAll(0, 0).getList());

        return userList.stream()
                .collect(Collectors.partitioningBy(o -> userIdList.contains(o.getId())));
    }

    @Override
    public Map<Boolean, List<PermissionEntity>> selectPermissionGroupByRoleId(@RequestParam("id") Integer roleId) {

        List<Integer> menuIdList =
                rolePermissionService.selectByRoleId(roleId).stream()
                        .map(RolePermissionEntity::getPermissionId)
                        .collect(Collectors.toList());

        List<PermissionEntity> permissionList = permissionService.selectAll(0, 0).getList();

        return permissionList
                .stream()
                .collect(Collectors.partitioningBy(o -> menuIdList.contains(o.getId())));
    }
}
