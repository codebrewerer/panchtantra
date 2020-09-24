insert into otts values (1, 'Netflix', 'ACTIVE', now(), now()), (2, 'Hotstar', 'ACTIVE', now(), now()), (3, 'Amazon', 'ACTIVE', now(), now()), (4, 'Sony Liv', 'ACTIVE', now(), now());


insert into packages(id,name,num_seats,basis,pricing,currency,status,otts_id,created_at,updated_at) values (1, 'High Definition', 2, 'MONTHLY',499.0,'INR','ACTIVE',1, now(), now()), (2, '4K', 4, 'MONTHLY',799.0,'INR','ACTIVE',1, now(), now());


INSERT INTO `panch`.`inventories`
(`id`,
 `num_seats`,
 `status`,
 `starts_at`,
 `expires_at`,
 `created_at`,
 `updated_at`,
 `users_id`,
 `packages_otts_id`)
VALUES
(
    101,
    2,
    'ACTIVE',
    STR_TO_DATE('01/09/2020', '%d/%m/%Y'),
    STR_TO_DATE('30/09/2020', '%d/%m/%Y'),
    now(),
    now(),
    1,
    1
);

INSERT INTO `panch`.`inventories`
(`id`,
 `num_seats`,
 `status`,
 `starts_at`,
 `expires_at`,
 `created_at`,
 `updated_at`,
 `users_id`,
 `packages_otts_id`)
VALUES
(
    102,
    1,
    'ACTIVE',
    STR_TO_DATE('01/09/2020', '%d/%m/%Y'),
    STR_TO_DATE('30/09/2020', '%d/%m/%Y'),
    now(),
    now(),
    1,
    1
);