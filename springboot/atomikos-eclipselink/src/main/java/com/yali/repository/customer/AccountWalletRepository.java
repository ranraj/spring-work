package com.yali.repository.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.eclipse.persistence.internal.expressions.ParameterExpression;
import org.springframework.stereotype.Repository;

import com.yali.domain.account.AccountWallet;

@Repository
public class AccountWalletRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public AccountWallet findOne(long l) {
		return entityManager.find(AccountWallet.class, l);
	}
	@Transactional
	public void save(AccountWallet ca) {
		entityManager.persist(ca);		
	}
	public AccountWallet findByAccountId(Long accountId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<AccountWallet> criteriaQuery = cb.createQuery(AccountWallet.class);
	    Root<AccountWallet> root = criteriaQuery.from(AccountWallet.class);
	    criteriaQuery.select(root);
	    criteriaQuery.where(cb.equal(root.get("accountId"), accountId)); 
	    TypedQuery<AccountWallet> query = entityManager.createQuery(criteriaQuery);
	    return (AccountWallet) query.getSingleResult();
	}
}
