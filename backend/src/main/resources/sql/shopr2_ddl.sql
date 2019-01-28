CREATE TABLE user (
  id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL
);

CREATE TABLE article (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title    VARCHAR(100),
  type     VARCHAR(31),
  price    DOUBLE       NOT NULL,
  supplier VARCHAR(100) NOT NULL
);

CREATE TABLE lp (
  artist VARCHAR(100),
  genre  INT,

  id     INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE game (

  id INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE book (
  author VARCHAR(100),
  isbn   BIGINT NOT NULL,
  pages  INT,

  id     INT    NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE non_fiction (
  subject INT,

  id      INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE fiction (
  genre    INT,
  synopsis VARCHAR(255),

  id       INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE order_line (
  id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE rating (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user INT,
  article INT
)

