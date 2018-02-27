package person.cznno.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 基本返回消息
 * Created by cznno
 * Date: 17-12-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "msg", "data"})
@ApiModel(value = "基本返回消息")
public class BaseResponse<T> implements Response {

    @ApiModelProperty(value = "成功状态")
    private Boolean success;
    @ApiModelProperty(value = "消息")
    private String msg;
    @ApiModelProperty(value = "数据")
    private T data;
}