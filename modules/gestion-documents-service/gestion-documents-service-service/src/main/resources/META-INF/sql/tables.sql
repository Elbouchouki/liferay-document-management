create table GDDocument (
	uuid_ VARCHAR(75) null,
	documentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedBy LONG,
	city VARCHAR(75) null,
	address VARCHAR(75) null,
	type_ VARCHAR(75) null,
	description VARCHAR(75) null,
	title VARCHAR(75) null,
	filepath VARCHAR(255) null,
	filename VARCHAR(75) null,
	fileversion LONG,
	tags VARCHAR(75) null
);

create table GDHistory (
	uuid_ VARCHAR(75) null,
	historyId LONG not null primary key,
	versionDate DATE null,
	versionModifier LONG,
	documentId LONG,
	title VARCHAR(75) null,
	filepath VARCHAR(75) null,
	filename VARCHAR(75) null,
	fileversion LONG,
	tags VARCHAR(75) null,
	city VARCHAR(75) null,
	address VARCHAR(75) null,
	description VARCHAR(75) null
);