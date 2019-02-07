CREATE TABLE user
(
  id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL
);

CREATE TABLE article
(
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title    VARCHAR(100) NOT NULL,
  type     VARCHAR(31)  NOT NULL,
  price    DOUBLE       NOT NULL,
  supplier VARCHAR(100) NOT NULL
);

CREATE TABLE lp
(
  artist VARCHAR(100),
  genre  INT,
  id     INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE game
(
  genre     INT NOT NULL,
  min_age   INT,
  id        INT NOT NULL PRIMARY KEY,
  publisher VARCHAR(100),
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE book
(
  author VARCHAR(100),
  isbn   BIGINT NOT NULL,
  pages  INT,

  id     INT    NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE non_fiction
(
  subject INT,

  id      INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE fiction
(
  genre    INT,
  synopsis VARCHAR(255),

  id       INT NOT NULL PRIMARY KEY,
  FOREIGN KEY (id) REFERENCES article (id)
);

CREATE TABLE orders
(
  id         INT AUTO_INCREMENT PRIMARY KEY,
  order_date DATETIME,
  user_id    INT,
  total      DOUBLE
);

CREATE TABLE order_line
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  quantity INT NOT NULL,
  sub_total DOUBLE,
  article_id INT,
  order_id INT
);

CREATE TABLE rating
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  user_id     INT,
  article_id  INT,
  description VARCHAR(255),
  score       INT
)

