package person.cznno.admin.controller;

import person.cznno.admin.entity.RoleEntity;
import person.cznno.admin.service.RoleService;
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
 * 角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("/admin/role")
@Api(description = "角色CRUD", tags = "角色权限管理")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {this.roleService = roleService;}

    /**
     * 查询全部角色
     *
     * @param entity 分页参数
     * @return 角色分页结果
     */
    @GetMapping
    @ApiOperation(value = "查询全部角色")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = RoleEntity.class, responseContainer = "List"))
    public Response selectAll(RoleEntity entity) {
        return PagedResponseFactory.get(roleService.selectAll(entity));
    }

    /**
     * 按id查询角色
     *
     * @param id 主键
     * @return 角色实体
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "按id查询角色")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = RoleEntity.class))
    public Response selectById(@PathVariable("id") Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, roleService.selectById(id));
    }

    /**
     * 新增角色
     *
     * @param role 角色实体
     * @return 增加的条数
     */
    @PostMapping
    @ApiOperation(value = "新增角色")
    @ApiResponseInsert
    public Response insertOne(@RequestBody RoleEntity role) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, roleService.insertSelective(role));
    }

    /**
     * 按id修改角色
     *
     * @param role 角色实体
     * @return 修改的条数
     */
    @PutMapping
    @ApiOperation(value = "按id修改角色")
    @ApiResponseUpdate
    public Response updateById(@RequestBody RoleEntity role) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, roleService.updateByIdSelective(role));
    }

    /**
     * 按id删除角色
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "按id删除角色")
    @ApiResponseDelete
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, roleService.deleteById(id));
    }
}
