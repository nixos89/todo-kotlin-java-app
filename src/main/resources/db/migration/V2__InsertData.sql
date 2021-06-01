INSERT INTO users(user_id, description, first_name, last_name, login) VALUES(1, 'Some user Pera', 'Pera', 'Peric', 'perap');
INSERT INTO article(article_id, added_at, content, headline, slug, title, author_id) VALUES (1, CURRENT_TIMESTAMP,
        'Some content bla,...', 'Article1', 'article1', 'Some content of article 1', 1);
INSERT INTO todo(todo_id, description, title) VALUES (1, 'Flyway task', 'Implement Flyway into Kotlin project');

ALTER SEQUENCE article_sequence RESTART WITH 2;
ALTER SEQUENCE user_sequence RESTART WITH 2;
ALTER SEQUENCE todo_sequence RESTART WITH 2;




