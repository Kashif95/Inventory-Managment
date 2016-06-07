IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[UserDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[UserDetails]

CREATE TABLE UserDetails(
MobileNumber NVARCHAR(10),
UserFName  NVARCHAR(200),
UserLName  NVARCHAR(200),
UserEmail  NVARCHAR(50),
UserPassword NVARCHAR(50),
ConfirmPassword NVARCHAR(50),
UserTypeId INT,
UdCrd DATETIME,
UdCrdBy NVARCHAR(200),
UdUpd	DATETIME,
UdUpdBy	NVARCHAR(200),
CONSTRAINT PK_UserDetails PRIMARY KEY(MobileNumber),
CONSTRAINT FK_UserDetails_UserType_UserTypeId FOREIGN KEY(UserTypeId) REFERENCES UserType(UserTypeId),
);

GO

INSERT INTO UserDetails(MobileNumber,UserFName,UserLName,UserEmail,UserPassword,ConfirmPassword,UserTypeId,
UdCrd,UdCrdBy,UdUpd,UdUpdBy) VALUES('8861134339','Rakhi','Gupta','rakhime3@gmail.com','jaimatadi3','jaimatadi3',1,getDate(),'Rakhi',getDate(),'Rakhi')