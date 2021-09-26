ALTER TABLE task
    add column user_id BIGINT not null;

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);