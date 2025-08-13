drop table if exists questionsduringinterview;
drop table if exists questionusages;
drop table if exists questions;
drop table if exists competencies;
drop table if exists interviews;
drop table if exists enrollments;
drop table if exists courses;
drop table if exists users;
drop type if exists user_role;
drop sequence if exists user_serverid_seq;

CREATE TABLE Users (user_id int not null, 
student_id varchar(20) unique, 
first_name varchar(50), 
middle_initial char(1), 
last_name varchar(50), 
email varchar(100) unique not null, 
password_hash varchar(255) not null, 
admin_rights int not null, 
primary key (user_id));

CREATE TABLE Courses (course_id int,
course_name varchar(100) not null, 
pre_reqs text,
created_by int not null, 
primary key (course_id), 
foreign key (created_by) references Users(user_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Competencies (competency_id int not null, 
course_id int not null, 
competency_name varchar(100) not null, 
description text, 
semester text, 
primary key (competency_id), 
foreign key (course_id) references Courses(course_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Questions (question_id int not null, 
parent_question_id int, 
created_by int not null, 
last_modified_by int, 
created_at TIMESTAMP WITH TIME ZONE default now(),  
last_modified_at TIMESTAMP WITH TIME ZONE default now(), 
question_text text not null, 
question_image_url varchar(255), 
primary key (question_id), 
foreign key (parent_question_id) references Questions(question_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE QuestionUsages (usage_id int, 
question_id int not null, 
competency_id int not null, 
question_notes text, 
foreign key (question_id) references Questions(question_id) ON DELETE CASCADE ON UPDATE CASCADE, 
foreign key (competency_id) references Competencies(competency_id) ON DELETE CASCADE ON UPDATE CASCADE, 
primary key (usage_id));

CREATE TABLE Interviews (interview_id INT, 
student_id varchar(20) not null, 
course_id int not null, 
conducted_at TIMESTAMP default CURRENT_TIMESTAMP, 
primary key (interview_id), 
foreign key (student_id) references Users(student_id) ON DELETE CASCADE ON UPDATE CASCADE, 
foreign key (course_id) references Courses(course_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE QuestionsDuringInterview (assignment_id INT, 
interview_id INT not null, 
usage_id INT not null, 
assigned_at TIMESTAMP default CURRENT_TIMESTAMP, 
primary key (assignment_id), 
foreign key (interview_id) references Interviews(interview_id) ON DELETE CASCADE ON UPDATE CASCADE, 
foreign key (usage_id) references QuestionUsages(usage_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TYPE user_role as enum ('student', 'assistant', 'instructor');
CREATE TABLE Enrollments (enrollment_id INT, 
student_id varchar(20) not null, 
course_id int not null, 
primary key (enrollment_id), 
foreign key (student_id) references Users(student_id) ON DELETE CASCADE ON UPDATE CASCADE, 
role user_role not null default 'student',  
foreign key (course_id) references Courses(course_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE SEQUENCE user_serverid_seq
  MINVALUE 100000
  START WITH 100001
  INCREMENT BY 50