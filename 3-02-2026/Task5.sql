
select COUNT(student_id) as count from students;

select COUNT(student_id) as count from students
WHERE active_flag=1;

select sum(fees) as Total_course_fees ,max(fees) as MAXFEE, AVG(fees) as AVGFEE from courses;

select min(age) from students;

select max(fees) from courses;

select TOP 1 * from students
order by registration_date DESC;

select TOP 1 * from students
order by registration_date ASC;

select active_flag, count(student_id) from students
group by active_flag;

select age, count(student_id) from students
group by age;

select course_name , sum(fees) from courses
group by course_name;

select course_id from ENROLLMENTS
group by course_id
Having COUNT(student_id) >2;


select age from students
group by age 
Having avg(age)>21;

select course_id from ENROLLMENTS
group by course_id
having count(enroll_id)>2;