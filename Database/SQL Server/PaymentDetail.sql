IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[PaymentDetail]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[PaymentDetail]

CREATE TABLE PaymentDetail(
PDId UNIQUEIDENTIFIER,
OrderId INT NOT NULL,
BankName NVARCHAR(200),
TransactionId NVARCHAR(200),
AmountPaid FLOAT CONSTRAINT DEF_PaymentDetail_AmountPaid DEFAULT 0,
TransactionDate DATETIME,
PDCrd DATETIME,
PDCrdBy NVARCHAR(200),
PDUpd	DATETIME,
PDUpdBy	NVARCHAR(200),
CONSTRAINT PK_PaymentDetail PRIMARY KEY(PDId),
CONSTRAINT FK_PaymentDetail_OrderDetail_OrderId FOREIGN KEY(OrderId) REFERENCES OrderDetail(OrderId)
);
