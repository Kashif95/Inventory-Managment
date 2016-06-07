IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ProductDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[ProductDetails]

CREATE TABLE ProductDetails(
ProductId INT NOT NULL IDENTITY,
ProductName  NVARCHAR(200),
AgencyId INT,
PdCrd DATETIME,
PdCrdBy NVARCHAR(200),
PdUpd	DATETIME,
PdUpdBy	NVARCHAR(200),
CONSTRAINT PK_ProductDetails PRIMARY KEY(ProductId),
CONSTRAINT FK_ProductDetails_AgencyDetails_AgencyId FOREIGN KEY(AgencyId) REFERENCES AgencyDetails(AgencyId)
);
GO

ALTER TABLE  ProductDetails ADD TypeId INT NOT NULL DEFAULT 1;
ALTER TABLE  ProductDetails ADD CONSTRAINT FK_ProductDetails_ProductType_TypeId FOREIGN KEY(TypeId) REFERENCES ProductType(TypeId)