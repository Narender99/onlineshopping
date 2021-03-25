create table customer_details
    (
     customer_id int not null primary key,
     first_name varchar2(20) not null,
     last_name varchar2(20) not null,
     mobile_number number(10) not null,
     address varchar2(20) not null,
     email varchar2(20) not null
   );






 create table user_details
    (
     user_id int not null primary key,
     password varchar2(20) not null,
     role varchar2(20) not null,
     customer_id int not null,
     constraint fk_user_details foreign key(customer_id) references customer_details(customer_id)
    );





 create table address_details
    (
     address_id int not null primary key,
     street_no varchar2(20) not null,
     building_name varchar2(20) not null,
     city varchar2(20) not null,
     state varchar2(20) not null,
     country varchar2(20) not null,
     pincode varchar2(10) not null,
     customer_id int not null,
     constraint fk_address_details foreign key(customer_id) references customer_details(customer_id)
    );





 create table category_details
    (
     cat_id int not null primary key,
     category_name varchar2(20) not null
    );






create table product_details
   (
     product_id int not null primary key,
     product_name varchar2(20) not null,
     price decimal(10,2) not null,
     color varchar2(20) not null,
     dimension varchar2(20) not null,
     specification varchar2(20) not null,
     manufacturer varchar2(20) not null,
     quantity int not null,
     cat_id int not null,
     constraint fk_product_details foreign key(cat_id) references category_details(cat_id),
cart_id int not null,
     constraint fk_product_details foreign key(cart_id) references cart_details(cart_id)

    );








create table cart_details
    (
     cart_id int not null primary key,
     customer_id int not null,
     constraint fk_cart_details foreign key(customer_id) references customer_details(customer_id),
    
    );





create table order_details
    (
      order_id int not null primary key,
      order_date date not null,
      order_status varchar2(20) not null,
      customer_id int not null,
     
      address_id int not null,
      constraint fk_order_details1 foreign key(customer_id) references customer_details(customer_id),
     
      constraint fk_order_details2 foreign key(address_id) references address_details(address_id)
     );
     
     
     
create table product_order
    (
    product_id int not null,
    order_id int not null,
    constraint fk_product_order foreign key(product_id) references product_details(product_id),
    constraint fk_product_order1 foreign key(order_id) references order_details(order_id),
    constraint pk_product_order2 primary key(product_id,order_id)
    );
    
    
    
 create sequence customer_seq
   start with 1000
   increment by 1
   minvalue 1000
   maxvalue 2000
   cycle;


create sequence user_seq
    start with 2001
    increment by 1
    minvalue 2001
    maxvalue 3000
    cycle;

create sequence address_seq
    start with 3001
    increment by 1
    minvalue 3001
    maxvalue 4000
    cycle;

create sequence category_seq
    start with 4001
    increment by 1
    minvalue 4001
    maxvalue 5000
    cycle;

 create sequence product_seq
    start with 5001
    increment by 1
    minvalue 5001
    maxvalue 6000
    cycle;

create sequence cart_seq
    start with 6001
    increment by 1
    minvalue 6001
    maxvalue 7000
    cycle;

create sequence order_seq
    start with 7001
    increment by 1
    minvalue 7001
    maxvalue 8000
    cycle;