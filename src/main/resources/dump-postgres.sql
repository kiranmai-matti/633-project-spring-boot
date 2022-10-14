--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-10-13 17:18:38

SET
statement_timeout = 0;
SET
lock_timeout = 0;
SET
idle_in_transaction_session_timeout = 0;
SET
client_encoding = 'UTF8';
SET
standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET
check_function_bodies = false;
SET
xmloption = content;
SET
client_min_messages = warning;
SET
row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER
SCHEMA public OWNER TO postgres;

--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT
ON SCHEMA public IS 'standard public schema';


SET
default_tablespace = '';

SET
default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 16445)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category
(
    category_id   integer                NOT NULL,
    category_name character varying(100) NOT NULL,
    parent_id     integer
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16427)
-- Name: cust_address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cust_address
(
    cust_address_id integer               NOT NULL,
    addr_1          character varying(50) NOT NULL,
    addr_2          character varying(50),
    city            character varying(50) NOT NULL,
    state           character varying(50) NOT NULL,
    zipcode         integer               NOT NULL,
    country         character varying(50) NOT NULL
);


ALTER TABLE public.cust_address OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16416)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer
(
    cust_id          integer                NOT NULL,
    first_name       character varying(50)  NOT NULL,
    last_name        character varying(50),
    mobile_no        integer,
    email            character varying(50)  NOT NULL,
    shipping_addr_id integer,
    billing_addr_id  integer,
    password         character varying(100) NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16444)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16490)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product
