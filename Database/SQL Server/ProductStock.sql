IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ProductStock]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[ProductDetails]

CREATE TABLE ProductStock(
ProductStockId INT NOT NULL IDENTITY,
ProductId INT,
AgencyId INT,
Quantity FLOAT CONSTRAINT DEF_ProductStock_Quantity DEFAULT 0,
CostPrice FLOAT CONSTRAINT DEF_ProductStock_CostPrice DEFAULT 0,
SellingPrice FLOAT CONSTRAINT DEF_ProductStock_SellingPrice DEFAULT 0,
ArrivalDate DATETIME,
PsCrd DATETIME,
PsCrdBy NVARCHAR(200),
PsUpd	DATETIME,
PsUpdBy	NVARCHAR(200),
CONSTRAINT PK_ProductStock PRIMARY KEY(ProductStockId),
CONSTRAINT FK_ProductStock_AgencyDetails_AgencyId FOREIGN KEY(AgencyId) REFERENCES AgencyDetails(AgencyId),
CONSTRAINT FK_ProductStock_ProductDetails_ProductId FOREIGN KEY(ProductId) REFERENCES ProductDetails(ProductId)
)
