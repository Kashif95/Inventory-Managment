CREATE TABLE IF  NOT EXISTS  ProductType(
TypeId INT NOT NULL,
Description  NVARCHAR(100) NOT NULL,
CONSTRAINT PK_ProductType PRIMARY KEY(TypeId)
);

INSERT INTO ProductType VALUES(1,'Fertilizer');
INSERT INTO ProductType VALUES(2,'Seed');

ALTER TABLE  ProductType ADD UserCompTypeId INT NOT NULL DEFAULT 1;
ALTER TABLE  ProductType ADD CONSTRAINT FK_ProductType_UserCompanyType_UserCompTypeId FOREIGN KEY(UserCompTypeId) REFERENCES UserCompanyType(UserCompTypeId);

INSERT INTO ProductType VALUES(3,'Tablet',2);
INSERT INTO ProductType VALUES(4,'Bottle',2);
INSERT INTO ProductType VALUES(5,'Ointment',2)
