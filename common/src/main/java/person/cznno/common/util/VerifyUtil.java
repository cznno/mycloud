package person.cznno.common.util;

/**
 * 校验工具
 * Created by cznno
 * Date: 18-1-8
 */
public class VerifyUtil {

    /**
     * 校验是否为空
     * @param o 输入对象
     * @return 是否为空
     */
    public static Boolean isNullOrEmpty(Object o) {
        return null == o || "".equals(o.toString());
    }

    /**
     * 校验是否不空
     * @param o 输入对象
     * @return 是否不为空
     */
    public static Boolean isNotNullOrEmpty(Object o) {
        return !isNullOrEmpty(o);
    }
}
