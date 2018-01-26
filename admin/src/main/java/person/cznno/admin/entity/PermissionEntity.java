package person.cznno.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.common.entity.BaseEntity;

import javax.persistence.Table;

/**
 * 权限
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_permission")
@ApiModel(value = "权限实体")
public class PermissionEntity extends BaseEntity {

    //归属菜单,前端判断并展示菜单使用
    @ApiModelProperty(value = "归属菜单,前端判断并展示菜单使用")
    private String menuCode;
    //菜单的中文释义
    @ApiModelProperty(value = "菜单的中文释义")
    private String menuName;
    //权限的代码/通配符,对应代码中@RequiresPermissions 的value
    @ApiModelProperty(value = "权限的代码/通配符")
    private String permissionCode;
    //本权限的中文释义
    @ApiModelProperty(value = "本权限的中文释义")
    private String permissionName;
    //是否本菜单必选权限, 1.必选 0非必选 通常是"列表"权限是必选
    @ApiModelProperty(value = "是否本菜单必选权限")
    private Boolean requiredPermission;
    //启用
    @ApiModelProperty(value = "启用")
    private Boolean enabled;
}