CREATE TABLE IF NOT EXISTS student (
    id identity,
    jmbag varchar(10) not null unique,
    name varchar(50) not null,
    surname varchar(50) not null,
    birth_date date not null,
    ects number not null
);
create table if not exists course (
    id identity,
    name varchar(100) not null,
    ects number not null
    );

create table if not exists student_course (
    id identity,
    student_id bigint,
    course_id bigint,
    constraint fk_student foreign key (student_id) references student(id),
    constraint fk_course foreign key (course_id) references course(id)
    );

create table if not exists user(
    id identity,
    username varchar(60) not null unique,
    password varchar(60) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);
create table if not exists authority(
    id identity,
    name varchar(50) not null unique
);

create table if not exists user_authority(
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key(user_id) references user(id),
    constraint fk_authority foreign key(authority_id) references authority(id),
)