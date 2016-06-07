IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[OrderDetail]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[OrderDetail]

CREATE TABLE OrderDetail(
OrderId INT IDENTITY(100000,1)NOT NULL,
OrderPrice FLOAT NOT NULL,
LabourFee FLOAT CONSTRAINT DEF_OrderDetail_LabourFee DEFAULT 0,
ShippingFee FLOAT CONSTRAINT DEF_OrderDetail_ShippingFee DEFAULT 0,
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
)
GO

ALTER TABLE OrderDetail ADD  PendingAmount FLOAT NOT NULL DEFAULT 0
