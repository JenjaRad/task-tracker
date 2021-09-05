ALTER TABLE user_role
    add constraint user_id_fk FOREIGN KEY (user_id) references user (id),
    add constraint role_id_fk FOREIGN KEY (role_id) references role (id);
