package person.cznno.common.exception;

import person.cznno.common.enums.BaseStatusEnum;

/**
 * CRUD操作
 * Created by cznno
 * Date: 17-12-28
 */
public enum CrudStatusEnum implements BaseStatusEnum {

    GENERAL_SUCCESS("数据操作成功", true),
    PRARM_ERROR("参数错误", false),
    GENERAL_FAIL("数据操作失败", false),
    SELECT("查询操作", true),
    INSERT("插入操作", true),
    UPDATE("更新操作", true),
    DELETE("删除操作", true),

    SELECT_SUCCESS("查询成功", true),
    INSERT_SUCCESS("插入成功", true),
    UPDATE_SUCCESS("更新成功", true),
    DELETE_SUCCESS("删除成功", true),

    SELECT_FAIL("查询失败", false),
    SELECT_NO_RESULT("查询失败,找不到结果", false),
    INSERT_FAIL("插入失败", false),
    UPDATE_FAIL("更新失败", false),
    DELETE_FAIL("删除失败", false),
    DELETE_FAIL_CONSTRAINT("数据存在关联约束,操作失败,请检查相关数据", false);

    private final String msg;
    private final Boolean success;

    CrudStatusEnum(String msg, Boolean success) {
        this.msg = msg;
        this.success = success;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Boolean isSuccess() {
        return success;
    }
}
