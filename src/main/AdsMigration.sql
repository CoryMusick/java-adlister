USE adlister_db;

DROP TABLE if exists users;
CREATE TABLE users(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username varchar(150) NOT NULL,
  email varchar(150) NOT NULL,
  password varchar(25) NOT NULL,
  Primary KEY (id)
);

DROP TABLE if exists ads;
CREATE TABLE ads(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(150) NOT NULL,
  description TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)

);