package person.cznno.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用户信息
 * Created by cznno
 * Date: 18-1-2
 */
@Data
@ApiModel(value = "用户信息")
public class UserInfoDTO {

    //id
    @ApiModelProperty("id")
    private Integer id;
    //用户名
    @ApiModelProperty("用户名")
    private String username;
    //真名
    @ApiModelProperty("真名")
    private String realName;
    //菜单列表
    @ApiModelProperty("菜单列表")
    private List<String> menuList;
    //角色列表
    @ApiModelProperty("角色列表")
    private List<String> roleList;
    //权限列表
    @ApiModelProperty("权限列表")
    private List<String> permissionList;
}
