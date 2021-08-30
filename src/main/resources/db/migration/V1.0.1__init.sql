CREATE TABLE Brand (
  id INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE Price (
  brand_id INT NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_list INT NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price DOUBLE NOT NULL,
  currency VARCHAR(5) DEFAULT NOT NULL,
  last_update TIMESTAMP NULL,
  last_update_by VARCHAR(250) NULL,
  PRIMARY KEY (brand_id, price_list, product_id, priority),
  CONSTRAINT fk_price_brand
  FOREIGN KEY (brand_id)
  REFERENCES Brand (id)
);