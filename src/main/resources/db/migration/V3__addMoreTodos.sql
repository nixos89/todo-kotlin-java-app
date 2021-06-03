INSERT INTO todo(todo_id, description, title) VALUES (2, 'Implement REST API', 'Implement REST API into Kotlin project');
INSERT INTO todo(todo_id, description, title) VALUES (3, 'Push to GitHub', 'Push createdKotlin project');

ALTER SEQUENCE todo_sequence RESTART WITH 3;
ALTER SEQUENCE todo_sequence RESTART WITH 4;