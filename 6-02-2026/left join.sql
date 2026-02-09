use Assignment2

select * from customers c left join  orders o on o.customer_id = c.customer_id;

select c.name from customers c left join  orders o on o.customer_id = c.customer_id where o.order_id is null;

select * from department d left join employees e on d.dep_id = e.dep_id;

select * from department d left join employees e on d.dep_id = e.dep_id where e.emp_id is null;

select * from products p left join order_items oi on p.product_id = oi.product_id  left join orders o  on o.order_id = oi.order_id where o.order_id is null;

select * from department d left join employees e on d.dep_id = e.dep_id where e.emp_name like '%a';




