DELIMITER $$

CREATE TRIGGER update_history
AFTER UPDATE ON product
FOR EACH ROW
BEGIN
IF (SIGN(NEW.amount - OLD.amount) = 1) THEN
INSERT INTO product_history (number_of_ordered_products, product_id, user_id, changed_on, type_of_change)
VALUES ((NEW.amount - OLD.amount), NEW.id, NEW.user_id, now(), 'update');
ELSE
INSERT INTO product_history (number_of_ordered_products, product_id, user_id, changed_on, type_of_change)
VALUES ((NEW.amount - OLD.amount), NEW.id, NEW.user_id, now(), 'order');
END IF;
END$$

DELIMITER ;