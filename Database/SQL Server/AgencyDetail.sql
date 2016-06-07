IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[AgencyDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[LoginDetails]

CREATE TABLE AgencyDetails(
AgencyId INT NOT NULL IDENTITY,
AgencyName NVARCHAR(200),
AgencyOwnerName NVARCHAR(200),
AgencySupervisorName NVARCHAR(200),
AgencyEmail NVARCHAR(50),
PrimaryContactNumber NVARCHAR(10),
AlternateContactNumber NVARCHAR(10),
AddressId INT,
AdCrd DATETIME,
AdCrdBy NVARCHAR(200),
AdUpd	DATETIME,
AdUpdBy	NVARCHAR(200),
CONSTRAINT PK_AgencyDetails PRIMARY KEY(AgencyId),
CONSTRAINT FK_AgencyDetails_AddressDetails_AddressId FOREIGN KEY(AddressId) REFERENCES AddressDetails(AddressId)
);
