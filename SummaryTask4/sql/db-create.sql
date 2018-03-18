--==============================================================
-- AutoBase DB creation script for MySQL
--==============================================================

-- these commands remove all tables from the database
-- it implies an error if tables not exist in DB, just ignore it

DROP TABLE IF EXISTS trips_users;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS trucks;

--==============================================================
-- DB creation roles
--==============================================================
CREATE TABLE roles (
  id   INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  role VARCHAR(10)
);

INSERT INTO roles (role) VALUES ('admin');
INSERT INTO roles (role) VALUES ('driver');
INSERT INTO roles (role) VALUES ('dispatcher');

--==============================================================
-- DB creation status
--==============================================================
CREATE TABLE status (
  id     INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  status VARCHAR(11)
);

INSERT INTO status (status) VALUES ('open');
INSERT INTO status (status) VALUES ('in progress');
INSERT INTO status (status) VALUES ('closed');
INSERT INTO status (status) VALUES ('canceled');

--==============================================================
-- DB creation trucks
--==============================================================
CREATE TABLE trucks (
  id                     INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  truck_name             VARCHAR(25)        NOT NULL,
  truck_carrying         DECIMAL,
  truck_capacity         DECIMAL,
  truck_length           DECIMAL,
  truck_lorry_with_sides BOOLEAN DEFAULT FALSE,
  truck_refrigerator     BOOLEAN DEFAULT FALSE,
  truck_serviceable      BOOLEAN DEFAULT TRUE,
  truck_photo_link       VARCHAR(25),
  truck_count_trips    INT
);

INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_serviceable, truck_count_trips)
VALUES ('Gazel', 1.5, 8, 3, false, 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_lorry_with_sides, truck_photo_link, truck_count_trips)
VALUES ('Nissan', 1, 4, 2.5, true, 'truck01.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_photo_link, truck_count_trips)
VALUES ('MAN', 20, 79, 13.6, 'truck02.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_lorry_with_sides, truck_photo_link, truck_count_trips)
VALUES ('Mercedes', 18, 36, 9.2, true, 'truck03.jpg', 4);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_lorry_with_sides, truck_photo_link, truck_count_trips)
VALUES ('Toyota ToyoAce', 2, 7.5, 2.8, true, 'truck04.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_photo_link, truck_count_trips)
VALUES ('Peugeot', 3, 18, 2.9, 'truck05.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_refrigerator, truck_photo_link, truck_count_trips)
VALUES ('GMC', 8, 39.7, 7.3, true, 'truck06.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_lorry_with_sides, truck_photo_link, truck_count_trips)
VALUES ('ISUZU', 12, 34.2, 9.3, true, 'truck07.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_refrigerator, truck_photo_link, truck_count_trips)
VALUES ('Mercedes', 12, 63.9, 6.3, true, 'truck08.jpg', 0);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_refrigerator, truck_photo_link, truck_count_trips)
VALUES ('TATA', 25.2, 41, 3.2, true, 'truck09.jpg', 1);
INSERT INTO trucks (truck_name, truck_carrying, truck_capacity, truck_length, truck_lorry_with_sides, truck_photo_link, truck_count_trips)
VALUES ('МАЗ', 2.5, 6, 2.2, true, 'truck10.jpg', 0);

--==============================================================
-- DB creation users
--==============================================================
CREATE TABLE users (
  id              INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  user_login      VARCHAR(10)        NOT NULL UNIQUE,
  user_password   VARCHAR(10)        NOT NULL,
  user_first_name VARCHAR(20)        NOT NULL,
  user_last_name  VARCHAR(20)        NOT NULL,
  user_photo_link VARCHAR(25),
  user_mail       VARCHAR(35),
  user_role_id    INT                NOT NULL REFERENCES roles (id)
  ON DELETE CASCADE
);

INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_role_id)
VALUES ('admin', 'admin', 'Admin', 'Adminoff', 'user1.jpg', 1);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_mail, user_role_id)
VALUES ('driver', 'driver', 'Driver', 'Driveroff', 'user2.jpg', 'limpoposice@gmail.com', 2);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_role_id)
VALUES ('dispatcher', 'dispatcher', 'Алина', 'Богатая', 'user3.jpg', 3);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_mail, user_role_id)
VALUES ('Иван', 'Иван', 'Иван', 'Иванов', 'user4.jpg', 'serikoff.eugene@gmail.com', 2);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_mail, user_role_id)
VALUES ('Petr', 'Petr', 'Пётр', 'Петров', 'user5.jpg', 'serikoff.np@gmail.com', 2);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_mail, user_role_id)
VALUES ('Alex', 'Alex', 'Алексей', 'Алексеев', 'user4.jpg', 'serikoff_genua12@mail.ru', 2);
INSERT INTO users (user_login, user_password, user_first_name, user_last_name, user_photo_link, user_role_id)
VALUES ('Андрей', 'Андрей', 'Андрей', 'Андреев', 'user6.jpg', 3);

