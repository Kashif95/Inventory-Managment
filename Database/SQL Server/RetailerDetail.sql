IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[RetailerDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[LoginDetails]

CREATE TABLE RetailerDetails(
RetailerId INT NOT NULL IDENTITY,
RetailerFName NVARCHAR(100),
RetailerLName NVARCHAR(100),
RetailerPanNumber NVARCHAR(200),
RetailerEmail NVARCHAR(50),
PrimaryContactNumber NVARCHAR(10),
AlternateContactNumber NVARCHAR(10),
UserTypeId INT,
AddressId INT,
RdCrd DATETIME,
RdCrdBy NVARCHAR(200),
RdUpd	DATETIME,
RdUpdBy	NVARCHAR(200),
CONSTRAINT PK_RetailerDetails PRIMARY KEY(RetailerId),
CONSTRAINT FK_RetailerDetails_AddressDetails_AddressId FOREIGN KEY(AddressId) REFERENCES AddressDetails(AddressId),
CONSTRAINT FK_RetailerDetails_UserType_UserTypeId FOREIGN KEY(UserTypeId) REFERENCES UserType(UserTypeId)
);
