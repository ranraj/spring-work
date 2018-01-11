package com.yali.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yali.domain.account.Account;
import com.yali.domain.account.AccountWallet;
import com.yali.service.AccountService;
import com.yali.vo.MoneyTransferVO;

@RestController
public class AccountResource {

	@Autowired
	private AccountService accountService;

	@PostMapping(value = "/account")
	public ResponseEntity<Account> store(@RequestBody Account account) {
		try {
			accountService.createAccount(account);
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		} catch (Exception e) {
			// e.printStackTrace();
			return new ResponseEntity<Account>(account, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/account/{accountId}/transfer-to")
	public ResponseEntity<Account> transfer(@PathVariable("accountId") Long accountId,
			@RequestBody(required = true) MoneyTransferVO transferVO) {
		try {
			accountService.transferMoney(accountId, transferVO.getToAccountId(), transferVO.getAmount());
			return new ResponseEntity<Account>(HttpStatus.OK);
		} catch (Exception e) {
			// e.printStackTrace();
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/account/{accountId}/wallet")
	public ResponseEntity<AccountWallet> getAccountWallet(@PathVariable("accountId") Long accountId) {
		try {
			return new ResponseEntity<AccountWallet>(accountService.getAccountWallet(accountId),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<AccountWallet>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
