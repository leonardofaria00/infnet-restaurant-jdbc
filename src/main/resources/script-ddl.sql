create
    database infnetRestaurantJDBC;

use
    infnetRestaurantJDBC;

create table user
(
    id   int not null primary key auto_increment,
    name varchar(80),
    age  integer
);