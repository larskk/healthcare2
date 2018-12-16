/******************************************************
* Create the database named healthCare and its tables *
******************************************************/
DROP DATABASE IF EXISTS healthCare;
CREATE DATABASE healthCare;
USE healthCare;

CREATE TABLE user (
  userID INT AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL UNIQUE,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  phone VARCHAR(50) NOT NULL UNIQUE,
  roleID INT NOT NULL,
  pwd VARCHAR(50) NOT NULL,
  PRIMARY KEY(UserID));

CREATE TABLE treatment (
  treatmentID INT AUTO_INCREMENT,
  treatmentName VARCHAR(50),
  PRIMARY KEY(treatmentID));

CREATE TABLE role (
  roleID INT AUTO_INCREMENT,
  roleName VARCHAR(50),
  PRIMARY KEY(roleID));

CREATE TABLE appointment (
  aptime DATETIME,
  userID INT,
  treatmentID INT(50) NOT NULL,
  PRIMARY KEY(aptime, userID),
  FOREIGN KEY(userID) REFERENCES user(userID),
  FOREIGN KEY(treatmentID) REFERENCES treatment(treatmentID));

INSERT INTO user (email, firstName, lastName, phone, roleID, pwd)
VALUES
("larskk@gmail.com", "Lars Kramer", "Kristensen", "26706010", 1, "1234"),
("jp@post.dk", "John", "Pedersen", "47508912", 2, "5879"),
("uj@post.dk", "Ulla", "Jensen", "50887010", 3, "1599");

INSERT INTO role (roleName)
VALUES
("Bruger"),
("Behandler"),
("Administrator");
 
INSERT INTO treatment (treatmentName)
VALUES
("Fysioterapi"),
("Massage"),
("Kiropraktik"),
("Akupunktur");

INSERT INTO appointment (aptime, userID, TreatmentID)
VALUES
('2018-12-24 12:00:00', 1, 1),
('2018-12-24 13:00:00', 2, 3)
