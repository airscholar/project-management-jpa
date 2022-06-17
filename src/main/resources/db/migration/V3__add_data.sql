INSERT INTO public.user (id, name, username, email, password)
VALUES (1, 'John', 'john@doe.com', 'john@doe.com', '123456');

INSERT INTO project (id, name, start_date, manager_id)
VALUES (1, 'Maniclus', NOW(), 1);

INSERT INTO task (id, project_id, name, start_date, assignee_id)
VALUES (1, 1, 'Structural Plan', NOW(), 1);

INSERT INTO task (id, project_id, name, assignee_id)
VALUES (2, 1, 'Structural Plan', 1);

