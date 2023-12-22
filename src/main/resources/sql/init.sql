
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, first_name, last_name, year_of_birth, salary, email, password)
VALUES ('admin', 'Oleg', 'Petrov', 1999, 650, 'Oleg@mail.ru', '$2a$10$OgXqTzZJ.WcVbDSB8wo9oeUWdTdNVbjhvbva6ggF6gJkztIMAlxda');

INSERT INTO users (username, first_name, last_name, year_of_birth, salary, email, password)
VALUES ('user', 'Alex', 'Lincoln', 1995, 1250, 'Alex@yandex.ru', '$2a$10$sZ7Gt1FO9ShakySqmqzVcOVXsDha2d.FVmYfc0NUlDTQg1LDxBaBW');

INSERT INTO users_roles (user_id, role_id)
VALUES ((SELECT id FROM users WHERE username = 'admin'),(SELECT id FROM roles WHERE name = 'ROLE_ADMIN'));

INSERT INTO users_roles (user_id, role_id)
VALUES ((SELECT id FROM users WHERE username = 'user'),(SELECT id FROM roles WHERE name = 'ROLE_USER'));