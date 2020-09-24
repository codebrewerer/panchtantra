insert into otts values (1, 'Netflix', 'ACTIVE', now(), now()), (2, 'Hotstar', 'ACTIVE', now(), now()), (3, 'Amazon', 'ACTIVE', now(), now()), (4, 'Sony Liv', 'ACTIVE', now(), now());


insert into packages(id,name,num_seats,basis,pricing,currency,status,otts_id,created_at,updated_at) values (1, 'High Definition', 2, 'MONTHLY',499.0,'INR','ACTIVE',1, now(), now()), (2, '4K', 4, 'MONTHLY',799.0,'INR','ACTIVE',1, now(), now());