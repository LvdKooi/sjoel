create table spel (
  id int primary key AUTO_INCREMENT,
  startmoment DATETIME not null
);

create table speler (
  id int primary key AUTO_INCREMENT,
  naam varchar(55) not null,
  spel_id int
);

create table score (
  id int primary key AUTO_INCREMENT,
  ronde int,
  score int not null,
  speler_id int,
  ronde_id int
);

create table ronde (
  id int primary key AUTO_INCREMENT,
  ronde_nummer int,
  ronde_id int,
  spel_id int
);
