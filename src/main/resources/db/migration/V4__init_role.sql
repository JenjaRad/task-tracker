CREATE TABLE if not exists `role`
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created       datetime              NULL,
    updated       datetime              NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE `role`
    ADD CONSTRAINT uc_role_id UNIQUE (id);