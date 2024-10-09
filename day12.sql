create table orders (order_id varchar(10) primary key, customer_id varchar(10)unique, hotel_id varchar(10) unique, partner_id varchar(10)unique, order_date date, order_amount int, foreign key (customer_id) references customer (customer_id));
insert into orders values ('ORD001','CUST001','HOT001','PART001',NULL,NULL);
insert into orders values ('ORD002','CUST002','HOT002','PART002',NULL,NULL);
insert into orders values ('ORD003','CUST003','HOT003','PART003',NULL,NULL);
insert into orders values ('ORD004','CUST004','HOT004','PART004',NULL,NULL);
insert into orders values ('ORD005','CUST005','HOT005','PART005',NULL,NULL);
select * from orders

create table customers (customer_id varchar (10) primary key, customer_name varchar(20), address varchar(20), phone_number bigint, email_id varchar(20),foreign key (customer_id) references orders (customer_id));
 drop table orders;
 drop table customers;

 create table customers (customer_id varchar (10) primary key, customer_name varchar(20), address varchar(20), phone_number bigint, email_id varchar(50));
 insert into customers values ('CUST1001','THOMAS','KOCHI','9856325468','thomas@gmail.com');
 insert into customers values ('CUST1002','CHARLES','ALLEPY','9856325468','charles@gmail.com');
 insert into customers values ('CUST1003','SUDHAKAR','KOCHI','9856325468','sudhakars@gmail.com');
 insert into customers values ('CUST1004','JAGADISH','ERNAKULAM','9856325468','jagadishs@rediffmail.com');
 insert into customers values ('CUST1005','ALBERT','ALLEPY','9856325468','albert@outlook.com');
 insert into customers values ('CUST1006','ASHWIN','KANNUR','9856325468','ashwin@yahoo.com');
 select*from customers

 create table delivery_partners (partner_id varchar (10) primary key, partner_name varchar(20), phone_number bigint, rating int);
 insert into delivery_partners values('PART001','AADITYA','8080808080',4);
 insert into delivery_partners values('PART002','CHINMAY','8090808080',3);
 insert into delivery_partners values('PART003','ADITYA','8080908080',2);
 insert into delivery_partners values('PART004','RAGHAV','8080809080',5);
 insert into delivery_partners values('PART005','RAHIL','8080808090',4);
 select*from delivery_partners

 create table hotel_details (hotel_id varchar(10)primary key, hotel_name varchar(20),hotel_type varchar(20),rating int);
 insert into hotel_details values('HOT001','UDIPI','VEG','4');
 insert into hotel_details values('HOT002','IDC','VEG','3');
 insert into hotel_details values('HOT003','KABA MAGIC','NON-VEG','4');
 insert into hotel_details values('HOT004','HOC','NON-VEG','5');
 insert into hotel_details values('HOT005','AROGYA','VEG','3');
 select*from hotel_details

 create table orders (order_id varchar(10)primary key,customer_id varchar(10),hotel_id varchar(10), partner_id varchar(10),order_date date, order_amount int, foreign key(customer_id)references customers(customer_id), foreign key(hotel_id)references hotel_details(hotel_id), foreign key(partner_id)references delivery_partners(partner_id));
 select*from orders

 select partner_id, partner_name, phone_number from delivery_partners where rating between 3 and 5 order by partner_id;

 update customers set phone_number=9876543210 where customer_id='CUST1004';
 select*from customers

delete from customers;
select*from customers;
update customers set email_id='50';
select*from customers;

select customer_id, customer_name, address, phone_number from customers where email_id like '%@gmail.com' order by customer_id;

alter table customers alter column customer_id type int using customer_id::integer;

alter table hotel_details rename column rating to hotel_rating;

select hotel_name ||' is '|| hotel_type as hotel_info from hotel_details;

insert into orders values ('ORD001','CUST1001','HOT001','PART001','2024-01-15','150');
insert into orders values ('ORD002','CUST1002','HOT002','PART002','2024-02-20','200');
insert into orders values ('ORD003','CUST1003','HOT003','PART003','2024-03-10','350');
insert into orders values ('ORD004','CUST1004','HOT004','PART004','2024-04-12','300');
insert into orders values ('ORD005','CUST1005','HOT005','PART005','2024-05-26','550');
select*from orders;
select*from customers;

select hd.hotel_id, hd.hotel_name, count(o.order_id)as"Number of orders" from hotel_details hd join orders o on hd.hotel_id=o.hotel_id group by hd.hotel_id, hd.hotel_name having count(o.order_id)>5 order by hd.hotel_id asc;

select hd.hotel_id, hd.hotel_name, hd.hotel_type from hotel_details hd left join orders o on hd.hotel_id=o.hotel_id and extract(month from o.order_date)=5 where o.order_id is null order by hd.hotel_id asc;

select o.order_id,c.customer_name,h.hotel_name,o.order_amount from orders o join customers c on o.customer_id=c.customer_id join hotel_details h on o.hotel_id=h.hotel_id order by o.order_id asc;

