package com.yali.domain.account;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_wallet")
public class AccountWallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "account_id", nullable = false)
	private Long accountId;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Money is deducted from this account
	 * 
	 * @param amount
	 */
	public void debit(BigDecimal amount) {
		this.amount = this.amount.subtract(amount);

		if (BigDecimal.ZERO.compareTo(this.amount) > 0) {
			throw new RuntimeException("not enough balance!");
		}
	}

	/**
	 * Money is added into the this account
	 * 
	 * @param amount
	 */
	public void credit(BigDecimal amount) {
		this.amount = this.amount.add(amount);
		if (BigDecimal.ZERO.compareTo(this.amount) > 0) {
			throw new RuntimeException("Accont exception..................!");
		}
	}

	public void cancelTransfer(BigDecimal amount) {
		credit(amount);
	}
}
