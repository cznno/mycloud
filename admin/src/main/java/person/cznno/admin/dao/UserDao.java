package person.cznno.admin.dao;

import person.cznno.common.MyMapper;
import person.cznno.admin.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MyMapper<UserEntity> {

    UserEntity selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    UserEntity selectByUsername(String username);
}