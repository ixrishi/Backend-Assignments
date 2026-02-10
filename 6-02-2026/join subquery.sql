
Select * from Customers where Customers.customer_id in (Select customer_id from Orders);

Select * from Customers where Customers.customer_id not in (Select customer_id from Orders);


Select * from Products where product_id not in (Select product_id from order_items);


Select * from Employees where dep_id  not in (select dep_id from Department);


Select * from Orders where total_amount > (Select AVG(total_amount) from Orders);


Select o.customer_id,c.*,o.* from Orders o join Customers c on c.customer_id=o.order_id where total_amount > (Select AVG(total_amount) from Orders);


Select dep_name from Department where dep_id in
(Select e.dep_id from Employees e join Department d on d.dep_id = e.dep_id group by e.dep_id having COUNT(e.dep_id) > 1);


Select o.order_id,o.customer_id,o.total_amount from Customers as c join
	Orders as o on c.customer_id = o.customer_id
	and total_amount = (select MAX(total_amount) from Orders where customer_id = c.customer_id);

alter table orders add status varchar(50)
update orders 
set status ='completed' where order_id in (2,5)

update orders 
set status ='cancelled' where order_id in (1,3)

Select * from Orders;

Select * from Customers where Customers.customer_id not in (Select o.customer_id from Customers c join Orders o on o.customer_id=c.customer_id where o.status = 'cancelled');

select * from Customers c where exists (select 1   from Orders o where o.customer_id =c.customer_id )

select * from Customers c where not exists (select 1   from Orders o where o.customer_id =c.customer_id )



Select * from Customers c join (Select customer_id,SUM(total_amount) as total_amount from Orders  group by customer_id) o on c.customer_id = o.customer_id;

Select c.customer_id,c.name,o.total_amount from Customers c join (Select customer_id,SUM(total_amount) as total_amount from Orders  group by customer_id) o on c.customer_id = o.customer_id;


