package com.yali.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.postgresql.xa.PGXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.atomikos.eclipselink.platform.AtomikosPlatform;
import com.atomikos.jdbc.AtomikosDataSourceBean;


@Configuration
@EnableJpaRepositories(basePackages = "com.yali.config.repository", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
@EnableConfigurationProperties(DatasourceProperties.class)
@EnableTransactionManagement
public class JPAConfig {

	@Autowired
	private DatasourceProperties customerDatasourceProperties;
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter eclipseJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
		eclipseJpaVendorAdapter.setShowSql(true);
		eclipseJpaVendorAdapter.setGenerateDdl(true);
		eclipseJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		return eclipseJpaVendorAdapter;
	}

	@Primary
	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	public DataSource dataSource() {
		PGXADataSource pgXaDataSource = new PGXADataSource();
		pgXaDataSource.setUrl(customerDatasourceProperties.getUrl());
		pgXaDataSource.setPassword(customerDatasourceProperties.getPassword());
		pgXaDataSource.setUser(customerDatasourceProperties.getUsername());

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(pgXaDataSource);
		xaDataSource.setUniqueResourceName("xaDataSource");
		xaDataSource.setBorrowConnectionTimeout(60);
		xaDataSource.setMaxPoolSize(20);
		return xaDataSource;
	}

	@Primary
	@Bean(name = "entityManager")
	@DependsOn({"dataSource","transactionManager","jpaVendorAdapter"})
	public LocalContainerEntityManagerFactoryBean customerEntityManager(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter) throws Throwable {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("javax.persistence.transactionType", "JTA");
		properties.put(PersistenceUnitProperties.WEAVING, "false");
		properties.put("databasePlatform", "org.eclipse.persistence.platform.database.PostgreSQL");		
		properties.put("eclipselink.target-server", AtomikosPlatform.class.getName());
		
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(dataSource);
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setPackagesToScan("com.yali.domain");
		entityManager.setPersistenceUnitName("customer_punit");
		entityManager.setJpaPropertyMap(properties);
		return entityManager;
	}

}
