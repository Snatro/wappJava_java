delete from student;
delete from course;
delete from student_course;
delete from user;
delete from authority;

insert into student (id, name, surname, jmbag, ects, birth_date)
values (1, 'Ivo', 'Ivić', '0246053232', 120, DATEADD('YEAR', -28, CURRENT_TIMESTAMP));
insert into student (id, name, surname, jmbag, ects, birth_date)
values (2, 'Pero', 'Perić', '0246053435', 120, NOW());
insert into student (id, name, surname, jmbag, ects, birth_date)
values (3, 'Šime', 'Šimić', '0246053444', 120, '2003-04-02');

insert into course (id, name, ects)
values (1, 'Web aplikacije u Javi', 6);
insert into course (id, name, ects)
values (2, 'Programiranje u jeziku Java', 5);

insert into student_course (id, student_id, course_id)
values (1, 1, 1);
insert into student_course (id, student_id, course_id)
values (2, 2, 1);
insert into student_course (id, student_id, course_id)
values (3, 2, 2);

insert into user (id, username, password, first_name, last_name)
values(1,'Snatro','$2a$12$Efp0qgM5z3oPQbWA8PNmvOrnVDadgl81MpzRp9FNInjDsytiyfwqi','Dino','Santro');
insert into user (id, username, password, first_name, last_name)
values(2,'Milli','$2a$12$95TLGjV321R8oNxqZtcanuHziXstptIVyzV4hqEppqLmR8MpVWXCC','Mili','Vanili');
insert into user (id, username, password, first_name, last_name)
values(3,'Nine','$2a$12$icXLw40Q7dHp.KK72FvPIODghBRy2H5C5aeTC7dVR1lY.6/vMHXJa','Siks','Nine');

insert into authority (id, name)
values(1, 'ROLE_ADMIN');
insert into authority (id, name)
values(2, 'ROLE_USER');
insert into authority (id, name)
values(3, 'STUDENT');

insert into user_authority (user_id, authority_id)
values(1,1);
insert into user_authority (user_id, authority_id)
values(2,2);
insert into user_authority (user_id, authority_id)
values(3,3);
