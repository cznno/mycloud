package person.cznno.admin.dao;

import person.cznno.common.MyMapper;
import person.cznno.admin.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao extends MyMapper<UserRoleEntity> {

    List<UserRoleEntity> selectByRoleId(Integer roleId);

    int insertBatch(List<UserRoleEntity> roleMenuList);

    int deleteBatchByRoleId(List<UserRoleEntity> roleMenuList);
}