CREATE TABLE user (
  id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL
);

CREATE TABLE article (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title    VARCHAR(100),
  type     VARCHAR(31),
  price    DOUBLE,
  supplier VARCHAR(100)
);

CREATE TABLE lp (
  artist INT,
  genre  INT
)
