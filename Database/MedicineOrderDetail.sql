CREATE TABLE IF  NOT EXISTS MedicineOrderDetail(
OrderId INT AUTO_INCREMENT NOT NULL,
OrderPrice FLOAT NOT NULL,
DiscountFactor FLOAT  DEFAULT 0,
OrderTotalPrice FLOAT NOT NULL,
CustomerName NVARCHAR(100),
CustomerMobile NVARCHAR(10),
PaymentMode NVARCHAR(100),
PaymentStatus BIT,
OrderStatusTypeId INT,
BalanceAmount FLOAT DEFAULT 0,
Payment FLOAT DEFAULT 0,
BillNumber NVARCHAR(200),
BillDate DATETIME,
ODCrd DATETIME,
ODCrdBy NVARCHAR(200),
ODUpd	DATETIME,
ODUpdBy	NVARCHAR(200),
CONSTRAINT PK_MedicineOrderDetail PRIMARY KEY(OrderId),
CONSTRAINT FK_MedicineOrderDetail_OrderStatus_OrderStatusTypeId FOREIGN KEY(OrderStatusTypeId) REFERENCES OrderStatus(OrderStatusTypeId)
);

ALTER TABLE MedicineOrderDetail AUTO_INCREMENT = 100;
