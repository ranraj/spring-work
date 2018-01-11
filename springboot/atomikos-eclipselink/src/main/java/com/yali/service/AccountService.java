package com.yali.service;

import com.yali.domain.account.Account;
import com.yali.domain.account.AccountWallet;

public interface AccountService {
	void createAccount(Account customer) throws Exception;
	Account getAccount(Long accountId);
	AccountWallet getAccountWallet(Long walletId);
	void transferMoney(Long fromAccountId, Long toAccountId, Long amount);
}
