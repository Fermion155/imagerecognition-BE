INSERT INTO category(name, allowed) VALUES('Fashion accessories', true);
INSERT INTO category(name, allowed) VALUES('All types of clothes', true);
INSERT INTO category(name, allowed) VALUES('All kinds of footwear', true);
INSERT INTO category(name, allowed) VALUES('Cosmetics', true);
INSERT INTO category(name, allowed) VALUES('Children toys', true);
INSERT INTO category(name, allowed) VALUES('Tech accessories', true);
INSERT INTO category(name, allowed) VALUES('Pet care products', true);

INSERT INTO category(name, allowed) VALUES('Food products', false);
INSERT INTO category(name, allowed) VALUES('Sports equipment', false);
INSERT INTO category(name, allowed) VALUES('Tobacco products', false);
INSERT INTO category(name, allowed) VALUES('Cleaning supplies', false);
INSERT INTO category(name, allowed) VALUES('Weapons and armory', false);
INSERT INTO category(name, allowed) VALUES('Vehicles and automotive parts', false);
INSERT INTO category(name, allowed) VALUES('Natural fur products', false);

INSERT INTO label(name, category_id) VALUES('Apparel and Accessories', (SELECT id FROM category WHERE name = 'Fashion accessories'));
INSERT INTO label(name, category_id) VALUES('Clothing', (SELECT id FROM category WHERE name = 'All types of clothes'));
INSERT INTO label(name, category_id) VALUES('Footwear', (SELECT id FROM category WHERE name = 'All kinds of footwear'));
INSERT INTO label(name, category_id) VALUES('Cosmetics', (SELECT id FROM category WHERE name = 'Cosmetics'));
INSERT INTO label(name, category_id) VALUES('Toy', (SELECT id FROM category WHERE name = 'Children toys'));
INSERT INTO label(name, category_id) VALUES('Technology and Computing', (SELECT id FROM category WHERE name = 'Tech accessories'));
INSERT INTO label(name, category_id) VALUES('Animals and Pets', (SELECT id FROM category WHERE name = 'Pet care products'));

INSERT INTO label(name, category_id) VALUES('Food', (SELECT id FROM category WHERE name = 'Food products'));
INSERT INTO label(name, category_id) VALUES('Sports', (SELECT id FROM category WHERE name = 'Sports equipment'));
INSERT INTO label(name, category_id) VALUES('Tobacco', (SELECT id FROM category WHERE name = 'Tobacco products'));
INSERT INTO label(name, category_id) VALUES('Cleaning', (SELECT id FROM category WHERE name = 'Cleaning supplies'));
INSERT INTO label(name, category_id) VALUES('Weapon', (SELECT id FROM category WHERE name = 'Weapons and armory'));
INSERT INTO label(name, category_id) VALUES('Vehicles and Automotive', (SELECT id FROM category WHERE name = 'Vehicles and automotive parts'));
INSERT INTO label(name, category_id) VALUES('Fur', (SELECT id FROM category WHERE name = 'Natural fur products'));