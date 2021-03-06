CREATE TABLE RESTAURANTS (
  RESTAURANT_ID integer GENERATED BY DEFAULT AS IDENTITY,
  RESTAURANT_NAME VARCHAR(255),
  STATUS VARCHAR(1) ,
  PRIMARY KEY (RESTAURANT_ID)
);

CREATE TABLE MENU (
  MENU_ID integer PRIMARY KEY,
  ITEM_NAME VARCHAR(255),
  ITEM_DESC VARCHAR(255),
  PRICE integer,
  STATUS VARCHAR(1)
  );


CREATE TABLE TABLES (
  TABLE_ID integer GENERATED BY DEFAULT AS IDENTITY,
  TABLE_TYPE VARCHAR(255),
  TABLE_DESC VARCHAR(255),
  RESTAURANT_ID integer NOT NULL,
  CAPACITY INTEGER,
  STATUS VARCHAR(1),
  BOOKING_START TIMESTAMP,
  BOOKING_END TIMESTAMP,
   PRIMARY KEY (TABLE_ID)
  );

ALTER TABLE TABLES ADD CONSTRAINT RESTAURANTS_TABLES_ID
   FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANTS;
 