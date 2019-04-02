package com.fanxingzhiduoshao.user.authentication.center.service;

import com.fanxingzhiduoshao.user.authentication.center.entity.Account;
import com.fanxingzhiduoshao.user.authentication.center.repository.AccountRepository;
import com.fanxingzhiduoshao.user.authentication.center.util.UUIDutils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author star9264 2019/04/02
 */
@Service
public class AccountBookService {

    @Resource
    private AccountRepository accountRepository;

    public void addAccount(String name, String description) {

        long ower = 0;
        String uid = UUIDutils.generateUUID32();
        Account account = new Account(uid,name,description,ower,System.currentTimeMillis());
        accountRepository.save(account);
    }

    public Account getAccount(String uid) {
        return accountRepository.findByUid(uid);
    }

    public Page getAccount(){

       Pageable pageable = PageRequest.of(0,10,Sort.by("createTime"));
        Page<Account> a = accountRepository.findAll(pageable);
        return a;
    }
}
