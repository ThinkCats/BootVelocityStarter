  insert into users select * from (
select 0, 'admin' union
select 1, 'SEO' union
select 2, 'sales director' union
select 3, 'manager' union
select 4, 'REP'
) tmp where not exists(select * from users);