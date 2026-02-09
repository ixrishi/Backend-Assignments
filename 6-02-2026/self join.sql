select e.emp_id, e.emp_name, b.emp_name as "Manager Name" from Employees e join Employees b on e.manager_id =b.emp_id

select e.emp_id, e.emp_name, b.emp_name as "Manager Name" from Employees e join Employees b on e.manager_id =b.emp_id
group by b.emp_name,e.emp_id, e.emp_name;

select b.emp_id as "Manager Id", b.emp_name as "Manager Name" from Employees e join Employees b on e.manager_id =b.emp_id
