package com.yali.config.jta.platform;

import org.eclipse.persistence.sessions.DatabaseSession;

public class AtomikosPlatform extends com.atomikos.eclipselink.platform.AtomikosPlatform {
	public AtomikosPlatform(DatabaseSession newDatabaseSession) {
		super(newDatabaseSession);
	}

	@Override
	public Class<?> getExternalTransactionControllerClass() {
		return StoredJTATransactionController.class;
	}
}