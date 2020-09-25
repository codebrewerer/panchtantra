DELETE FROM panch.otts;

INSERT INTO panch.otts
VALUES
(1, 'Netflix', 'ACTIVE', now(), now()),
(2, 'Hotstar', 'ACTIVE', now(), now()),
(3, 'Amazon', 'ACTIVE', now(), now()),
(4, 'Sony Liv', 'ACTIVE', now(), now());


DELETE FROM panch.packages;

INSERT INTO panch.packages
(id,name,num_seats,basis,pricing,currency,status,otts_id,created_at,updated_at)
VALUES
(10, 'Standard - HD', 2, 'MONTHLY',649.0,'INR','ACTIVE',1, now(), now()),
(20, 'Premium - 4K', 4, 'MONTHLY',799.0,'INR','ACTIVE',1, now(), now()),
(30, 'Hotstar VIP', 2, 'YEARLY',1099.0,'INR','ACTIVE',2, now(), now()),
(40, 'Hotstar Disney Plus', 4, 'YEARLY',1499.0,'INR','ACTIVE',2, now(), now()),
(50, 'Amazon Prime Monthly', 3, 'MONTHLY',299.0,'INR','ACTIVE',3, now(), now()),
(60, 'Amazon Prime Yearly', 3, 'YEARLY',999.0,'INR','ACTIVE',3, now(), now()),
(70, 'LIV Premium - Monthly', 4, 'MONTHLY',499.0,'INR','ACTIVE',4, now(), now()),
(80, 'LIV Premium - Yearly', 4, 'Yearly',799.0,'INR','ACTIVE',4, now(), now());

DELETE FROM panch.inventories;

INSERT INTO panch.inventories
(id,num_seats,status,ott_user_name,ott_password,starts_at,expires_at,created_at,updated_at,users_id,packages_otts_id)
VALUES
(101,2,'ACTIVE','XXXXXX','XXXXXX',STR_TO_DATE('01/09/2020', '%d/%m/%Y'),STR_TO_DATE('30/09/2020', '%d/%m/%Y'),now(),now(),1001,10),
(102,1,'ACTIVE','XXXXXX','XXXXXX',STR_TO_DATE('01/09/2020', '%d/%m/%Y'),STR_TO_DATE('30/09/2020', '%d/%m/%Y'),now(),now(),2001,10);


DELETE FROM panch.users;

INSERT INTO panch.users
(id,email,name)
VALUES
(1001,'raunak.kumar@panchtatra.com','Raunak Kumar'),
(2001,'rohit.sharma@panchtatra.com','Rohit Sharma'),
(3001,'kanica.wadhwa@panchtatra.com','Kanica Wadhwa'),
(4001,'satam.guin@panchtatra.com','Satam Guin'),
(5001,'nishant.chauhan@panchtatra.com','Nishant Chauhan');