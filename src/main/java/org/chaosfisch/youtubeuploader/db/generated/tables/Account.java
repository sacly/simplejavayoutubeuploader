/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
/**
 * This class is generated by jOOQ
 */
package org.chaosfisch.youtubeuploader.db.generated.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Account extends org.jooq.impl.UpdatableTableImpl<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> {

	private static final long serialVersionUID = 1683402227;

	/**
	 * The singleton instance of <code>PUBLIC.ACCOUNT</code>
	 */
	public static final org.chaosfisch.youtubeuploader.db.generated.tables.Account ACCOUNT = new org.chaosfisch.youtubeuploader.db.generated.tables.Account();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> getRecordType() {
		return org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord.class;
	}

	/**
	 * The column <code>PUBLIC.ACCOUNT.ID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>PUBLIC.ACCOUNT.NAME</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.ACCOUNT.PASSWORD</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.String> PASSWORD = createField("PASSWORD", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * Create a <code>PUBLIC.ACCOUNT</code> table reference
	 */
	public Account() {
		super("ACCOUNT", org.chaosfisch.youtubeuploader.db.generated.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>PUBLIC.ACCOUNT</code> table reference
	 */
	public Account(java.lang.String alias) {
		super(alias, org.chaosfisch.youtubeuploader.db.generated.Public.PUBLIC, org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.Integer> getIdentity() {
		return org.chaosfisch.youtubeuploader.db.generated.Keys.IDENTITY_ACCOUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> getPrimaryKey() {
		return org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_E;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>>asList(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_E);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.chaosfisch.youtubeuploader.db.generated.tables.Account as(java.lang.String alias) {
		return new org.chaosfisch.youtubeuploader.db.generated.tables.Account(alias);
	}
}
