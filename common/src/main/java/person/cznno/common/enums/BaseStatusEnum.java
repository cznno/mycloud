package person.cznno.common.enums;

/**
 * 基本的状态枚举
 * 除了信息还有状态
 * 参考内容:
 * <a href="http://labs.omniti.com/labs/jsend">JSend</a>
 * <a href="https://stackoverflow.com/questions/12806386/standard-json-api-response-format">Standard JSON API response format?</a>
 * Created by cznno
 * Date: 17-12-28
 */
public interface BaseStatusEnum {

    String getMsg();

    Boolean isSuccess();
}
