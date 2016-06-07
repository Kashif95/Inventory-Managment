IF  NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[ProductType]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1)
	--DROP TABLE [dbo].[UserType]

CREATE TABLE ProductType(
TypeId INT NOT NULL,
Description  NVARCHAR(100) NOT NULL,
CONSTRAINT PK_ProductType PRIMARY KEY(TypeId),
);

GO

INSERT INTO ProductType VALUES(1,'Fertilizer')
INSERT INTO ProductType VALUES(2,'Seed')
