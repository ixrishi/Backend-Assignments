use Assignment2;



select * from  customers c join orders o on o.customer_id = c.customer_id;

select * from Department d join employees e on d.dep_id =e.dep_id;


select * from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id =p.product_id;

select o.order_id, p.product_id ,p.product_name from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id =p.product_id;



select * from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id =p.product_id
where o.total_amount >5000;



select * from orders o join order_items oi on o.order_id = oi.order_id join products p on oi.product_id =p.product_id
where p.product_name like '%us%';

