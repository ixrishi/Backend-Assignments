create database college_db

use college_db

CREATE TABLE students (
  student_id BIGINT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(255) UNIQUE,
  age INT,
  join_date DATE,
  active_flag BIT DEFAULT 1
);

CREATE TABLE courses(
course_id INT  Primary Key, 
course_name VARCHAR(255),
fees DECIMAL, 
)

CREATE TABLE ENROLLMENTS (
enroll_id BIGINT Primary Key,
student_id BIGINT ,
course_id INT,
enroll_timestamp DATETIME2
)






