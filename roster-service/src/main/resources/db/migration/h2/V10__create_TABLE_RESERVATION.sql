CREATE TABLE TABLE_RESERVATION (
  TABLE_RESERVATION_ID integer PRIMARY KEY,
  RESTAURANT_ID integer NOT NULL,
  TABLE_ID integer NOT NULL,
  USER_ID BIGINT NOT NULL,
  STATUS VARCHAR(1),
  BOOKING_ID VARCHAR(50),
  BOOKING_START TIMESTAMP,
  BOOKING_END TIMESTAMP
  );
 
 