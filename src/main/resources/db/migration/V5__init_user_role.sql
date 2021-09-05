CREATE table if not exists user_role
(
    user_id BIGINT not null unique ,
    role_id BIGINT not null unique ,
    PRIMARY KEY(user_id,role_id)
);