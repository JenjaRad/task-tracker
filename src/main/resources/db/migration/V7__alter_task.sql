ALTER TABLE project
    drop column state;

ALTER TABLE task
    add column project_id BIGINT not null;

ALTER TABLE task
    ADD CONSTRAINT FK_PROJECT_ID FOREIGN KEY (project_id) REFERENCES project (id);