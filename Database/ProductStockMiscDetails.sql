CREATE TABLE IF  NOT EXISTS ProductStockMiscDetails(
ProductStockId INT NOT NULL,
ChallanNumber NVARCHAR(200),
ChallanDate DATETIME,
InvoiceNumber NVARCHAR(200),
InvoiceDate DATETIME,
DONumber NVARCHAR(200),
DueDate DATETIME,
PSMDCrd DATETIME,
PSMDCrdBy NVARCHAR(200),
PSMDUpd	DATETIME,
PSMDUpdBy	NVARCHAR(200),
CONSTRAINT PK_ProductStockMiscDetails PRIMARY KEY(ProductStockId),
CONSTRAINT FK_ProductStockMiscDetails_ProductStock_ProductStockId FOREIGN KEY(ProductStockId) REFERENCES ProductStock(ProductStockId)
);