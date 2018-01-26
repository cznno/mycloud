package person.cznno.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;
import person.cznno.admin.dao.PermissionDao;
import person.cznno.admin.entity.PermissionEntity;
import person.cznno.admin.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cznno
 * Date: 18-1-2
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public PageInfo<PermissionEntity> selectAll(PermissionEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> permissionDao.selectAll());
    }

    @Override
    public PageInfo<PermissionEntity> selectAll(int page, int rows) {
        return PageHelper.startPage(page, rows)
                .doSelectPageInfo(() -> permissionDao.selectAll());
    }

    @Override
    public PermissionEntity selectById(Integer id) {
        return permissionDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PermissionEntity record) {
        return permissionDao.insertSelective(record);
    }

    @Override
    public int updateByIdSelective(PermissionEntity record) {
        return permissionDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteById(Integer id) {
        return permissionDao.deleteByPrimaryKey(id);
    }
}
