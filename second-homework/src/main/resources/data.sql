INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 1 , 'First Name' , 'First Surname' , 'first@mail.com', '1111', 'first_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 2 , 'Second Name' , 'Second Surname' , 'seconf@mail.com', '2222', 'second_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 3 , 'Third Name' , 'Third Surname' , 'third@mail.com', '3333', 'third_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 4 , 'Fourth Name' , 'Fourth Surname' , 'fourth@mail.com', '4444', 'fourth_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 5 , 'Fiveth Name' , 'Fiveth Surname' , 'fiveth@mail.com', '5555', 'fiveth_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 6 , 'Sixth Name' , 'Sixth Surname' , 'sixth@mail.com', '6666', 'sixth_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 7 , 'Seventh Name' , 'Seventh Surname' , 'seventh@mail.com', '7777', 'seventh_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 8 , 'Eighted Name' , 'Eightd Surname' , 'eighted@mail.com', '8888', 'eighted_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 9 , 'Nineth Name' , 'Nineth Surname' , 'nineth@mail.com', '9999', 'nineth_username');
INSERT INTO public.USER( ID, NAME, SURNAME, EMAIL, PHONE, USERNAME) VALUES ( 10 , 'Tenth Name' , 'Tenth Surname' , 'tenth@mail.com', '1010', 'tenth_username');
alter sequence user_id_seq restart with 11;

-- Category Inserts
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	1	,'Moda',	1	,	null	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	2	,'Elektronik',	1	,	null	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	3	,'Ev & Yaşam',	1	,	null	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	4	,'Elbise',	2	,	1	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	5	,'Gömlek',	2	,	1	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	6	,'Bilgisayar',	2	,	2	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	7	,'Dizüstü Bilgisayar',	3	,	6	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	8	,'Mobilya',	2	,	3	);
INSERT INTO public.CATEGORY( ID, NAME, BREAKDOWN, ID_TOP_CATEGORY)  VALUES (	9	,'Sehpa',	3	,	8	);
alter sequence category_id_seq restart with 10;

-- Product Inserts
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	1	,'Mavi Elbise',	200	, now(), 	4);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	2	,'Kırmızı Elbise',	300	, now(), 	4);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	3	,'Mavi Gömlek',	500	, now(), 	5);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	4	,'Sarı Gömlek',	450	, now(), 	5);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	5	,'HP ',	15000	, now(), 	7);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	6	,'MSI',	20000	, now(), 	7);
INSERT INTO public.PRODUCT( ID, NAME, PRICE, REGISTRATION_DATE, ID_CATEGORY) VALUES (	7	,'Orta Sehpa',	600	, now(), 	9);
alter sequence product_id_seq restart with 8;

-- Product Comment Inserts
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	1	, 'First Comment', '2020-12-01', 1 , 1);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	2	, 'Second Comment', '2020-12-02', 1 , 2);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	3	, 'Third Comment', '2020-12-03', 2 , 3);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	4	, 'Fourth Comment', '2020-12-04', 3 , 3);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	5	, 'Fiveth Comment', '2020-12-05', 4 , 5);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	6	, 'Sixth Comment','2020-12-06' , 5 , 4);
INSERT INTO public.PRODUCTCOMMENT( ID, COMMENT, COMMENT_DATE, ID_PRODUCT, ID_USER) VALUES (	7	, 'Seventh Comment', '2020-12-07', 6 , 4);
alter sequence productcomment_id_seq restart with 8;