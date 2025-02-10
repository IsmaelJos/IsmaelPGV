drop table if exists users;
drop table if exists monsters;
drop table if exists character_weapon;
drop table if exists character_armor;
drop table if exists characters;
drop table if exists weapons;
drop table if exists armors;
drop table if exists elements;
drop table if exists rolls;


create table rolls(
    id INTEGER primary key AUTOINCREMENT,
    name TEXT
);

create table users(
    id INTEGER primary key AUTOINCREMENT,
    name TEXT,
    password TEXT,
    roll_id INTEGER,
    FOREIGN KEY (roll_id) REFERENCES rolls(id) ON DELETE SET NULL
);

create table monsters(
    id INTEGER primary key,
    name TEXT,
    description TEXT
);

create table elements(
    id INTEGER primary key,
    name TEXT
);

create table weapons(
    id INTEGER primary key,
    name TEXT,
    power INTEGER,
    element INTEGER,
    FOREIGN KEY (element) REFERENCES elements(id) ON DELETE SET NULL
);

create table armors(
    id INTEGER primary key,
    name TEXT,
    defense INTEGER
);

create table characters(
    id INTEGER primary key,
    name TEXT
);

create table character_weapon(
    character_id INTEGER,
    weapon_id INTEGER,
    foreign key (character_id) references characters(id),
    foreign key (weapon_id) references weapons(id)
);

create table character_armor(
    character_id INTEGER,
    armor_id INTEGER,
    foreign key (character_id) references characters(id),
    foreign key (armor_id) references armors(id)
);

insert into rolls(name) values
    ('Admin'),
    ('User');

insert into users(name,password,roll_id) values
    ('Manuel','$2a$10$xsibtqBItb3gPtgchRGxR./uK486vLo0ZvS56SGyeQBS33Itav4De',1),
    ('Pedro','$2a$10$ME9PLC6favE1i/CRSsWoOex8ixwqQSnzPxnbcPAIX9nHH/TBAIGiO',2);

insert into monsters(id,name,description) values
    (1,'Rathalos','El mayor depredador del Bosque Primigenio, también conocido como rey de los cielos.'),
    (2,'Rathian','Sus poderosas patas traseras y su cola venenosa le facilitan la caza a nivel de suelo, lo que le ha ganado el apodo de reina de la tierra');

insert into elements(id,name) values
    (1,'Agua'),
    (2,'Fuego');

insert into weapons(id,name,power,element) values
    (1,'Espada',23,1),
    (2,'Mandoble',46,2);

insert into armors(id,name,defense) values
    (1,'Gafas',35),
    (2,'Collar',85);

insert into characters(id,name) values
    (1,'Aleot'),
    (2,'Gamelon');

insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Aleot' and w.name = 'Espada';
insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Aleot' and w.name = 'Mandoble';
insert into character_weapon(character_id, weapon_id) select c.id, w.id from characters c, weapons w where c.name = 'Gamelon' and w.name = 'Mandoble';

insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Aleot' and a.name = 'Gafas';
insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Aleot' and a.name = 'Collar';
insert into character_armor(character_id, armor_id) select c.id, a.id from characters c, armors a where c.name = 'Gamelon' and a.name = 'Gafas';
