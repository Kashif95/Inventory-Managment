IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[OrderStatus]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[OrderStatus]

CREATE TABLE OrderStatus(
OrderStatusTypeId INT NOT NULL,
Descr  NVARCHAR(100) NOT NULL,
CONSTRAINT PK_OrderStatus PRIMARY KEY(OrderStatusTypeId),
);

GO

INSERT INTO OrderStatus VALUES(1,'Initiated')
INSERT INTO OrderStatus VALUES(2,'Shipped')
INSERT INTO OrderStatus VALUES(3,'Delivered')
