CREATE TABLE writers (
                         id int auto_increment NOT NULL,
                         name varchar(255) NOT NULL,
                         PRIMARY KEY (id)
);

INSERT INTO writers VALUES(1, 'writer1');
INSERT INTO writers VALUES(2, 'writer2');
INSERT INTO writers VALUES(3, 'writer3');

CREATE TABLE tags (
                      id int auto_increment NOT NULL,
                      name varchar(255) NOT NULL,
                      PRIMARY KEY (id)
);

INSERT INTO tags VALUES(1, 'tag1');
INSERT INTO tags VALUES(2, 'tag2');
INSERT INTO tags VALUES(3, 'tag3');

CREATE TABLE posts (
                       id int auto_increment NOT NULL,
                       content text NOT NULL,
                       writer_id int NOT NULL,
                       tag_status varchar(255) NOT NULL,
                       PRIMARY KEY (id),
                       CONSTRAINT `posts_writers` FOREIGN KEY (writer_id) REFERENCES writers (id) ON DELETE CASCADE
);

INSERT INTO posts VALUES(1, 'content1', 1, 'ACTIVE');
INSERT INTO posts VALUES(2, 'content2', 2, 'ACTIVE');
INSERT INTO posts VALUES(3, 'content3', 3, 'ACTIVE');

CREATE TABLE posts_tags (
                            post_id int DEFAULT NULL,
                            tag_id int DEFAULT NULL,
                            CONSTRAINT posts_tags_ibfk_1 FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE,
                            CONSTRAINT posts_tags_ibfk_2 FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE
);

INSERT INTO posts_tags VALUES(1, 1);
INSERT INTO posts_tags VALUES(1, 3);
INSERT INTO posts_tags VALUES(2, 2);
INSERT INTO posts_tags VALUES(2, 3);
INSERT INTO posts_tags VALUES(3, 1);
INSERT INTO posts_tags VALUES(3, 2);