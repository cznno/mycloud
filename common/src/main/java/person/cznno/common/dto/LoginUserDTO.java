package person.cznno.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录用户
 * Created by cznno
 * Date: 17-12-28
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "登录用户")
public class LoginUserDTO {

    //用户名
    @ApiModelProperty("用户名")
    private String username;
    //密码
    @ApiModelProperty("密码")
    private String password;
}
