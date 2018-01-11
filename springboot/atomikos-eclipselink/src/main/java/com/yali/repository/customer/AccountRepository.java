package com.yali.repository.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.yali.domain.account.Account;

@Repository
public class AccountRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public Account findOne(long l) {
		return entityManager.find(Account.class, l);
	}
	
	@Transactional
	public void save(Account customer) {
		entityManager.persist(customer);
	}
}
