drop table product cascade;
drop table customer cascade;
drop table orderProduct cascade;
drop table verifyOrder cascade;
 
 
 
CREATE SEQUENCE sp_customer_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

CREATE TABLE  customer (
	id int8 NOT NULL DEFAULT nextval('sp_customer_id_seq'),
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	telephone int8 NOT NULL,
	email VARCHAR(50),
	 PRIMARY KEY(id)
);

CREATE SEQUENCE sp_product_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE product (
	id int8 NOT NULL DEFAULT nextval('sp_product_id_seq'),
	productName VARCHAR(255) NOT NULL,
	productDescription VARCHAR(255),
	productPrice float8 NOT NULL,
	productQuantity int8 NOT NULL,
	productIn int8 NOT NULL, 
	productOut int8  NOT NULL,
	category VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_orderProduct_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE orderProduct (
	id int8 NOT NULL DEFAULT nextval('sp_orderProduct_id_seq'),
	customerId int8 NOT NULL, 
	productId int8 NOT NULL, 
	date TIMESTAMP,
	details VARCHAR(255),
	quantity int8,
	PRIMARY KEY( id)
);

CREATE SEQUENCE sp_employeeStaff_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE employeeStaff (
	id int8 NOT NULL DEFAULT nextval('sp_employeeStaff_id_seq'),
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	birthdate TIMESTAMP,
	address VARCHAR(255) NOT NULL,
	telephone int8 NOT NULL,
	email VARCHAR(50),
	userName VARCHAR(255),
	password VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_verifyOrder_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE verifyOrder (
	id int8 NOT NULL DEFAULT nextval('sp_verifyOrder_id_seq'),
	--productId int8 NOT NULL,
	employeeStaffId int8 NOT NULL,
	customerId int8 NOT NULL,
	orderProductId int8 NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE sp_verifiedOrder_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE verifiedOrder (
	id int8 NOT NULL DEFAULT nextval('sp_verifiedOrder_id_seq'),
	employeeStaffId int8 NOT NULL,
	customerId int8 NOT NULL,
	verifyOrderId int8 NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE sp_cashier_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE cashier (
	id int8 NOT NULL DEFAULT nextval('sp_cashier_id_seq'),
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255)NOT NULL,
	birthdate TIMESTAMP NOT NULL,
	address VARCHAR(255) NOT NULL,
	telephone int8 NOT NULL,
	email VARCHAR(50),
	PRIMARY KEY(id)
);



CREATE TABLE applyPayment(
	cashierId int8 NOT NULL,
	customerId int8 NOT NULL,
	PRIMARY KEY( cashierId, customerId)
);

CREATE SEQUENCE sp_invoiceReceipt_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE 
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE invoiceReceipt(
	id int8 NOT NULL DEFAULT nextval('sp_invoiceReceipt_id_seq'),
	customerId int8 NOT NULL,
	cashierId int8 NOT NULL,
	totalAmount int8 NOT NULL,
	date TIMESTAMP,
	price int8 NOT NULL,
	
	PRIMARY KEY (id)
);


CREATE TABLE submitProduct (
	cashierId int8 NOT NULL,
	employeeStaffId int8 NOT NULL,
	PRIMARY KEY(cashierId, employeeStaffId)
);

CREATE SEQUENCE sp_manager_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE manager (
	id int8 NOT NULL DEFAULT nextval('sp_manager_id_seq'),
	firstName  VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	telephone int8 NOT NULL,
	email VARCHAR(50),	
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_contractor_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE contractor (
	id int8 NOT NULL DEFAULT nextval('sp_contractor_id_seq'),
	companyName VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	telephone int8 NOT NULL,
	email VARCHAR(50),
	managerId int8 NOT NULL,
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_inventory_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE inventory (
	id int8 NOT NULL DEFAULT nextval('sp_inventory_id_seq'),
	managerId int8 NOT NULL,
	contractorId int8 NOT NULL,
	productId int8 NOT NULL,
	stockIn int8 NOT NULL,
	stockOut int8 NOT NULL,
	stockRecorded int8 NOT NULL,
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_salesReport_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1;

	
CREATE TABLE salesReport (
	id int8 NOT NULL DEFAULT nextval('sp_salesReport_id_seq'),
	employeeStaffId int8 NOT NULL,
	managerId int8 NOT NULL,
	salesReportDescription VARCHAR(255),
	salesQuantity int8,
	totalAmount int8 ,
	dateReport TIMESTAMP,
	PRIMARY KEY(id)
);

CREATE SEQUENCE sp_manageProduct_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 2147483647
	CACHE 1; 

	
CREATE TABLE manageProduct (
	id int8 NOT NULL DEFAULT nextval('sp_manageProduct_id_seq'),
	managerId int8 NOT NULL,
	inventoryId int8 NOT NULL,
	--manageInventory VARCHAR(255),
	totalItemAdd int8,
	totalItemDelete int8,
	PRIMARY KEY(id)
);





ALTER TABLE if EXISTS orderProduct
ADD CONSTRAINT sp_customer_fk
FOREIGN KEY (customerId) REFERENCES customer;

ALTER TABLE if EXISTS orderProduct
ADD CONSTRAINT sp_product_fk
FOREIGN KEY (productId) REFERENCES product;

ALTER TABLE if EXISTS verifyOrder
ADD CONSTRAINT sp_employeeStaff_fk
FOREIGN KEY (employeeStaffId) REFERENCES employeeStaff;


ALTER TABLE if EXISTS verifyOrder
ADD CONSTRAINT sp_customerId_fk
FOREIGN KEY (customerId) REFERENCES customer;

ALTER TABLE if EXISTS verifyOrder
ADD CONSTRAINT sp_orderProductId_fk
FOREIGN KEY (orderProductId) REFERENCES orderProduct;

ALTER TABLE if EXISTS verifiedOrder
ADD CONSTRAINT sp_verifyOrderId_fk
FOREIGN KEY (verifyOrderId) REFERENCES verifyOrder;

ALTER TABLE if EXISTS verifiedOrder
ADD CONSTRAINT sp_employeeStaff_fk
FOREIGN KEY (employeeStaffId) REFERENCES employeeStaff;

ALTER TABLE if EXISTS verifiedOrder
ADD CONSTRAINT sp_customer_fk
FOREIGN KEY (customerId) REFERENCES customer;


ALTER TABLE if EXISTS applyPayment
ADD CONSTRAINT sp_cashier_fk
FOREIGN KEY (cashierId) REFERENCES cashier;

ALTER TABLE if EXISTS applyPayment
ADD CONSTRAINT sp_customer_fk
FOREIGN KEY (customerId) REFERENCES customer;


ALTER TABLE if EXISTS invoiceReceipt
ADD CONSTRAINT sp_customer_fk
FOREIGN KEY (customerId) REFERENCES customer;

ALTER TABLE if EXISTS invoiceReceipt
ADD CONSTRAINT sp_cashier_fk
FOREIGN KEY (cashierId) REFERENCES cashier;

--ALTER TABLE if EXISTS invoiceReceipt
--ADD CONSTRAINT sp_verifiedOrder_fk
--FOREIGN KEY (verifiedOrderId) REFERENCES verifiedOrder;

ALTER TABLE if EXISTS submitProduct
ADD CONSTRAINT sp_cashier_fk
FOREIGN KEY (cashierId) REFERENCES cashier;

ALTER TABLE if EXISTS submitProduct
ADD CONSTRAINT sp_employeeStaff_fk
FOREIGN KEY (employeeStaffId) REFERENCES employeeStaff;

ALTER TABLE IF EXISTS contractor
ADD CONSTRAINT sp_manager_fk
FOREIGN KEY (managerId) REFERENCES manager;

ALTER TABLE IF EXISTS inventory
ADD CONSTRAINT sp_manager_fk
FOREIGN KEY (managerId) REFERENCES manager;

ALTER TABLE IF EXISTS inventory
ADD CONSTRAINT sp_contractor_fk
FOREIGN KEY (contractorId) REFERENCES contractor;

ALTER TABLE IF EXISTS inventory
ADD CONSTRAINT sp_product_fk
FOREIGN KEY (productId) REFERENCES product;

ALTER TABLE if EXISTS salesReport
ADD CONSTRAINT sp_employeeStaff_fk
FOREIGN KEY (employeeStaffId) REFERENCES employeeStaff;

ALTER TABLE IF EXISTS salesReport
ADD CONSTRAINT sp_manager_fk
FOREIGN KEY (managerId) REFERENCES manager;

ALTER TABLE IF EXISTS manageProduct
ADD CONSTRAINT sp_manager_fk
FOREIGN KEY (managerId) REFERENCES manager;

ALTER TABLE IF EXISTS manageProduct
ADD CONSTRAINT sp_inventory_fk
FOREIGN KEY (inventoryId) REFERENCES inventory;
