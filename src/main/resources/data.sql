insert into Customers (id,name,email) values(10000,'Yoram Nagawker','yoramnag@gmail.com');
insert into Customers (id,name,email) values(10001,'Gabi Nagawker','gabi@gmail.com');
insert into Customers (id,name,email) values(10002,'Miri S','Miri@gmail.com');

insert into Policies (id,customer_id,policy_number,premium,status) values(20000,10000,30000,1000.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20001,10000,30001,2000.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20002,10001,30002,8000.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20003,10002,30003,5000.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20004,10002,30004,500.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20005,10002,30005,500.0,'ACTIVE');
insert into Policies (id,customer_id,policy_number,premium,status) values(20006,10000,30006,2000.0,'CANCELLED');
insert into Policies (id,customer_id,policy_number,premium,status) values(20007,10000,30007,3000.0,'CANCELLED');
insert into Policies (id,customer_id,policy_number,premium,status) values(20008,10000,30008,30000.0,'EXPIRED');