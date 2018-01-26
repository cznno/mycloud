package person.cznno.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 用户
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_user")
@ApiModel(value = "用户实体")
public class UserEntity extends BaseEntity {

    //用户名
    @ApiModelProperty(value = "用户名")
    private String username;
    //密码
    @ApiModelProperty(value = "密码")
    @Column(name = "passwrd")
    @JsonIgnore
    private String password;
    //真名
    @ApiModelProperty(value = "真名")
    private String realName;
    //电子邮箱地址
    @ApiModelProperty(value = "电子邮箱地址")
    private String mailAddress;
    //电话
    @ApiModelProperty(value = "电话")
    private String phone;
    //是否有效  1有效  0无效
    @ApiModelProperty(value = "是否有效 1有效 0无效")
    private Boolean enabled;
}