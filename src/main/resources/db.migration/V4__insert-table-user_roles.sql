INSERT INTO roles (name) VALUES ('USER'), ('ADMIN');

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'USER'
WHERE u.email = 'cristi@email.com';