CREATE TABLE attribute_set (
  id   BIGINT       NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE attribute_value (
  id     BIGINT       NOT NULL AUTO_INCREMENT,
  value  VARCHAR(255) NOT NULL,
  set_id BIGINT,
  PRIMARY KEY (id)
);

ALTER TABLE attribute_value
ADD CONSTRAINT FK_4iwuw9jfd04gcdp7v13hmx7k1
FOREIGN KEY (set_id)
REFERENCES attribute_set (id);