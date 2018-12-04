/******************************************************
* Create the database named healthCare and its tables *
******************************************************/

DROP DATABASE IF EXISTS healthCare;

CREATE DATABASE healthCare;

USE healthCare;

CREATE TABLE user (
  userID INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(50),
  firstName VARCHAR(50),
  lastName VARCHAR(50),
  phone VARCHAR(50),
  role VARCHAR(50),
  pwd VARCHAR(50),
  PRIMARY KEY(UserID) 
);
