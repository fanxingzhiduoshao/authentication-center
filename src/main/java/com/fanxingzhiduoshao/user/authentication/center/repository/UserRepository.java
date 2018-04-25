package com.fanxingzhiduoshao.user.authentication.center.repository;

import com.fanxingzhiduoshao.user.authentication.center.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

    boolean existsByAccountName(String accountName);

    boolean existsByPhoneNumber(String phonenumber);

    boolean existsByMail(String mail);

    User findByMail(String name);

    User findByPhoneNumber(String name);

    User findByAccountName(String name);
}
