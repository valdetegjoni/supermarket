INSERT INTO customer (id,firstName, lastName, address, telephone, email)
VALUES
(1,'ema', 'dante', 'via feuerbach', 12345678, 'gj@v.com');

INSERT INTO customer (id,firstName, lastName, address, telephone, email)
VALUES
(2,'enea', 'rossi', 'via feuerbach1', 123456781, 'gj1@vte.com');

INSERT INTO customer (firstName, lastName, address, telephone, email)
VALUES
('paola', 'cecina', 'via feuerbach2', 123456782, 'gj2@val.com');

INSERT INTO invoicereceipt (id,customer_id, cashier_id, total_amount, date, price)
VALUES
(1,2, 5,  10, to_timestamp('16-05-2021 15:36:38', 'dd-mm-yyyy hh24:mi:ss'), 120);

INSERT INTO cashier (id, first_name, last_name, address, telephone, email, birthdate)
VALUES
(5,'enrico', 'bossi', 'via feuerbach2', 123456782, 'gj2@val.com', to_timestamp('2-11-1981 15:36:38', 'dd-mm-yyyy hh24:mi:ss'));