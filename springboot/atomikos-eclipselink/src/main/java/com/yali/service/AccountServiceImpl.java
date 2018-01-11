package com.yali.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yali.domain.account.Account;
import com.yali.domain.account.AccountWallet;
import com.yali.repository.customer.AccountRepository;
import com.yali.repository.customer.AccountWalletRepository;
 
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired AccountWalletRepository accountWalletRepository;
	
	@Override
	@Transactional
	public void createAccount(Account customer) {
		accountRepository.save(customer);
	}
	
	@Override
	@Transactional()
	public void transferMoney(Long fromAccountId, Long toAccountId, Long amount) {
		AccountWallet accountWalletFrom = accountWalletRepository.findOne(fromAccountId);
		AccountWallet accountWalletTo = accountWalletRepository.findOne(toAccountId);
		BigDecimal capital = BigDecimal.valueOf(amount);
		accountWalletFrom.debit(capital);
		accountWalletTo.credit(capital);
		accountWalletRepository.save(accountWalletFrom);
		accountWalletRepository.save(accountWalletTo);
	}

	@Override
	public Account getAccount(Long accountId) {
		return accountRepository.findOne(accountId);
	}

	@Override
	public AccountWallet getAccountWallet(Long walletId) {
		return accountWalletRepository.findByAccountId(walletId);
	}
	
}
