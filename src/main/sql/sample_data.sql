insert into public.suppliers (id, name, description) values (1, 'Amazon', 'Digital content and and services');
insert into public.suppliers (id, name, description) values (2, 'Lenovo', 'Computers');
insert into public.suppliers (id, name, description) VALUES (3, 'Apple', 'Computers and more');
insert into public.suppliers (id, name, description) values (4, 'OnePlus', 'Mobile Phones');
insert into public.suppliers (id, name, description) VALUES (5, 'DJI', 'Drones');

insert into public.productcategory (id, name, description, departement) values (1, 'Tablet', 'A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.', 'Hardware');
insert into public.productcategory (id, name, description, departement) values (2, 'Notebook', 'Notebook is a pc that can be moved easily anywhere, anytime.', 'Hardware');
insert into public.productcategory (id, name, description, departement) values (3, 'Phone', 'Phone is a telephone.', 'Hardware');
insert into public.productcategory (id, name, description, departement) values (4, 'Accessories', 'Stuff', 'Miscellous');
insert into public.productcategory (id, name, description, departement) values (5, 'Drones', 'Flying, recording machines', 'Hardware');

insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('1', 'Amazon Fire', 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.', 'tablet', 49.9, 'USD', 'Amazon');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('2', 'Lenovo IdeaPad Miix 700', 'Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.', 'tablet', 479, 'USD', 'Lenovo');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('3', 'Amazon Fire HD 8', 'Amazons latest Fire HD 8 tablet is a great value for media consumption.', 'tablet', 89, 'USD', 'Amazon');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('4', 'Apple Macbook Pro 2017', 'Not really fantastic price. Beautiful design. Easy usage. User friendly OS', 'notebook', 1199, 'USD', 'Apple');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('5', 'OnePlus 6', 'Octa-core processor. Top class camera. Oxygen OS. NEVER SETTLE.', 'Phone', 499, 'USD', 'OnePlus');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('6', 'Apple New Mac candle', 'The scent you get when you unbox a new Macbook. Its like the new car scent I guess... maybe not', 'Accessories', 149, 'USD', 'Apple');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('7', 'DJI Mavic Pro', 'The drone you always wanted with hi def, wide-angle camera.', 'Drones', 1290, 'USD', 'DJI');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('8', 'OnePlus 6 Protection case', 'Extra protection for your precious phone.', 'Accessories', 9.99, 'USD', 'OnePlus');
insert into public.products (id, name, description, category, price, currency, supplier)
VALUES ('9', 'Apple MagSafe charger', 'Backup charger for your notebook.', 'Accessories', 59.9, 'USD', 'Apple');
