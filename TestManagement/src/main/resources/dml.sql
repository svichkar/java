--Fill 'role' table:
INSERT INTO role (role_id, role_name) VALUES (1,'admin'), (2, 'user');

--Fill 'user' table:
INSERT INTO user (first_name, last_name, email, login, password, role_id) VALUES ('Manager', 'First', 'one@gmail.com', 'user', 'user', 2);
INSERT INTO user (first_name, last_name, email, login, password, role_id) VALUES ('Admin', 'Second', 'admin2@gmail.com', 'admin', 'admin', 1);