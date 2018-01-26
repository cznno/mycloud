package person.cznno.admin.dao;

import person.cznno.common.MyMapper;
import person.cznno.admin.entity.RolePermissionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionDao extends MyMapper<RolePermissionEntity> {

    List<RolePermissionEntity> selectByRoleId(Integer roleId);

    int insertBatchSelective(List<RolePermissionEntity> roleMenuList);

    int deleteBatchByRoleId(List<RolePermissionEntity> roleMenuList);
}