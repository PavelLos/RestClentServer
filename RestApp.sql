drop database student_base;

create database  IF NOT EXISTS student_base ;
use student_base;

create table IF NOT EXISTS Sex(
  sexId INT(10) not null auto_increment,
  nameOfSex VARCHAR(30) not null,
  primary key(sexId));

create table IF NOT EXISTS Form(
  formId INT(10) not null auto_increment,
  nameOfForm VARCHAR(30) not null,
  primary key(formId));

create table IF NOT EXISTS GroupNumber(
  groupId INT(10) not null auto_increment,
  nameofGroup VARCHAR(30) not null,
  primary key(groupId));

INSERT INTO Sex (nameOfSex) VALUES('мужской');
INSERT INTO Sex (nameOfsex) VALUES('женский');

INSERT INTO Form (nameOfForm) VALUES('платная');
INSERT INTO Form (nameOfForm) VALUES('бесплатная');

INSERT INTO GroupNumber (nameofGroup) VALUES('первая');
INSERT INTO GroupNumber (nameofGroup) VALUES('вторая');
INSERT INTO GroupNumber (nameofGroup) VALUES('третья');

create table IF NOT EXISTS Student(
  id INT(10) not null auto_increment,
  nameOfSudent VARCHAR(30) not null,
  surName VARCHAR(30) not null,
  secondName VARCHAR(30) not null,
  sex INT(10) not null,
  formOfTrainingenum INT(10) not null,
  groupNumber INT(10) not null,
  FOREIGN KEY (sex) REFERENCES Sex(sexId),
  FOREIGN KEY (formOfTrainingenum) REFERENCES Form(formId),
  FOREIGN KEY (groupNumber) REFERENCES GroupNumber(groupId),
  primary key(id));