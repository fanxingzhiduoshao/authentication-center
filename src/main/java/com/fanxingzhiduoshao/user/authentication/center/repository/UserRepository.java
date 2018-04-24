package com.fanxingzhiduoshao.user.authentication.center.repository;

import com.fanxingzhiduoshao.user.authentication.center.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

    boolean existsByAccountName(String accountName);

    boolean existsByPhonenumber(String phonenumber);

    boolean existsByMail(String mail);
}
