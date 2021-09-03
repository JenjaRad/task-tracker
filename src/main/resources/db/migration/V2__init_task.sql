CREATE TABLE if not exists task
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created       datetime              NULL,
    updated       datetime              NULL,
    name          VARCHAR(50)           NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    state         VARCHAR(255)          NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE task
    ADD CONSTRAINT uc_task_id UNIQUE (id);