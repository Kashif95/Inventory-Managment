CREATE TABLE IF  NOT EXISTS ProductStock(
ProductStockId INT NOT NULL AUTO_INCREMENT,
ProductId INT,
AgencyId INT,
Quantity FLOAT  DEFAULT 0,
CostPrice FLOAT  DEFAULT 0,
SellingPrice FLOAT  DEFAULT 0,
ArrivalDate DATETIME,
PsCrd DATETIME,
PsCrdBy NVARCHAR(200),
PsUpd	DATETIME,
PsUpdBy	NVARCHAR(200),
CONSTRAINT PK_ProductStock PRIMARY KEY(ProductStockId),
CONSTRAINT FK_ProductStock_AgencyDetails_AgencyId FOREIGN KEY(AgencyId) REFERENCES AgencyDetails(AgencyId),
CONSTRAINT FK_ProductStock_ProductDetails_ProductId FOREIGN KEY(ProductId) REFERENCES ProductDetails(ProductId)
);

ALTER TABLE  ProductStock ADD UserCompTypeId INT NOT NULL DEFAULT 1;
ALTER TABLE  ProductStock ADD CONSTRAINT FK_ProductStock_UserCompanyType_UserCompTypeId FOREIGN KEY(UserCompTypeId) REFERENCES UserCompanyType(UserCompTypeId);

ALTER TABLE  ProductStock ADD ExpiryDate DATETIME;

ALTER TABLE  ProductStock ADD MedicineAgencyId INT;
ALTER TABLE  ProductStock ADD CONSTRAINT FK_ProductStock_MedicalAgencyDetails_AgencyId FOREIGN KEY(MedicineAgencyId) REFERENCES MedicalAgencyDetails(AgencyId);
