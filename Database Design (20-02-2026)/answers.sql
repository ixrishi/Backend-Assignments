



--visitor who booked two attractions at same time

select *
from reservations r1
join reservations r2
  on r1.visitor_id = r2.visitor_id
  and r1.reservation_id <> r2.reservation_id
join time_slots t1
  on r1.slot_id = t1.slot_id
join time_slots t2
  on r2.slot_id = t2.slot_id
where 
    t1.slot_start < t2.slot_end
and t1.slot_end   > t2.slot_start;



 -- fetch the slots reserved more then its capacity
select  slot_id from reservations tu group by slot_id 
having count(*)  >
(
select max_capacity from place  p join time_slots t on t.place_id = p.place_id where t.slot_id =tu.slot_id)
;


--Find passes that were used after their expiry date. 
select e.* from entry e join pass p 
  on e.pass_id = p.pass_id
where e.entry_time > p.end_date;


--most visited attractoins
select t.place_id ,p.place_name, count(*) as 'visit count'  from  entry e join time_slots t on t.slot_id= e.slot_id join place p on p.place_id =t.place_id   where e.validated= 1
group by t.place_id,p.place_name 

-- time slots that are fully booked.

select r.slot_id
from reservations r
join time_slots t 
  on r.slot_id = t.slot_id
group by r.slot_id, t.max_capacity
having count(*) = t.max_capacity;

