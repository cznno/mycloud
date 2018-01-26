package person.cznno.admin.service;

import person.cznno.admin.entity.UserEntity;
import com.github.pagehelper.PageInfo;

/**
 * 用户业务
 * Created by cznno
 * Date: 18-1-5
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @param entity 分页参数
     * @return 分页查询结果
     */
    PageInfo<UserEntity> selectAll(UserEntity entity);

    /**
     * 查询所有用户
     * 默认分页参数
     * @return 分页查询结果
     */
    PageInfo<UserEntity> selectAll(int page, int rows);

    /**
     * 按id查询用户
     *
     * @param id 主键
     * @return 用户实体
     */
    UserEntity selectById(Integer id);

    /**
     * 插入用户
     * @param user 用户实体
     * @return 插入结果数
     */
    int insertSelective(UserEntity user);

    /**
     * 按id更新用户
     *
     * @param entity 用户实体
     * @return 更新结果数
     */
    int updateByIdSelective(UserEntity entity);

    /**
     * 按id删除用户
     * @param id 用户实体
     * @return 删除结果数
     */
    int deleteById(Integer id);
}
