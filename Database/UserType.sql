
CREATE TABLE IF NOT EXISTS UserType(
UserTypeId INT NOT NULL,
Descr  NVARCHAR(100) NOT NULL,
UtCrd DATETIME,
UtCrdBy NVARCHAR(200),
UtUpd	DATETIME,
UtUpdBy	NVARCHAR(200),
CONSTRAINT PK_UserType PRIMARY KEY(UserTypeId)
);


INSERT INTO UserType VALUES(1,'Admin',NOW(),'Rakhi',NOW(),'Rakhi');
INSERT INTO UserType VALUES(2,'User',NOW(),'Rakhi',NOW(),'Rakhi');
INSERT INTO UserType VALUES(3,'Retailer',NOW(),'Rakhi',NOW(),'Rakhi');
