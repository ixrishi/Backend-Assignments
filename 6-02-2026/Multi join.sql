select * from Customers c join Orders o on o.customer_id = c.customer_id join Order_Items oi on oi.order_id=o.order_id;


select * from Orders o join Order_Items oi
	on oi.order_id = o.order_id
	join Products p 
	on  oi.product_id =p.product_id 
	join Suppliers s
	on s.supplier_id = p.supplier_id;

select * from Employees e join  Department d on d.dep_id = e.dep_id;

select * from Orders o join Order_Items oi
	on oi.order_id = o.order_id
	join Products p 
	on  oi.product_id =p.product_id 
	join Suppliers s
	on s.supplier_id = p.supplier_id;

select p.product_name,o.order_id,s.supplier_name from Orders o join Order_Items oi
	on oi.order_id = o.order_id
	join Products p 
	on  oi.product_id =p.product_id 
	join Suppliers s
	on s.supplier_id = p.supplier_id;




