select c.customer_id,c.name ,o.order_id from Customers c join Orders o on o.customer_id = c.customer_id
where c.name like 'L%';

select e.emp_name ,d.dep_id ,d.dep_name  from Department d  join Employees e on e.dep_id =d.dep_id
where e.emp_name like 'A%';

select p.product_id ,p.product_name, oi.order_id from  Products p  join Order_Items oi  on oi.product_id =p.product_id
where p.product_name like 'M%'
order by p.product_id;

