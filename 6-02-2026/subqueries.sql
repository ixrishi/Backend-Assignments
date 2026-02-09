select * from customers where customer_id in (select customer_id  from Orders);

select * from customers where customer_id not in (select customer_id  from Orders);


select * from Products where product_id not  in (select product_id  from Order_Items );

select * from Department where dep_id not in (select dep_id  from Employees);

 select * from orders where total_amount  >(select avg(total_amount) from Orders);
 

SELECT *
FROM Employees e
WHERE e.salary > (
    SELECT AVG(e2.salary)
    FROM Employees e2
    WHERE e2.dep_id = e.dep_id
	group by e2.dep_id
);

select dep_name from Department where dep_id in (select e.dep_id from Department d join Employees e on e.dep_id = d.dep_id group by e.dep_id
having count(e.emp_id) >1);


select * from orders;
alter table orders add status varchar(50);

update orders set status = 'cancelled'  where order_id in (1,3);

update orders set status = 'completed'  where order_id in (2,4);

select * from customers cu where  cu.customer_id not in (select c.customer_id from Customers c join   Orders o on o.customer_id =c.customer_id where status = 'cancelled')