--==============================================================
-- DB creation trip
--==============================================================
CREATE TABLE trips (
  id                         INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  trip_number                INT                NOT NULL,
  trip_date_creation         DATE,
  trip_date_departure        DATE               NOT NULL,
  trip_destination           VARCHAR(35)        NOT NULL,
  trip_distance              DECIMAL,
  trip_status_id             INT REFERENCES status (id),
  trip_truck_id              INT REFERENCES trucks (id),
  trip_driver_id             INT REFERENCES users (id),
  trip_dispatcher_id_create  INT REFERENCES users (id),
  trip_dispatcher_id_approve INT REFERENCES users (id)
);

INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_dispatcher_id_create)
VALUES ('1', '2018-01-01', '2018-02-01', 'Полтава', 150, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_truck_id, trip_driver_id, trip_dispatcher_id_create,
                     trip_dispatcher_id_approve)
VALUES ('2', '2018-01-21', '2018-02-10', 'Киев', 500, 2, 2, 2, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_truck_id, trip_driver_id, trip_dispatcher_id_create,
                     trip_dispatcher_id_approve)
VALUES ('3', '2018-01-24', '2018-02-21', 'Львов', 900, 3, 3, 5, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_truck_id, trip_driver_id, trip_dispatcher_id_create,
                     trip_dispatcher_id_approve)
VALUES ('4', '2018-01-09', '2018-01-23', 'Одесса', 800, 4, 4, 4, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_dispatcher_id_create)
VALUES ('5', '2018-01-08', '2018-02-05', 'Черкасы', 250, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_dispatcher_id_create)
VALUES ('6', '2018-01-27', '2016-02-03', 'Днепр', 200, 1, 1);
INSERT INTO trips (trip_number, trip_date_creation, trip_date_departure, trip_destination, trip_distance,
                     trip_status_id, trip_dispatcher_id_create)
VALUES ('7', '2018-01-28', '2018-03-05', 'Сумы', 200, 1, 1);
--==============================================================
-- DB creation request
--==============================================================
CREATE TABLE requests (
  id                     INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  request_trip_id        INT                NOT NULL REFERENCES trips (id),
  request_carrying         DECIMAL,
  request_capacity         DECIMAL,
  request_length           DECIMAL,
  request_lorry_with_sides BOOLEAN DEFAULT FALSE,
  request_refrigerator     BOOLEAN DEFAULT FALSE,
  request_driver_id        INT REFERENCES users (id)
);

INSERT INTO requests (request_trip_id, request_carrying, request_capacity, request_length, request_driver_id)
VALUES (1, 11, 21, 11, 4);
INSERT INTO requests (request_trip_id, request_carrying, request_capacity, request_length, request_driver_id,
                      request_lorry_with_sides)
VALUES (5, 1.9, 5, 2.1, 2, true);
INSERT INTO requests (request_trip_id, request_carrying, request_capacity, request_length, request_driver_id,
                      request_refrigerator)
VALUES (1, 1.7, 2.5, 3.1, 5, true);
INSERT INTO requests (request_trip_id, request_carrying, request_capacity, request_length, request_driver_id,
                      request_lorry_with_sides)
VALUES (5, 11.1, 25, 9, 5, true);

--==============================================================
-- DB creation trips_users
--==============================================================
CREATE TABLE trips_users (
  id                      INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  trips_users_trip_id INT REFERENCES trips (id),
  trips_users_driver_id INT REFERENCES users (id)
);

INSERT INTO trips_users (trips_users_trip_id, trips_users_driver_id) VALUES (1, 4);
INSERT INTO trips_users (trips_users_trip_id, trips_users_driver_id) VALUES (5, 2);
INSERT INTO trips_users (trips_users_trip_id, trips_users_driver_id) VALUES (1, 5);
INSERT INTO trips_users (trips_users_trip_id, trips_users_driver_id) VALUES (5, 5);