package person.cznno.admin.dao;

import person.cznno.admin.entity.PermissionEntity;
import org.springframework.stereotype.Repository;
import person.cznno.common.MyMapper;

@Repository
public interface PermissionDao extends MyMapper<PermissionEntity> {
}
