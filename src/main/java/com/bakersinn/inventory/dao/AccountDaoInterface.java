package com.bakersinn.inventory.dao;

import com.bakersinn.inventory.model.Account;
import java.util.List;

/**
 * Created by Lalith on 9/23/15.
 */
public interface AccountDaoInterface {
    public Account getAccountById(Integer id);
    public Account deleteAccountById(Integer id);
    public List<Account> getAllAccount();
    public Account insertAccount(Account account);
    public List<Account> insertAllAccounts(List<Account> accounts);
    public Account updateAccount(Account account);
}
