select c.customer_id,c.name, count(o.order_id) as "Order count" from Customers c join Orders o on o.customer_id = c.customer_id
group by c.customer_id, c.name;

select c.customer_id,c.name, sum(o.total_amount) as "Order Amount" from Customers c join Orders o on o.customer_id = c.customer_id
group by c.customer_id, c.name;

select d.dep_id ,d.dep_name , count(e.emp_id) as "Employee Count" from Department d  join Employees e on e.dep_id =d.dep_id
group by d.dep_id, d.dep_name
order by d.dep_id;

select p.product_id ,p.product_name , count(oi.order_id)  as "Order Count" from Products p  join Order_Items oi  on oi.product_id =p.product_id
group by p.product_id, p.product_name
order by p.product_id;

select d.dep_id ,d.dep_name , sum(e.salary) as "Total Salary" from Department d  join Employees e on e.dep_id =d.dep_id
group by d.dep_id, d.dep_name
order by d.dep_id;




