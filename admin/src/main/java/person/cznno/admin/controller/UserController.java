package person.cznno.admin.controller;

import person.cznno.admin.entity.UserEntity;
import person.cznno.admin.service.UserService;
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
import person.cznno.common.exception.CrudStatusEnum;
import person.cznno.common.factory.CrudResponseFactory;
import person.cznno.common.factory.PagedResponseFactory;

/**
 * 用户CRUD
 * Created by cznno
 * Date: 17-12-28
 */
@RestController
@RequestMapping("/admin/user")
@Api(description = "用户CRUD", tags = "角色权限管理")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     *
     * @param entity 分页参数
     * @return 用户分页信息
     */
    //    @RequiresPermissions("article:list")
    @GetMapping
    @ApiOperation(value = "查询全部用户")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = UserEntity.class, responseContainer = "List"))
    public Response selectAll(UserEntity entity) {
        return PagedResponseFactory.get(userService.selectAll(entity));
    }

    /**
     * 按id查询用户
     *
     * @param id 主键
     * @return 用户实体
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "按id查询用户")
    @ApiResponses(@ApiResponse(code = 200, message = "查询结果", response = UserEntity.class))
    public Response selectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, userService.selectById(id));
    }

    /**
     * 新增用户
     *
     * @param entity 用户实体
     * @return 新增的条数
     */
    @PostMapping
    @ApiOperation(value = "新增一个用户")
    @ApiResponseInsert
    public Response insertOne(@RequestBody UserEntity entity) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, userService.insertSelective(entity));
    }

    /**
     * 更新用户
     *
     * @param entity 用户实体
     * @return 更新的条数
     */
    @PutMapping
    @ApiOperation(value = "更新一个用户")
    @ApiResponseUpdate
    public Response updateById(@RequestBody UserEntity entity) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, userService.updateByIdSelective(entity));
    }

    /**
     * 按id删除用户
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "按id删除用户")
    @ApiResponseDelete
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, userService.deleteById(id));
    }
}
