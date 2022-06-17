CREATE TABLE task
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    project_id  BIGINT,
    name        VARCHAR(255),
    assignee_id BIGINT,
    end_date    TIMESTAMP WITHOUT TIME ZONE,
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE "user"
    ADD COLUMN "email" VARCHAR(255) NOT NULL;

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ASSIGNEE FOREIGN KEY (assignee_id) REFERENCES "user" (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_MANAGER FOREIGN KEY (manager_id) REFERENCES "user" (id);

CREATE INDEX idx_project_name ON project (name);