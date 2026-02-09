
select * from Customers as c
join Orders as o on 
c.customer_id = o.customer_id 
join Order_items as ot on 
o.order_id = ot.order_id 
cross join products as p

select * from students cross join Department;