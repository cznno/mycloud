package person.cznno.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;
import person.cznno.admin.dao.RolePermissionDao;
import person.cznno.admin.entity.RolePermissionEntity;
import person.cznno.admin.service.RolePermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public PageInfo<RolePermissionEntity> selectAll(RolePermissionEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> rolePermissionDao.selectAll());
    }

    @Override
    public RolePermissionEntity selectById(Integer id) {
        return rolePermissionDao.selectByPrimaryKey(id);
    }

    @Override
    public List<RolePermissionEntity> selectByRoleId(Integer roleId) {
        return rolePermissionDao.selectByRoleId(roleId);
    }

    @Override
    public int insertSelective(RolePermissionEntity rolePermissionEntity) {
        return rolePermissionDao.insertSelective(rolePermissionEntity);
    }

    @Override
    public int insertBatchSelective(List<RolePermissionEntity> rolePermissionList) {
        return rolePermissionDao.insertBatchSelective(rolePermissionList);
    }

    @Override
    public int updateByIdSelective(RolePermissionEntity rolePermissionEntity) {
        return rolePermissionDao.updateByPrimaryKeySelective(rolePermissionEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return rolePermissionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByRoleId(List<RolePermissionEntity> rolePermissionList) {
        return rolePermissionDao.deleteBatchByRoleId(rolePermissionList);
    }
}
