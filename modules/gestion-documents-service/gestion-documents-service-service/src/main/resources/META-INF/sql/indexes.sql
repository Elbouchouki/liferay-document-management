create index IX_AF52B899 on GDDocument (filename[$COLUMN_LENGTH:75$]);
create index IX_F2A61F8C on GDDocument (groupId);
create index IX_FA10999 on GDDocument (userId, filename[$COLUMN_LENGTH:75$], fileversion);
create index IX_2C09B8BD on GDDocument (userId, title[$COLUMN_LENGTH:75$], tags[$COLUMN_LENGTH:75$]);
create index IX_424EF552 on GDDocument (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EF58A854 on GDDocument (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5F006407 on GDHistory (documentId);
create index IX_A0C27017 on GDHistory (uuid_[$COLUMN_LENGTH:75$]);