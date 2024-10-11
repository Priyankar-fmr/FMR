create table worker(worker_id serial primary key, first_name varchar(20), last_name varchar(20), salary int, joining_date date, department varchar(20));
create table titel(worker_ref_id int references worker(worker_id), worker_title varchar(20),affected_from date);
create table bonus(woker_ref_id int references worker(worker_id), bonus_amount int, bonus_date date);

insert into worker values('1','Monika','Arora','100000','2020-02-14','HR');
insert into worker values('2','Niharika','Verma','80000','2011-02-14','Admin');
insert into worker values('3','Vishal','Singhal','300000','2020-02-14','HR');
insert into worker values('4','Amitabh','Singh','500000','2020-02-14','Admin');
insert into worker values('5','Vivek','Bhati','500000','2011-02-14','Admin');
insert into worker values('6','Vipul','Diwan','200000','2011-02-14','Account');
insert into worker values('7','Satish','Kumar','75000','2020-02-14','Account');
insert into worker values('8','Geetika','Chauhan','90000','2011-02-14','Admin');

select*from worker

insert into bonus values('1','5000','2020-02-16');
insert into bonus values('2','3000','2011-06-16');
insert into bonus values('3','4000','2020-02-16');
insert into bonus values('1','4500','2020-02-16');
insert into bonus values('2','3500','2011-02-16');
insert into bonus values('4','4500','2020-02-16');
insert into bonus values('5','3500','2011-02-16');

select*from bonus

alter table titel rename to title;

insert into title values('1','Manager','2016-02-20');
insert into title values('2','Executive','2016-06-11');
insert into title values('8','Executive','2016-06-11');
insert into title values('5','Manager','2016-06-11');
insert into title values('4','Asst. Manager','2016-06-11');
insert into title values('7','Executive','2016-06-11');
insert into title values('6','Lead','2016-06-11');
insert into title values('3','Lead','2016-06-11');

select*from title

select w.first_name, w.salary, t.worker_title from worker w join title t on w.worker_id=t.worker_ref_id;

create or replace function get_worker_count_by_nth_highest_salary(nth_rank int)
returns int as $$
declare 
	nth_salary int;
	worker_count int;
begin
 select distinct salary into nth_salary from worker order by salary desc limit 1 offset nth_rank-1;
 select count(*) into worker_count from worker where salary=nth_salary;
 return worker_count;
end;
$$ Language plpgsql;
select get_worker_count_by_nth_highest_salary(4)
select get_worker_count_by_nth_highest_salary(5)