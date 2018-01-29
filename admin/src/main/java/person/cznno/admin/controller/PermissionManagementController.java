package person.cznno.admin.controller;

import person.cznno.admin.entity.PermissionEntity;
import person.cznno.admin.entity.RolePermissionEntity;
import person.cznno.admin.entity.UserEntity;
import person.cznno.admin.entity.UserRoleEntity;
import person.cznno.admin.service.AccessControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.common.annotation.ApiResponseUpdate;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.CrudStatusEnum;
import person.cznno.common.factory.CrudResponseFactory;

import java.util.List;

/**
 * 权限控制
 * Created by cznno
 * Date: 18-1-9
 */
@Slf4j
@RestController
@RequestMapping("/admin/access_control")
@Api(description = "权限控制", tags = "角色权限管理")
public class PermissionManagementController {

    @Autowired
    private AccessControlService accessControlService;

    /**
     * 修改角色-权限关联
     *
     * @param rolePermissionList 角色权限List
     * @return 修改的条数
     */
    @PutMapping("user_role")
    @ApiOperation(value = "修改角色-权限关联")
    @ApiResponseUpdate
    public Response updateRolePermissionRelations(@RequestBody List<RolePermissionEntity> rolePermissionList) {
        return CrudResponseFactory.get(
                CrudStatusEnum.UPDATE,
                accessControlService.updateRolePermissionRelations(rolePermissionList));
    }

    /**
     * 修改用户-角色关联
     *
     * @param userRoleList 用户角色List
     * @return 修改的条数
     */
    @PutMapping("role_menu")
    @ApiOperation(value = "修改用户-角色关联")
    @ApiResponseUpdate
    public Response updateUserRoleRelations(@RequestBody List<UserRoleEntity> userRoleList) {
        return CrudResponseFactory.get(
                CrudStatusEnum.UPDATE,
                accessControlService.updateUserRoleRelations(userRoleList));
    }

    /**
     * 查询所有用户并按角色id分类
     *
     * @param roleId 角色id
     * @return 用户角色分组
     */
    @GetMapping("user_role/{id}")
    @ApiOperation(value = "查询所有用户并按角色id分类")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = UserEntity.class, responseContainer = "Map"))
    public Response selectUserGroupByRoleId(@PathVariable("id") Integer roleId) {
        return CrudResponseFactory.get(
                CrudStatusEnum.SELECT,
                accessControlService.selectUserGroupByRoleId(roleId));
    }

    /**
     * 按角色id查询全部菜单，并按照是否有权限标注
     *
     * @param roleId 角色id
     * @return 角色权限分组
     */
    @GetMapping("role_menu/{id}")
    @ApiOperation(value = "按角色id查询全部菜单，并按照是否有权限标注")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = PermissionEntity.class, responseContainer = "Map"))
    public Response selectPermissionGroupByRoleId(@PathVariable("id") Integer roleId) {
        return CrudResponseFactory.get(
                CrudStatusEnum.SELECT,
                accessControlService.selectPermissionGroupByRoleId(roleId));
    }
}
