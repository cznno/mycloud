package person.cznno.admin.controller;

import person.cznno.admin.entity.UserRoleEntity;
import person.cznno.admin.service.UserRoleService;
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
 * 用户角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("admin/user_role")
@Api(description = "用户角色关联CRUD", tags = "角色权限管理")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {this.userRoleService = userRoleService;}

    /**
     * 查询所有用户角色关联
     *
     * @param entity 分页参数
     * @return 用户角色分页信息
     */
    @GetMapping
    @ApiOperation(value = "查询所有用户角色关联")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = UserRoleEntity.class, responseContainer = "List"))
    public Response selectAll(UserRoleEntity entity) {
        return PagedResponseFactory.get(userRoleService.selectAll(entity));
    }

    /**
     * 根据id查询用户角色关联
     *
     * @param id 主键
     * @return 用户角色关联实体
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询用户角色关联")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = UserRoleEntity.class))
    public Response selectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, userRoleService.selectById(id));
    }

    /**
     * 新增用户角色关联
     *
     * @param userRole 用户角色关联实体
     * @return 新增的条数
     */
    @PostMapping
    @ApiOperation(value = "新增用户角色关联")
    @ApiResponseInsert
    public Response insertOne(UserRoleEntity userRole) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, userRoleService.insertSelective(userRole));
    }

    /**
     * 更新用户角色关联
     *
     * @param userRole 用户角色关联实体
     * @return 更新的条数
     */
    @PutMapping
    @ApiOperation(value = "更新用户角色关联")
    @ApiResponseUpdate
    public Response updateById(@RequestBody UserRoleEntity userRole) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, userRoleService.updateByIdSelective(userRole));
    }

    /**
     * 按id删除用户角色关联
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "按id删除用户角色关联")
    @ApiResponseDelete
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, userRoleService.deleteById(id));
    }
}
