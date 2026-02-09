select * from customers c right join orders o on o.customer_id = c.customer_id;

select * from customers c right join orders o on o.customer_id = c.customer_id where o.order_id is null;

select * from employees e  right join  department d on d.dep_id = e.dep_id;

select * from customers c right join orders o on o.customer_id = c.customer_id where c.name like 'ven%';


select d.dep_id, count(*) as EmpCount from employees e  right join  department d on d.dep_id = e.dep_id
group by d.dep_id;

