package person.cznno.admin.controller;

import person.cznno.admin.entity.PermissionEntity;
import person.cznno.admin.service.PermissionService;
import io.swagger.annotations.*;
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
 * 权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("admin/permission")
@Api(description = "权限CRUD",tags = "角色权限管理")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询全部权限
     *
     * @param entity 分页信息
     * @return 权限分页结果
     */
    @GetMapping
    @ApiOperation(value = "查询全部权限")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = PermissionEntity.class, responseContainer = "List"))
    public Response selectAll(PermissionEntity entity) {
        return PagedResponseFactory.get(permissionService.selectAll(entity));
    }

    /**
     * 根据id查询权限
     *
     * @param id 主键
     * @return 权限
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询权限")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = PermissionEntity.class))
    public Response selectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, permissionService.selectById(id));
    }

    /**
     * 新增权限
     *
     * @param permission 权限实体
     * @return 新增的条数
     */
    @PostMapping
    @ApiOperation(value = "新增权限")
    @ApiResponseInsert
    public Response insertOne(@RequestBody PermissionEntity permission) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, permissionService.insertSelective(permission));
    }

    /**
     * 按id修改权限
     *
     * @param permission 权限实体
     * @return 修改的条数
     */
    @PutMapping
    @ApiOperation(value = "按id修改权限")
    @ApiResponseUpdate
    public Response updateById(@RequestBody PermissionEntity permission) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, permissionService.updateByIdSelective(permission));
    }

    /**
     * 按id删除权限
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "按id删除权限")
    @ApiResponseDelete
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, permissionService.deleteById(id));
    }
}
