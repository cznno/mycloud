package person.cznno.admin.service;

import person.cznno.admin.entity.RoleEntity;
import com.github.pagehelper.PageInfo;

/**
 * 角色业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface RoleService {

    /**
     * 查询全部角色
     * @param entity 分页参数
     * @return 分页查询结果
     */
    PageInfo<RoleEntity> selectAll(RoleEntity entity);

    /**
     * 按id查询角色
     * @param id 主键
     * @return 角色
     */
    RoleEntity selectById(Integer id);

    /**
     * 插入角色
     * @param role 角色实体
     * @return 插入结果数
     */
    int insertSelective(RoleEntity role);

    /**
     * 按id更新角色
     * @param role 角色实体
     * @return 更新结果数
     */
    int updateByIdSelective(RoleEntity role);

    /**
     * 按id删除角色
     * @param id 主键
     * @return 删除结果数
     */
    int deleteById(Integer id);
}