(
    prd_id      integer                NOT NULL,
    prd_code    integer                NOT NULL,
    prd_name    character varying(500) NOT NULL,
    prd_img_url character varying(500),
    prd_desc    character varying(1000),
    prd_price   real DEFAULT 10        NOT NULL,
    category_id integer                NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 3337 (class 0 OID 16445)
-- Dependencies: 213
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.category
VALUES (201, 'Laptops', NULL);
INSERT INTO public.category
VALUES (202, 'Desktops', NULL);
INSERT INTO public.category
VALUES (203, 'Tablets', NULL);
INSERT INTO public.category
VALUES (204, 'Cell Phones', NULL);
INSERT INTO public.category
VALUES (205, 'Wearable Technology', NULL);
INSERT INTO public.category
VALUES (206, 'TV', NULL);


--
-- TOC entry 3335 (class 0 OID 16427)
-- Dependencies: 211
-- Data for Name: cust_address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cust_address
VALUES (1, '561 Hardy St', NULL, 'Hattiesburg', 'MS', 39406, 'US');


--
-- TOC entry 3334 (class 0 OID 16416)
-- Dependencies: 210
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer
VALUES (4, 'Kiranmai', 'Matti', 1234567890, 'kiranmai@gmail.com', NULL, NULL,
        '$2a$10$T5LYMTq/v9Wr3LnvcmyY5ul9ELf0h41v2bN5lQBukh7MH.KJu7l6G');
INSERT INTO public.customer
VALUES (2, 'Radhey', 'Shyam', 1234567890, 'bestbuy2@gmail.com', NULL, NULL,
        '$2a$10$dN7NUfgk4zLvFF3iGTCaYuMs9IIlmHhoCBSp3t1Csrd1IJwYyem5O');
INSERT INTO public.customer
VALUES (3, 'Mahesh', 'Krishna', 1234567890, 'bestbuy3@gmail.com', NULL, NULL,
        '$2a$10$DQ7TVeeud9Lsf5U7lG9FF.p7utUv1iciXUDCceIuurjWBHVmt8xqm');
INSERT INTO public.customer
VALUES (1, 'James', 'Smith', 1234567890, 'bestbuy@gmail.com', 1, 1,
        '$2a$10$ziDKrNa8K.5zD9rI.iY5i.EJbZV5gD8yubTQZXWTg98QpLEngzkr6');


--
-- TOC entry 3338 (class 0 OID 16490)
-- Dependencies: 214
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product
VALUES (902, 6495282,
        'Apple Watch Series 8 GPS + Cellular 45mm Graphite Stainless Steel Case with Graphite Milanese Loop - Graphite',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6495/6495282_sd.jpg',
        'Apple Watch Series 8 features advanced health sensors and apps, so you can take an ECG¹, measure heart rate¹ and blood oxygen², and track temperature changes³ for advanced insights into your menstrual cycle⁴. And with Crash Detection, sleep stages tracking, and advanced workout metrics, it helps you stay active, healthy, safe, and connected. See Dimension section below for band sizing information',
        790, 205);
INSERT INTO public.product
VALUES (901, 6340256, 'Apple Watch Series 8 45mm Midnight Aluminum Case with Midnight Sport Band - M/L - Midnight',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6340/6340256_sd.jpg',
        'Apple Watch Series 8 features advanced health sensors and apps, so you can take an ECG¹, measure heart rate¹ and blood oxygen², and track temperature changes³ for advanced insights into your menstrual cycle⁴. And with Crash Detection, sleep stages tracking, and advanced workout metrics, it helps you stay active, healthy, safe, and connected. See Dimension section below for band sizing information',
        430, 205);
INSERT INTO public.product
VALUES (903, 6514030, 'Fitbit - Inspire 3 Health & Fitness Tracker - Midnight Zen',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6514/6514030_sd.jpg',
        'Do what you love and feel your best with Inspire 3. This little health hack on your wrist helps you stay on top of your stress, fitness and sleep--all you have to do is wear it. Track Health Metrics like skin temperature & blood oxygen, plus get daily scores that show how ready you are to workout or how well you''re managing stress. Includes a 6-month Fitbit Premium membership1. Fitbit is part of the Google family',
        99, 205);
INSERT INTO public.product
VALUES (904, 6426002, 'Fitbit - Sense Advanced Health Smartwatch - Graphite',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6426/6426002_sd.jpg',
        'Do what you love and feel your best with Inspire 3. This little health hack on your wrist helps you stay on top of your stress, fitness and sleep--all you have to do is wear it. Track Health Metrics like skin temperature & blood oxygen, plus get daily scores that show how ready you are to workout or how well you''re managing stress. Includes a 6-month Fitbit Premium membership1. Fitbit is part of the Google family',
        199, 205);
INSERT INTO public.product
VALUES (906, 6492440, 'Garmin - Venu 2 Plus GPS Smartwatch 43 mm Fiber-reinforced polymer - Slate',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6492/6492440_sd.jpg',
        'Dial in to your well-being with Venu 2 Plus. This GPS smartwatch has advanced health and fitness features to help you better understand your body. When paired with your compatible smartphone, enjoy the convenience of keeping that phone in your pocket, and making and taking calls right from your wrist. You can even use your smartphone’s voice assistant to respond to text messages. Switch up your activities with animated workouts and more than 25 built-in sports apps. Built-in music storage lets you bring your favorite tunes along. And get even more functionality on the wrist with Garmin Pay contactless payments in supported countries and payment networks, safety tracking features and more (Requires setup and your smartphone to be in an area with network coverage where data connectivity is available)',
        449, 205);
INSERT INTO public.product
VALUES (905, 6464608, 'Samsung - Galaxy Watch4 Classic Stainless Steel Smartwatch 46mm BT - Black	',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6464/6464608_sd.jpg',
        'Your style. Your health. Look good and feel great with your smart, new companion, Samsung Galaxy Watch4 Classic. Make a stylish statement with an iconic silhouette and stainless-steel casing, while your watch keeps you in tune with your health and pushes you to go further. Make the most of every run with advanced coaching and oxygen-level monitoring¹ that help you exercise smarter while increasing endurance. Leave your phone behind while staying connected — call, text and stream music,all from your wrist with LTE connectivity. Galaxy Watch4 Classic is health evolved. 1Accurate VO2 max reading requires running outdoors for at least 20 minutes with GPS on; consult user manual before use. ¹The VO2 max software functions are not intended for use in the diagnosis of disease or other conditions, or in the cure, mitigation, treatment or prevention of disease',
        339, 205);
INSERT INTO public.product
VALUES (907, 6463115, 'Insignia™ - 58" Class F30 Series LED 4K UHD Smart Fire TV',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6463/6463115_sd.jpg',
        'Take in every moment with breathtaking 4K Ultra HD on this 58-inch screen. It’s equipped with DTS Studio Sound to create realistic and immersive audio. Access live over-the-air channels and streaming—and control it all with your voice. Ask Alexa to launch apps, search for titles and more. Experience the affordable, yet high-performing Insignia NS-58F301NA22 58" Class F30 Series LED 4K UHD Smart Fire TV',
        299, 206);
INSERT INTO public.product
VALUES (908, 6500473, 'TCL - 65" Class 4-Series 4K UHD HDR Smart Roku TV',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6500/6500473_sd.jpg', 'The 4-Series TCL Roku TV offers stunning 4K picture quality with four times the resolution of Full HD for enhanced clarity and detail, as well as endless entertainment with thousands of streaming channels. High dynamic range (HDR) technology delivers bright and accurate colors for a lifelike viewing experience. In addition, your favorite HD shows, movies, and sporting events are enhanced to near Ultra HD resolution with 4K Upscaling. Your favorite broadcast TV, streaming channels, gaming console and other devices are front-and-center within a simple, customizable home screen. There’s no more flipping through inputs or wading through complicated menus. The super-simple remote—with about half the number of buttons on a traditional TV remote—puts you in control of your favorite entertainment and includes one-touch shortcuts to popular channels like Netflix.
', 399, 206);
INSERT INTO public.product
VALUES (909, 6401722, 'Samsung - 65" Class 7 Series LED 4K UHD Smart Tizen TV',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6401/6401722_sd.jpg',
        'Enhance your viewing experience with this 65-inch Samsung 4K UHD smart TV. The HDR technology and 4K UHD resolution render sharp details and realistic colors, while a Crystal processor delivers exceptional picture quality on the flat-panel display. This Bluetooth-enabled Samsung 4K UHD smart TV is voice controllable for hands-free operation and seamless wireless streaming.',
        499, 206);
INSERT INTO public.product
VALUES (910, 6401195, 'Sony - 48" Class BRAVIA A9S Series OLED 4K UHD Smart Android TV',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6401/6401195_sd.jpg',
        'Experience deep black and natural colors of OLED in a more compact size, powered by the Picture Processor X1 Ultimate. Complimented by Acoustic Surface Audio, sound comes from the entire screen to put picture and sound in perfect harmony. Enjoy OLED picture quality and cinematic audio packed into a beautifully compact form with Sony’s 48” MASTER Series A9S BRAVIA OLED TV.',
        799, 206);
INSERT INTO public.product
VALUES (911, 6510138, 'VIZIO - 65" Class MQX Series Premium 4K QLED HDR Smart TV',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6510/6510138_sd.jpg',
        'Experience the extraordinary. Celebrate VIZIO’s 20th Anniversary with the NEW VIZIO M-Series Quantum X 4K HDR Smart TV. Step up to immersive Active Full Array LED streaming and gaming with 1 billion+ colors of picture perfection and up to 1000 nits high peak brightness - all wrapped in VIZIO’s ThinFrame Design. America’s Smart TV gives you millions of movies, shows, sports, news, free channels, and more in seconds.',
        839, 206);
INSERT INTO public.product
VALUES (912, 6479718, 'Amazon - 75" Class Omni Series 4K UHD Smart Fire TV hands-free with Alexa',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6479/6479718_sd.jpg',
        'Put down the remote and dive into entertainment with your voice. Fire TV Omni Series brings 4K Ultra HD entertainment, brilliant picture quality, Dolby Digital Plus, access to more than 1 million movies and TV episodes, and the magic of hands-free control with Alexa to your living room. B08T6JZTH4',
        1099, 206);
INSERT INTO public.product
VALUES (913, 6450853,
        'MacBook Pro 14" Laptop - Apple M1 Pro chip - 16GB Memory - 512GB SSD (Latest Model) - Space Gray',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6450/6450853_sd.jpg',
        'The new MacBook Pro delivers game-changing performance for pro users. With the powerful M1 Pro to supercharge pro-level workflows while getting amazing battery life.¹ And with an immersive 14-inch Liquid Retina XDR display and an array of pro ports, you can do more than ever with MacBook Pro',
        1999, 201);
INSERT INTO public.product
VALUES (914, 6509662, 'MacBook Pro 13.3" Laptop - Apple M2 chip - 16GB Memory - 512GB SSD (Latest Model) - Space Gray',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6509/6509662_sd.jpg',
        'The 13-inch MacBook Pro is more capable than ever. Supercharged by the next-generation M2 chip, it’s Apple’s most portable pro laptop, with up to 20 hours of battery life',
        1699, 201);
INSERT INTO public.product
VALUES (915, 6477095,
        'Microsoft - Surface Pro 8 – 13” Touch Screen – Intel Evo platform Core i7 – 16GB Memory – 256GB SSD – Device Only - Graphite',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6477/6477095cv15d.jpg',
        'Unlock more possibilities than ever with the Pro designed for a Pro like you. The first consumer laptop-to-tablet PC designed on the Intel Evo platform⁹ and designed to light up the best of Windows 11, Surface Pro 8 combines the power of a laptop with the flexibility of a tablet, and every angle in between. Do great things with a larger 13” touchscreen, faster connections with Thunderbolt 4 ports, and extra speed when you need it',
        1299, 201);
INSERT INTO public.product
VALUES (916, 6382912,
        'Google - Pixelbook Go 13.3" Touch-Screen Chromebook - Intel Core m3 - 8GB Memory - 64GB Solid State Drive - Just Black',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6382/6382912_sd.jpg',
        'Pixelbook Go is the Chromebook that goes anywhere, then keeps going. It''s barely 2 pounds* and just 13mm thin. So whether you''re collaborating on a Google Doc in a cafe, catching up on emails during a flight, or watching movies while on vacation, you can do more on the go.*Weight varies by configuration and manufacturing process',
        699, 201);
INSERT INTO public.product
VALUES (917, 6504382,
        'Dell - XPS 15 15.6" 3.5K OLED Touch-Screen Laptop - 12th Gen Intel Core i9 - 32GB Memory - NVIDIA GeForce RTX 3050 Ti - 1TB SSD - Silver',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6504/6504382_sd.jpg',
        'XPS products are designed to be the best, with cutting-edge technologies, exceptional build quality, unique materials and powerful features. XPS brings together the most elegant designs and premium experiences to enhance your work and personal success. This combination ultimately results in beautifully crafted products with no compromises. The new XPS 15 is the perfect balance of power and portability with an unrivaled immersive visual and sound experience. Whether you are streaming, editing photos or creating your next masterpiece, the XPS 15 has the power to move your ideas into reality',
        2599, 201);
INSERT INTO public.product
VALUES (918, 6519918, 'Google - Pixel 7 Pro 256GB (Unlocked) - Obsidian',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6519/6519918_sd.jpg',
        'Introducing Pixel 7 Pro, Google’s best-of-everything phone. Powered by Google Tensor G2, it’s fast and secure, with an immersive display and amazing battery life. The best Pixel camera yet includes a telephoto lens and pro-level features like Macro Focus. And with the certified Titan M2 security chip and a built-in VPN, Pixel helps protect your personal data.',
        999, 204);
INSERT INTO public.product
VALUES (919, 6494426, 'Samsung - Galaxy S22 Ultra 128GB (Unlocked) - Burgundy',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6494/6494426_sd.jpg',
        'The power of our fastest chip ever, long lasting battery, and sophisticated AI enables revolutionary night-time video that’s as clear-as-day. And, for the first time, S Pen with its increased super-powers has been embedded in Galaxy S22 Ultra’s beautifully sleek design. Today, Galaxy S22 Ultra sets an epic standard of smartphone experience',
        1199, 204);
INSERT INTO public.product
VALUES (920, 6487386, 'Apple - iPhone 14 Pro 128GB - Space Black (Verizon)',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6487/6487386_sd.jpg', 'iPhone 14 Pro. Capture incredible detail with a 48MP Main camera. Experience iPhone in a whole new way with Dynamic Island and Always-On display. And get peace of mind with groundbreaking safety features.
', 999, 204);
INSERT INTO public.product
VALUES (921, 6487460, 'Apple - iPhone 14 Pro 128GB - Space Black (T-Mobile)',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6487/6487233_sd.jpg',
        'iPhone 14 Plus. Think big with a larger 6.7-inch display¹ and all-day battery life.² Capture stunning photos in low light and bright light with the new dual-camera system. Get peace of mind with groundbreaking safety features.',
        899, 204);
INSERT INTO public.product
VALUES (923, 6502917, 'Dell - Inspiron 24" Touch screen All-In-One - Intel Core i7 - 16GB Memory - 512GB SSD - White',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6502/6502917_sd.jpg', 'Introducing the latest Inspiron 24 All-in-One Desktop with a TV-inspired design and a display which features ComfortView Plus to help reduce harmful blue light and a flicker free panel optimizing eye comfort. Redesigning the front screen experience with a narrow 4-sided border with touch option for a clean look and feel. Stay up to date with the latest processors up to Intel 12th Gen Processors.
', 1179, 202);
INSERT INTO public.product
VALUES (924, 6200724, 'Apple - 27" iMac Pro with Retina 5K display - Intel Xeon W - 32GB Memory - 1TB SSD - Black',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6200/6200724_sd.jpg',
        'iMac Pro features powerful processors and graphics, along with advanced memory and storage in an all-in-one design—so the most demanding professionals can turn their biggest ideas into their greatest work.',
        4999, 202);
INSERT INTO public.product
VALUES (926, 4263701, 'Apple - 12.9-Inch iPad Pro (Latest Model) with Wi-Fi - 128GB - Space Gray
', 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/4263/4263701_sd.jpg',
        'iPad Pro features the powerful Apple M1 chip for next-level performance and all-day battery life.³ An immersive 12.9-inch Liquid Retina XDR display for viewing and editing HDR photos and videos.¹ And a front camera with Center Stage keeps you in frame automatically during video calls. iPad Pro has pro cameras and a LiDAR Scanner for stunning photos, videos, and immersive AR. Thunderbolt for connecting to high-performance accessories. And you can add Apple Pencil for note-taking, drawing, and marking up documents, and the Magic Keyboard for a responsive typing experience and trackpad',
        1099, 203);
INSERT INTO public.product
VALUES (927, 6464712, 'Samsung - Galaxy Tab S7 FE - 12.4" 128GB - Wi-Fi - with S-Pen - Mystic Black',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6464/6464712cv12d.jpg',
        'Strike a perfect balance between study time and play time with Samsung Galaxy Tab S7 FE, the tablet designed to bring your projects to life.',
        519, 203);
INSERT INTO public.product
VALUES (928, 6412935, 'Amazon - Fire HD 8 10th Generation - 8" - Tablet - 32GB - Black',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6412/6412935_sd.jpg',
        'Work and play on the go with this 8-inch 10th Gen Amazon Fire HD tablet. The 2GB of RAM let you flip through multiple apps smoothly, while the 2MP front-facing camera enables crystal-clear video calls. This Amazon Fire HD tablet features 32GB of internal storage to provide ample space for videos and photos',
        79, 203);
INSERT INTO public.product
VALUES (929, 6477088,
        'Microsoft - Surface Pro 8 – 13” Touch Screen – Intel Evo Platform Core i7 – 32GB Memory – 1TB SSD – Device Only - Platinum',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6477/6477088_sd.jpg',
        'Unlock more possibilities than ever with the Pro designed for a Pro like you. The first consumer laptop-to-tablet PC designed on the Intel Evo platform⁹ and designed to light up the best of Windows 11, Surface Pro 8 combines the power of a laptop with the flexibility of a tablet, and every angle in between. Do great things with a larger 13” touchscreen, faster connections with Thunderbolt 4 ports, and extra speed when you need it',
        2299, 203);
INSERT INTO public.product
VALUES (930, 4901811, 'Apple - 10.2-Inch iPad (Latest Model) with Wi-Fi - 64GB - Silver',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/4901/4901811_sd.jpg',
        'Powerful. Easy to use. Versatile. The new iPad has a beautiful 10.2-inch Retina display, powerful A13 Bionic chip, an Ultra Wide front camera with Center Stage, and works with Apple Pencil and the Smart Keyboard.¹ iPad lets you do more, more easily. All for an incredible value',
        349, 203);
INSERT INTO public.product
VALUES (922, 6477677, 'HP - 27" Touch-Screen All-In-One - AMD Ryzen 7 - 12GB Memory - 1TB SSD - Starry White',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6477/6477677_sd.jpg', 'The HP All-in-One blends the power of a desktop with the beauty of a slim, modern display. Get it all with the latest technology, impressive design, and sustainable materials in one dependable PC. Solid Performance: Getting things done is easy and fast with the power of an AMD processor, Wi-fi technology, and advanced graphics. Save more of what you love with massive storage space. Miss nothing. See everything. Lean back, relax, and bring the cinema to you with a micro-edge Full HD display and dual speakers. Little things make a big difference: Because little things make a big difference, the HP All-in-One Desktop design includes sustainable materials like ocean-bound plastic and post-consumer recycled plastic.
', 969, 202);
INSERT INTO public.product
VALUES (925, 6500517,
        'CyberPowerPC - Gamer Master Gaming Desktop - AMD Ryzen 5 5600X - 16GB Memory - NVIDIA GeForce RTX 3060 - 1TB HDD + 500GB SSD - White',
        'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6500/6500517_rd.jpg', 'Stay at the top of the competition with this CyberPower PC Gamer Master gaming desktop computer. The AMD Ryzen 5 5600X processor and 16GB of RAM let you run high-end titles smoothly for immersive gameplay, while the 500GB SSD offers rapid boot speeds and quick data access. This CyberPowerPC Gamer Master gaming desktop computer has an NVIDIA GeForce RTX 3060 graphics card that renders detailed visuals for enhanced performance.
', 1149, 202);


--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 212
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 4, true);


--
-- TOC entry 3187 (class 2606 OID 16449)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


--
-- TOC entry 3185 (class 2606 OID 16433)
-- Name: cust_address cust_address_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cust_address
    ADD CONSTRAINT cust_address_pk PRIMARY KEY (cust_address_id);


--
-- TOC entry 3179 (class 2606 OID 16422)
-- Name: customer customer_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pk PRIMARY KEY (cust_id);


--
-- TOC entry 3181 (class 2606 OID 16601)
-- Name: customer customer_un1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_un1 UNIQUE (email);


--
-- TOC entry 3183 (class 2606 OID 16613)
-- Name: customer customer_un2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_un2 UNIQUE (email, password);


--
-- TOC entry 3189 (class 2606 OID 16496)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (prd_id);


--
-- TOC entry 3191 (class 2606 OID 16510)
-- Name: product product_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_un UNIQUE (prd_code);


--
-- TOC entry 3194 (class 2606 OID 16450)
-- Name: category category_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.category(category_id);


--
-- TOC entry 3192 (class 2606 OID 16434)
-- Name: customer customer_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_fk FOREIGN KEY (shipping_addr_id) REFERENCES public.cust_address(cust_address_id) ON
UPDATE CASCADE
ON
DELETE CASCADE;


--
-- TOC entry 3193 (class 2606 OID 16439)
-- Name: customer customer_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_fk_1 FOREIGN KEY (billing_addr_id) REFERENCES public.cust_address(cust_address_id) ON
UPDATE CASCADE
ON
DELETE CASCADE;


-- Completed on 2022-10-13 17:18:38

--
-- PostgreSQL database dump complete
--

