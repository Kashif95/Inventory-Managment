IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[UserType]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[UserType]

CREATE TABLE UserType(
UserTypeId INT NOT NULL,
Descr  NVARCHAR(100) NOT NULL,
UtCrd DATETIME,
UtCrdBy NVARCHAR(200),
UtUpd	DATETIME,
UtUpdBy	NVARCHAR(200),
CONSTRAINT PK_UserType PRIMARY KEY(UserTypeId),
);

GO

INSERT INTO UserType VALUES(1,'Admin',getDate(),'Rakhi',getDate(),'Rakhi')
INSERT INTO UserType VALUES(2,'User',getDate(),'Rakhi',getDate(),'Rakhi')
INSERT INTO UserType VALUES(3,'Retailer',getDate(),'Rakhi',getDate(),'Rakhi')
