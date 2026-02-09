select * from Customers c full outer join orders o on c.customer_id = o.customer_id;

select * from Employees e full outer join Department d on e.dep_id = d.dep_id;

select * from Employees e left join Department d on e.dep_id = d.dep_id
 union
 select * from Employees e right join Department d on e.dep_id = d.dep_id;

