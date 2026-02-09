
use Assignment2;


CREATE TABLE Customers(
    customer_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number BIGINT NOT NULL
);

CREATE TABLE Orders(
    order_id INT PRIMARY KEY,
    order_number INT NOT NULL UNIQUE,
    customer_id INT NOT NULL,
    order_date DATETIME2 NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY(customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Department(
    dep_id INT PRIMARY KEY,
    dep_name VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE Employees(
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(255) NOT NULL,
    emp_email VARCHAR(255) UNIQUE,
    dep_id INT NOT NULL,
    salary DECIMAL(10,2),
    manager_id INT NULL,
    FOREIGN KEY(dep_id) REFERENCES Department(dep_id),
    FOREIGN KEY(manager_id) REFERENCES Employees(emp_id)
);

CREATE TABLE Suppliers(
    supplier_id INT PRIMARY KEY,
    supplier_name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255) UNIQUE ,
    phone BIGINT,
    country VARCHAR(255)
);


CREATE TABLE Products(
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
	supplier_id INT,
	FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id)
);


CREATE TABLE Order_Items(
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY(order_id, product_id),
    FOREIGN KEY(order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY(product_id) REFERENCES Products(product_id) ON DELETE CASCADE
);

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

CREATE TABLE student_course(
course_id Int,
student_id BIGINT,
FOREIGN KEY(course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
FOREIGN KEY(student_id) REFERENCES students(student_id) ON DELETE CASCADE,
)

INSERT INTO students (student_id, name, email, age, join_date, active_flag) VALUES
(1001,'Rishi','rishi@gmail.com',22,'2024-01-10',1),
(1002,'Kiran','kiran@gmail.com',21,'2024-02-15',1),
(1003,'Ananya','ananya@gmail.com',23,'2023-12-20',1),
(1004,'Rahul','rahul@gmail.com',24,'2023-11-05',1),
(1005,'Sneha','sneha@gmail.com',22,'2024-03-01',1),
(1006,'Arjun','arjun@gmail.com',25,'2023-10-18',1);

INSERT INTO courses (course_id, course_name, fees) VALUES
(1,'Java Full Stack',45000),
(2,'Python Programming',30000),
(3,'Data Structures',25000),
(4,'Web Development',35000),
(5,'SQL & Databases',20000);

INSERT INTO student_course (course_id, student_id) VALUES
(1,1001),
(2,1001),
(3,1002),
(4,1002),
(1,1003),
(5,1003),
(2,1004),
(3,1004),
(4,1005),
(5,1006),
(1,1006);





INSERT INTO Customers VALUES
(1,'Srinivas','dummy1@mail.com',900000001),
(2,'Lakshmi','dummy2@mail.com',900000002),
(3,'Venkatesh','dummy3@mail.com',900000003),
(4,'Anitha','dummy4@mail.com',900000004),
(5,'Ramesh','dummy5@mail.com',900000005),
(6,'Suresh','dummy6@mail.com',900000006),
(7,'Padma','dummy7@mail.com',900000007),
(8,'Kiran','dummy8@mail.com',900000008),
(9,'Swathi','dummy9@mail.com',900000009);

select * from Customers;

INSERT INTO Orders 
(order_id, order_number, customer_id, order_date, total_amount)
VALUES
(1,201,1,SYSDATETIME(),5200),
(2,202,2,SYSDATETIME(),6100),
(3,203,3,SYSDATETIME(),4300),
(4,204,4,SYSDATETIME(),3100),
(5,205,5,SYSDATETIME(),2600),
(6,206,6,SYSDATETIME(),7200)



INSERT INTO Department (dep_id, dep_name) VALUES
(1,'Human Resources'),
(2,'Finance'),
(3,'Engineering'),
(4,'Marketing'),
(5,'Sales');


INSERT INTO Employees (emp_id, emp_name, emp_email, dep_id, salary, manager_id) VALUES
(101,'Arjun','arjun@company.com',3,75000,NULL),    
(102,'Kiran','kiran@company.com',3,56000,101),      
(103,'Meena','meena@company.com',2,69000,NULL),     
(104,'Ravi','ravi@company.com',2,52000,103),        
(105,'Suresh','suresh@company.com',4,61000,NULL),   
(106,'Pradeep','pradeep@company.com',4,45000,105),  
(107,'Ananya','ananya@company.com',1,58000,NULL),   
(108,'Disha','disha@company.com',1,43000,107),     
(109,'Tarun','tarun@company.com',5,67000,NULL),    
(110,'Jai','jai@company.com',5,42000,109);


INSERT INTO Suppliers (supplier_id, supplier_name, contact_email, phone, country) VALUES
(1,'TechSource Ltd','support@techsource.com',9876543210,'India'),
(2,'Global Electronics','info@globalelec.com',9876501234,'USA'),
(3,'CompuWorld','sales@compuworld.com',9998887776,'India'),
(4,'TechGear International','service@techgear.com',9988776655,'Germany'),
(5,'Digital Hub','contact@digitalhub.com',9877001122,'Australia');


INSERT INTO Products (product_id, product_name, price, supplier_id) VALUES
(1,'Laptop',65000,1),
(2,'Mouse',500,1),
(3,'Keyboard',800,3),
(4,'Monitor',7000,2),
(5,'Headphones',1200,4),
(6,'USB Cable',150,3),
(7,'Webcam',2500,5);





INSERT INTO Order_Items (order_id, product_id, quantity) VALUES
(1, 2, 3),
(1, 3, 1),
(2, 1, 1),
(3, 4, 2),
(4, 5, 2),
(5, 3, 1),
(6, 1, 1),
(6, 2, 2),
(2, 6, 3),
(3, 7, 1);



select * from Customers;
select * from Department;
select * from Employees;
select * from Order_Items;
select * from Orders;
select * from Products;
select * from Suppliers;
select * from student_course;
select * from students;
select * from courses;
select * from student_course;
