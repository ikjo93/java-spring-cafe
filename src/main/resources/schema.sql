DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    user_id VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS article;

CREATE TABLE article
(
    id INT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(255) NOT NULL,
    writer VARCHAR(255),
    title VARCHAR(255),
    contents VARCHAR(255),
    created_date TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);
