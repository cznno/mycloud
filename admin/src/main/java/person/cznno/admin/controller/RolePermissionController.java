package person.cznno.admin.controller;

import person.cznno.admin.entity.RolePermissionEntity;
import person.cznno.admin.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.common.annotation.ApiResponseDelete;
import person.cznno.common.annotation.ApiResponseInsert;
import person.cznno.common.annotation.ApiResponseUpdate;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.CrudStatusEnum;
import person.cznno.common.factory.CrudResponseFactory;
import person.cznno.common.factory.PagedResponseFactory;

/**
 * 角色权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("/admin/role_permission")
@Api(description = "角色权限关联CRUD", tags = "角色权限管理")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionController(RolePermissionService rolePermissionService) {this.rolePermissionService = rolePermissionService;}

    /**
     * 查询所有角色权限
     *
     * @param entity 角色权限实体
     * @return 分页角色权限
     */
    @GetMapping
    @ApiOperation(value = "查询所有角色权限")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = RolePermissionEntity.class, responseContainer = "List"))
    public Response selectAll(RolePermissionEntity entity) {
        return PagedResponseFactory.get(rolePermissionService.selectAll(entity));
    }

    /**
     * 根据id查询权限
     *
     * @param id 主键
     * @return 角色权限实体
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询权限")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = RolePermissionEntity.class))
    public Response selectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, rolePermissionService.selectById(id));
    }

    /**
     * 新增角色权限
     *
     * @param rolePermission 角色权限实体
     * @return 新增条数
     */
    @PostMapping
    @ApiOperation(value = "新增角色权限")
    @ApiResponseInsert
    public Response insertOne(@RequestBody RolePermissionEntity rolePermission) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, rolePermissionService.insertSelective(rolePermission));
    }

    /**
     * 按id修改角色权限
     *
     * @param rolePermission 角色权限实体
     * @return 修改条数
     */
    @PutMapping
    @ApiOperation(value = "按id修改角色权限")
    @ApiResponseUpdate
    public Response updateById(@RequestBody RolePermissionEntity rolePermission) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, rolePermissionService.updateByIdSelective(rolePermission));
    }

    /**
     * 按id删除角色权限
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "按id删除角色权限")
    @ApiResponseDelete
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, rolePermissionService.deleteById(id));
    }
}
