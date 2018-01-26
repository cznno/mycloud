package person.cznno.admin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.common.entity.BaseEntity;

import javax.persistence.Table;

/**
 * 角色
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="sys_role")
@ApiModel(value = "角色实体")
public class RoleEntity extends BaseEntity {

    //角色名
    @ApiModelProperty(value = "角色名")
    private String roleName;
    //是否有效  1有效  0无效
    @ApiModelProperty(value = "是否有效  1有效  0无效")
    private Boolean enabled;
}