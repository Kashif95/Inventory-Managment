CREATE TABLE IF  NOT EXISTS OrderDetail(
OrderId INT AUTO_INCREMENT NOT NULL,
OrderPrice FLOAT NOT NULL,
LabourFee FLOAT  DEFAULT 0,
ShippingFee FLOAT  DEFAULT 0,
OrderTotalPrice FLOAT NOT NULL,
RetailerId INT,
PaymentMode NVARCHAR(100),
PaymentStatus BIT,
OrderStatusTypeId INT,
ODCrd DATETIME,
ODCrdBy NVARCHAR(200),
ODUpd	DATETIME,
ODUpdBy	NVARCHAR(200),
CONSTRAINT PK_OrderDetail PRIMARY KEY(OrderId),
CONSTRAINT FK_OrderDetail_RetailerDetails_RetailerId FOREIGN KEY(RetailerId) REFERENCES RetailerDetails(RetailerId),
CONSTRAINT FK_OrderDetail_OrderStatus_OrderStatusTypeId FOREIGN KEY(OrderStatusTypeId) REFERENCES OrderStatus(OrderStatusTypeId)
);

ALTER TABLE OrderDetail AUTO_INCREMENT = 100000;
ALTER TABLE OrderDetail ADD  PendingAmount FLOAT NOT NULL DEFAULT 0;
