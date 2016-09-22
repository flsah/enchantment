create database eaas DEFAULT CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

use eaas;

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER 
(
   ID                   char(20)                       not null,
   NAME                 varchar(20)                    null,
   LNAME                varchar(20)                    not null,
   ENAME                VARCHAR(20)                    null,
   SEX                  int                            null,
   MOBILE               varchar(15)                    null,
   TEL                  varchar(15)                    null,
   MAIL                 varchar(30)                    null,
   FAX                  VARCHAR(15)                    null,
   ZIPCODE              VARCHAR(10)                    null,
   ADDRESS              VARCHAR(100)                   null,
   PASSWD1              VARCHAR(100)                   null,
   PASSWD2              VARCHAR(100)                   null,
   PASSWD3              VARCHAR(100)                   null,
   PASSWD4              VARCHAR(100)                   null,
   PASSWD5              VARCHAR(100)                   null,
   STATUS               INT                            not null,
   UNTIL                DATE                           null,
   MDATE                TIMESTAMP                      null,
   MID                  CHAR(20)                       null,
   OTYPE                INT                            null,
   PHOTOURL             VARCHAR(200)                   null,
   REMARK               VARCHAR(1024)                  null,
   constraint PK_T_USER primary key clustered (ID)
);

/*==============================================================*/
/* Table: T_GROUP                                               */
/*==============================================================*/
create table T_GROUP 
(
   ID                   CHAR(20)                       not null,
   NAME                 VARCHAR(100)                   not null,
   LEVEL                VARCHAR(200)                   not null,
   TEL                  VARCHAR(15)                    null,
   FAX                  VARCHAR(15)                    null,
   ADDRESS              VARCHAR(100)                   null,
   ZIPCODE              VARCHAR(10)                    null,
   STATUS               INT                            not null,
   UNTIL                DATE                           null,
   MDATE                TIMESTAMP                      null,
   MID                  CHAR(20)                       null,
   OTYPE                INT                            null,
   REMARK               VARCHAR(1024)                  null,
   constraint PK_T_GROUP primary key clustered (ID)
);

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE 
(
   ID                   CHAR(20)                       not null,
   NAME                 VARCHAR(20)                    not null,
   STATUS               INT                            not null,
   UNTIL                DATE                           null,
   MDATE                TIMESTAMP                      null,
   MID                  CHAR(20)                       null,
   OTYPE                INT                            null,
   REMARK               VARCHAR(512)                   null,
   constraint PK_T_ROLE primary key clustered (ID)
);

/*==============================================================*/
/* Table: T_RESOURCE                                            */
/*==============================================================*/
create table T_RESOURCE 
(
   ID                   CHAR(20)                       not null,
   NAME                 VARCHAR(50)                    not null,
   URI                  VARCHAR(200)                   not null,
   TYPE                 INT                            not null,
   STATUS               INT                            not null,
   MDATE                TIMESTAMP                      null,
   MID                  CHAR(20)                       null,
   OTYPE                INT                            null,
   constraint PK_T_RESOURCE primary key clustered (ID)
);

/*==============================================================*/
/* Table: T_USER_GROUP_REL                                      */
/*==============================================================*/
create table T_USER_GROUP_REL 
(
   UID                  char(20)                       not null,
   GID                  char(20)                       not null,
   constraint PK_T_USER_GROUP_REL primary key clustered (UID, GID)
);

alter table T_USER_GROUP_REL
   add constraint FK_USER_GROUP_REL_U foreign key (UID)
      references T_USER (ID)
      on update restrict
      on delete restrict;

alter table T_USER_GROUP_REL
   add constraint FK_USER_GROUP_REL_G foreign key (GID)
      references T_GROUP (ID)
      on update restrict
      on delete restrict;

/*==============================================================*/
/* Table: T_USER_ROLE_REL                                       */
/*==============================================================*/
create table T_USER_ROLE_REL 
(
   UID                  CHAR(20)                       not null,
   RID                  CHAR(20)                       not null,
   constraint PK_T_USER_ROLE_REL primary key clustered (UID, RID)
);

alter table T_USER_ROLE_REL
   add constraint FK_USER_ROLE_REL_U foreign key (UID)
      references T_USER (ID)
      on update restrict
      on delete restrict;

alter table T_USER_ROLE_REL
   add constraint FK_USER_ROLE_REL_R foreign key (RID)
      references T_ROLE (ID)
      on update restrict
      on delete restrict;

/*==============================================================*/
/* Table: T_GROUP_ROLE_REL                                      */
/*==============================================================*/
create table T_GROUP_ROLE_REL 
(
   GID                  char(20)                       not null,
   RID                  char(20)                       not null,
   constraint PK_T_GROUP_ROLE_REL primary key clustered (GID, RID)
);

alter table T_GROUP_ROLE_REL
   add constraint FK_GROUP_ROLE_REL_G foreign key (GID)
      references T_GROUP (ID)
      on update restrict
      on delete restrict;

alter table T_GROUP_ROLE_REL
   add constraint FK_GROUP_ROLE_REL_R foreign key (RID)
      references T_ROLE (ID)
      on update restrict
      on delete restrict;

/*==============================================================*/
/* Table: T_ROLE_RES_REL                                        */
/*==============================================================*/
create table T_ROLE_RES_REL 
(
   ROLID                CHAR(20)                       not null,
   RESID                CHAR(50)                    not null,
   constraint PK_T_ROLE_RES_REL primary key clustered (ROLID, RESID)
);

alter table T_ROLE_RES_REL
   add constraint FK_ROL_RES_REL_RO foreign key (ROLID)
      references T_ROLE (ID)
      on update restrict
      on delete restrict;

alter table T_ROLE_RES_REL
   add constraint FK_ROL_RES_REL_RE foreign key (RESID)
      references T_RESOURCE (ID)
      on update restrict
      on delete restrict;
