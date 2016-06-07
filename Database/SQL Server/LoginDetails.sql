IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[LoginDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[LoginDetails]

CREATE TABLE LoginDetails(
LoginId UNIQUEIDENTIFIER,
UserId NVARCHAR(10),
LdCrd DATETIME,
LdCrdBy NVARCHAR(200),
LdUpd	DATETIME,
LdUpdBy	NVARCHAR(200),
CONSTRAINT PK_LoginDetails PRIMARY KEY(LoginId),
CONSTRAINT FK_LoginDetails_UserDetails_UserId FOREIGN KEY(UserId) REFERENCES UserDetails(MobileNumber)
);
