CREATE TABLE if not exists user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created    datetime              NULL,
    updated    datetime              NULL,
    username   VARCHAR(255)          NULL,
    first_name VARCHAR(255)          NULL,
    last_name  VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    password   VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_id UNIQUE (id);