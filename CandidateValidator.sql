CREATE DATABASE CandidateManagement
go

use CandidateManagement
go

create table Candidate (
	keyValue int primary key,
	[name] nvarchar(Max),
	birthdate varchar(10),
	address nvarchar(Max),
	hometown nvarchar(Max),
	phone varchar(11),
	email varchar(50)
)
go

create table Experience_Candidate (
	keyValue int primary key,
	yoe float,
	specialistSkills nvarchar(Max),
	mostRecentCompany nvarchar(Max)
)
go

create table Fresher_Candidate (
	keyValue int primary key,
	graduationDate varchar(10),
	graduationRank nvarchar(20),
	graduatedForm nvarchar(Max)
)
go

create table Intern_Candidate (
	keyValue int primary key,
	majoStudying nvarchar(30),
	currentSemester int,
	schoolName nvarchar(50),
	expectedGraduationDate varchar(10)
)
go

alter table Experience_Candidate add foreign key (keyValue) references Candidate(keyValue)
on update cascade on delete cascade
alter table Fresher_Candidate add foreign key (keyValue) references Candidate(keyValue)
on update cascade on delete cascade
alter table Intern_Candidate add foreign key (keyValue) references Candidate(keyValue)
on update cascade on delete cascade

create proc usp_AddExperienceCandidate @keyValue int, @name nvarchar(MAX), @birthdate varchar(10), @address nvarchar(MAX), @hometown nvarchar(MAX), @phone varchar(11), @email varchar(50), @yoe float, @specialistSkills nvarchar(MAX), @mostRecentCompany nvarchar(MAX), @outputValue bit output
as
begin
	set @outputValue = 1
	begin transaction
	begin try
		insert candidate
		values (@keyValue, @name, @birthdate, @address, @hometown, @phone, @email)

		insert Experience_Candidate
		values (@keyValue, @yoe, @specialistSkills, @mostRecentCompany)

		commit
	end try
	begin catch
		rollback
		set @outputValue = 0
	end catch
end

create proc usp_AddFresherCandidate @keyValue int, @name nvarchar(MAX), @birthdate varchar(10), @address nvarchar(MAX), @hometown nvarchar(MAX), @phone varchar(11), @email varchar(50), @graduationDate varchar(10), @graduationRank nvarchar(20), @graduatedFrom nvarchar(MAX), @outputValue bit output
as
begin
	set @outputValue = 1
	begin transaction
	begin try
		insert candidate
		values (@keyValue, @name, @birthdate, @address, @hometown, @phone, @email)

		insert Fresher_Candidate
		values (@keyValue, @graduationDate, @graduationRank, @graduatedFrom)

		commit
	end try
	begin catch
		rollback
		set @outputvalue = 0
	end catch
end

create proc usp_AddInternCandidate @keyValue int, @name nvarchar(MAX), @birthdate varchar(10), @address nvarchar(MAX), @hometown nvarchar(MAX), @phone varchar(11), @email varchar(50), @majorStudying nvarchar(30), @currentSemester int, @schoolName nvarchar(30), @expectedGraduationDate varchar(10), @outputValue bit output
as
begin
	set @outputValue = 1
	begin transaction
	begin try
		insert Candidate
		values (@keyValue, @name, @birthdate, @address, @hometown, @phone, @email)

		insert Intern_Candidate
		values (@keyValue, @majorStudying, @currentSemester, @schoolName, @expectedGraduationDate)

		commit
	end try
	begin catch
		rollback
		set @outputValue = 0
	end catch
end