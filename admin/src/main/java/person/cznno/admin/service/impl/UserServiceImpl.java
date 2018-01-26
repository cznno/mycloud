package person.cznno.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;
import person.cznno.admin.dao.UserDao;
import person.cznno.admin.entity.UserEntity;
import person.cznno.admin.exception.UserDuplicateException;
import person.cznno.admin.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<UserEntity> selectAll(UserEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> userDao.selectAll());
    }

    @Override
    public PageInfo<UserEntity> selectAll(int page, int rows) {
        return PageHelper.startPage(page, rows)
                .doSelectPageInfo(() -> userDao.selectAll());
    }

    @Override
    public UserEntity selectById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserEntity user) {

        int res;
        UserEntity resultUser = userDao.selectByUsername(user.getUsername());
        if (resultUser != null) {
            throw new UserDuplicateException();
//            resEnum = AuthStatusEnum.REGISTER_REPEAT;
            //TODO throw exception
        } else {
            //TODO algorithm name enum
//            String algorithmName = "MD5";
//            SimpleHash simpleHash = new SimpleHash(algorithmName, user.getPassword(), user.getUsername(), 2);
//            user.setPassword(simpleHash.toHex());

            res = userDao.insertSelective(user);
        }
        return res;
    }

    @Override
    public int updateByIdSelective(UserEntity entity) {
        return userDao.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
