select e.emp_name ,d.dep_name ,( e.salary * 12)+5000  as 'Annual salary with bonus' from Employees e join Department d on d.dep_id =e.dep_id ;

select e.emp_name ,d.dep_name ,salary, 
		case 
			when salary>70000 then 'High pay'
			when salary between 50000 and 70000 then 'Medium pay'
			else  'low pay'
		end as 'salary level'
	from Employees e join Department d on d.dep_id =e.dep_id 
	order by salary desc ;
