CREATE TABLE if not exists project
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    created datetime              NULL,
    updated datetime              NULL,
    name    VARCHAR(50)           NOT NULL,
    state   VARCHAR(255)          NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

ALTER TABLE project
    ADD CONSTRAINT uc_project_id UNIQUE (id);

INSERT into project(id, created, updated, name, state)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Worldliness', 'IN_PROGRESS');

INSERT into project(id, created, updated, name, state)
VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Happiness', 'DONE')