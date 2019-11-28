create database battle;

use battle;

create table players (
	id int primary key auto_increment,
    name varchar(56) not null,
    max_hp int not null check (max_hp > 0)
);

insert into players values
	(null, 'Vasyan', 40),
	(null, 'Igoryan', 40),
	(null, 'Moisyan', 40),
	(null, 'Lilia', 40);

create table weapons (
	id int primary key auto_increment,
    title varchar(56) not null,
    min_dmg int not null check (min_dmg >= 0),
    max_dmg int not null check (max_dmg >= min_dmg),
    cooldown int not null default 1000 check (cooldown > 10)
);

insert into weapons values 
	(null, 'Longsword', 4, 8, 1500),
	(null, 'Dagger', 1, 5, 700),
	(null, 'Heavy Hammer', 7, 7, 2300),
	(null, 'Doublehanded Sword', 6, 12, 1800),
	(null, 'Fists', 1, 1, 200);