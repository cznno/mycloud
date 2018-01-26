package person.cznno.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.common.entity.BaseEntity;

import javax.persistence.Table;

/**
 * 用户-角色关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_user_role")
@ApiModel(value = "用户-角色关联")
public class UserRoleEntity extends BaseEntity {

    //用户ID
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    //角色ID
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;
    //启用
    @ApiModelProperty(value = "启用")
    private Boolean enabled;
}