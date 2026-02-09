select c.customer_id,c.name, count(o.order_id) as "Order count" from Customers c join Orders o on o.customer_id = c.customer_id
where o.order_date >'2022 -02-01'
group by c.customer_id, c.name;

select d.dep_id ,d.dep_name ,e.emp_name from Department d  join Employees e on e.dep_id =d.dep_id
where d.dep_id = 2;

select p.product_id ,p.product_name ,p.price ,oi.order_id from Products p  join Order_Items oi  on oi.product_id =p.product_id
where p.price >3000;




