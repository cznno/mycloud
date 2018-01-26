package person.cznno.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.common.entity.BaseEntity;

import javax.persistence.Table;

/**
 * 角色-权限关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="sys_role_permission")
@ApiModel(value = "角色-权限关联")
public class RolePermissionEntity extends BaseEntity {

    //角色id
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    //权限id
    @ApiModelProperty(value = "权限id")
    private Integer permissionId;
    //是否有效 1有效 0无效
    @ApiModelProperty(value = "是否有效 1有效 0无效")
    private Boolean enabled;
}