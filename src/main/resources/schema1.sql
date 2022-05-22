CREATE TABLE payments
(
    customerNumber int(11) NOT NULL,
    checkNumber    varchar(50)    NOT NULL,
    paymentDate    date           NOT NULL,
    amount         decimal(10, 2) NOT NULL
);