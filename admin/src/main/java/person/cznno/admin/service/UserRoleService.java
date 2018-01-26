package person.cznno.admin.service;

import person.cznno.admin.entity.UserRoleEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户角色业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface UserRoleService {

    /**
     * 查询全部用户角色
     *
     * @param entity 分页参数
     * @return 分页查询结果
     */
    PageInfo<UserRoleEntity> selectAll(UserRoleEntity entity);

    /**
     * 按id查询用户角色
     *
     * @param id 主键
     * @return 用户角色
     */
    UserRoleEntity selectById(Integer id);

    /**
     * 按角色id查询用户角色
     * @param roleId 角色id
     * @return 用户角色List
     */
    List<UserRoleEntity> selectByRoleId(Integer roleId);

    /**
     * 插入用户角色
     *
     * @param userRole 用户角色
     * @return 插入结果数
     */
    int insertSelective(UserRoleEntity userRole);

    /**
     * 批量插入用户角色
     *
     * @param userRoleList 用户角色List
     * @return 插入数量
     */
    int insertBatch(List<UserRoleEntity> userRoleList);

    /**
     * 按id更新用户角色
     *
     * @param userRole 用户角色
     * @return 更新结果数
     */
    int updateByIdSelective(UserRoleEntity userRole);

    /**
     * 按id删除用户角色
     *
     * @param id 主键
     * @return 删除结果数
     */
    int deleteById(Integer id);

    /**
     * 从用户角色List中取出角色id做条件进行批量删除
     *
     * @param userRoleList 用户角色列表
     * @return 删除结果数量
     */
    int deleteBatchByRoleId(List<UserRoleEntity> userRoleList);
}
