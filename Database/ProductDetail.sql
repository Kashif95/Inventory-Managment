CREATE TABLE IF  NOT EXISTS ProductDetails(
ProductId INT NOT NULL AUTO_INCREMENT,
ProductName  NVARCHAR(200),
AgencyId INT,
PdCrd DATETIME,
PdCrdBy NVARCHAR(200),
PdUpd	DATETIME,
PdUpdBy	NVARCHAR(200),
CONSTRAINT PK_ProductDetails PRIMARY KEY(ProductId),
CONSTRAINT FK_ProductDetails_AgencyDetails_AgencyId FOREIGN KEY(AgencyId) REFERENCES AgencyDetails(AgencyId)
);

ALTER TABLE  ProductDetails ADD TypeId INT NOT NULL DEFAULT 1;
ALTER TABLE  ProductDetails ADD CONSTRAINT FK_ProductDetails_ProductType_TypeId FOREIGN KEY(TypeId) REFERENCES ProductType(TypeId);

ALTER TABLE  ProductDetails ADD MedicineAgencyId INT;
ALTER TABLE  ProductDetails ADD CONSTRAINT FK_ProductDetails_MedicalAgencyDetails_AgencyId FOREIGN KEY(MedicineAgencyId) REFERENCES MedicalAgencyDetails(AgencyId);

ALTER TABLE  ProductDetails ADD UserCompTypeId INT NOT NULL DEFAULT 1;
ALTER TABLE  ProductDetails ADD CONSTRAINT FK_ProductDetails_UserCompanyType_UserCompTypeId FOREIGN KEY(UserCompTypeId) REFERENCES UserCompanyType(UserCompTypeId)