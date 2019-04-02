package com.fanxingzhiduoshao.user.authentication.center.repository;

import com.fanxingzhiduoshao.user.authentication.center.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author  Created by star9264 on 2019/04/02
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
    /**
     *
     * @param uid
     * @return
     */
    Account findByUid(String uid);





}
