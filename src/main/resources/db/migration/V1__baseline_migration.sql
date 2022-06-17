CREATE TABLE "user"
(
    id       BIGINT                NOT NULL,
    name     VARCHAR(255)          NOT NULL,
    username VARCHAR DEFAULT '255' NOT NULL,
    password VARCHAR(255)          NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE project
(
    id         BIGINT NOT NULL,
    name       VARCHAR DEFAULT '255',
    start_date TIMESTAMP WITHOUT TIME ZONE,
    end_date   TIMESTAMP WITHOUT TIME ZONE,
    manager_id BIGINT,
    CONSTRAINT project_pk PRIMARY KEY (id)
);

ALTER TABLE project
    ADD CONSTRAINT project_user_id_fk FOREIGN KEY (manager_id) REFERENCES "user" (id) ON UPDATE NO ACTION ON DELETE NO ACTION;