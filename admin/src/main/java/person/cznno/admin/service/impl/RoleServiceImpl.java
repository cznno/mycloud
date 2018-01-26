package person.cznno.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;
import person.cznno.admin.dao.RoleDao;
import person.cznno.admin.entity.RoleEntity;
import person.cznno.admin.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo<RoleEntity> selectAll(RoleEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> roleDao.selectAll());
    }

    @Override
    public RoleEntity selectById(Integer id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleEntity entity) {
        return roleDao.insertSelective(entity);
    }

    @Override
    public int updateByIdSelective(RoleEntity entity) {
        return roleDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(@PathVariable Integer id) {
        return roleDao.deleteByPrimaryKey(id);
    }
}
