IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[OrderedProductDetails]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[OrderedProductDetails]

CREATE TABLE OrderedProductDetails(
OPDId UNIQUEIDENTIFIER,
OrderId INT NOT NULL,
ProductStockId INT NOT NULL,
Price FLOAT,
Quantity FLOAT,
OPDCrd DATETIME,
OPDCrdBy NVARCHAR(200),
OPDUpd	DATETIME,
OPDUpdBy	NVARCHAR(200),
CONSTRAINT PK_OrderedProductDetails PRIMARY KEY(OPDId),
CONSTRAINT FK_OrderedProductDetails_OrderDetail_OrderId FOREIGN KEY(OrderId) REFERENCES OrderDetail(OrderId),
CONSTRAINT FK_OrderedProductDetails_ProductStock_ProductStockId FOREIGN KEY(ProductStockId) REFERENCES ProductStock(ProductStockId)
);
