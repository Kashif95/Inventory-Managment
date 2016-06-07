CREATE TABLE IF  NOT EXISTS OrderStatus(
OrderStatusTypeId INT NOT NULL,
Descr  NVARCHAR(100) NOT NULL,
CONSTRAINT PK_OrderStatus PRIMARY KEY(OrderStatusTypeId)
);


INSERT INTO OrderStatus VALUES(1,'Initiated');
INSERT INTO OrderStatus VALUES(2,'Shipped');
INSERT INTO OrderStatus VALUES(3,'Delivered');
INSERT INTO OrderStatus VALUES(4,'Cancelled');
