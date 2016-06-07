CREATE TABLE  IF  NOT EXISTS RetailerDetails(
RetailerId INT NOT NULL AUTO_INCREMENT,
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
