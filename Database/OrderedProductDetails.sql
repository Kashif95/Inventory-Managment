CREATE TABLE IF  NOT EXISTS OrderedProductDetails(
OPDId VARCHAR(64),
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

ALTER TABLE  OrderedProductDetails ADD MedicineOrderId INT;
ALTER TABLE  OrderedProductDetails ADD CONSTRAINT FK_OrderedProductDetails_MedicineOrderDetail_MedicineOrderId FOREIGN KEY(MedicineOrderId) REFERENCES MedicineOrderDetail(OrderId);

ALTER TABLE orderedproductdetails DROP FOREIGN KEY FK_OrderedProductDetails_OrderDetail_OrderId;
ALTER TABLE orderedproductdetails CHANGE COLUMN `OrderId` `OrderId` INT NULL ;
ALTER TABLE orderedproductdetails ADD CONSTRAINT FK_OrderedProductDetails_OrderDetail_OrderId
  FOREIGN KEY (OrderId) REFERENCES orderdetail (OrderId);

