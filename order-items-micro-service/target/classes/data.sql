
DROP TABLE IF EXISTS order_item;
 
CREATE TABLE order_item (
  product_code INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  product_quantity INT NOT NULL  
);
 
INSERT INTO order_item (product_name, product_quantity) VALUES
  ( 'Story Book', 2),
  ( 'Fountain Pen', 5),
  ( 'Mobile', 1);