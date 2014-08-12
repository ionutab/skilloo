alter table candidate modify telephone_number varchar(255) NULL;
alter table address modify post_code_id bigint(20) NULL;

-- 29/06/2014

alter table candidate_note DROP FOREIGN KEY FK535CCD2E227CB0F;
alter table candidate_note drop note_type_id;
alter table note drop foreign key FK33AFF267D2865C;
alter table note drop type_id;

alter table candidate ADD date_created datetime;
alter table candidate ADD last_updated datetime;

update candidate set date_created = now();
update candidate set last_updated = now();
update client set date_created = now();
update client set last_updated = now();

-- 13/07/2014


# alter table tablename change oldname newname varchar (10) ;
alter table payroll change unqiue_tax_reference_number unique_tax_reference_number varchar2(255);

delete from payroll_company;
insert into payroll_company(name) values('FOSRE');

-- candidate payment section details
update payroll_company set name = 'FOSRE PAYE' where name='FOSRE';

insert into payroll_company(name) values('FOSRE PAYE');
insert into payroll_company(name) values('FOSRE CIS');
insert into payroll_company(name) values('FOSRE EPSC');
insert into payroll_company(name) values('FOSRE EDM');
insert into payroll_company(name) values('OTHER');


