CREATE DATABASE MYDB;

CREATE TABLE credit_rating(
  id int(11) NOT NULL AUTO_INCREMENT,
  start_amount decimal(15,2) DEFAULT NULL,
  end_amount decimal(15,2) DEFAULT NULL,
  rating int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO credit_rating
    (start_amount,end_amount,rating)
VALUES
    (0,5000,10),
    (5001,10000,9),
    (10001,20000,8),
    (20001,40000,7),
    (40001,80000,6),
    (80001,160000,5),
    (160001,320000,4),
    (320001,640000,3),
    (640001,1280000,2),
    (1280001,999999999999,1);