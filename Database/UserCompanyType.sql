
CREATE TABLE IF NOT EXISTS UserCompanyType(
UserCompTypeId INT NOT NULL,
Descr  NVARCHAR(100) NOT NULL,
CONSTRAINT PK_UCTypeId PRIMARY KEY(UserCompTypeId)
);


INSERT INTO UserCompanyType VALUES(1,'Fertilizer');
INSERT INTO UserCompanyType VALUES(2,'Medicine');
