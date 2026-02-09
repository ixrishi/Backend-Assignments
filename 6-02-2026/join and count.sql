select c.customer_id,c.name, count(o.order_id) as "Order count" from Customers c join Orders o on o.customer_id = c.customer_id
group by c.customer_id, c.name;

select d.dep_id ,d.dep_name , count(e.emp_id) as "Employee Count" from Department d  join Employees e on e.dep_id =d.dep_id
group by d.dep_id, d.dep_name
order by d.dep_id;


