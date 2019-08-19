insert into MODULE (module_id,module_name) values
(1,'PromoCard'),
(2,'CategoryCard'),
(3,'FlashSaleCard'),
(4,'HistoryCard'),
(5,'NewsCard');


insert into PROMOTION_GROUP (pg_id) values 
(1),
(2),
(3);

insert into MODULE_RELATION (pg_id,module_id,sequence) values 
--UserA : Promo, Category, FlashSale, History and News
(1,1,1),(1,2,2),(1,3,3),(1,4,4),(1,5,5),
--UserB : Promo, News, FlashSale, Category and News
(2,1,1),(2,5,2),(2,3,3),(2,2,4),(2,5,5),
--UserC : Promo, FlashSale, Category, News and History
(3,1,1),(3,3,2),(3,2,3),(3,5,4),(3,4,5);

insert into USER (user_id,pg_id) values 
(1,1),
(2,2),
(3,3);