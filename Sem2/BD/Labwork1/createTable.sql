BEGIN

CREATE
CREATE TYPE actions AS ENUM(
	'лежать',
	'сломана',
	'ослаб',
	'держаться',
	'мочь',
	'ждать',
	'знать'
	'работать'
);
CREATE TYPE entity_table as ENUM(
	'Антилопа',
	'Шакал',
	'Животное'
	'Локация'
);
CREATE TABLE items(
	id SERIAL PRIMARY KEY,
	type entity_table NOT NULL
);
CREATE TABLE locations(
	id SERIAL PRIMARY KEY,
	name VARCHAR(200) NOT NULL DEFAULT 'кое-где',
	coords POINT,
	item_id INT REFERENCES items(id)
);
CREATE TABLE animal(
	id SERIAL PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL DEFAULT 'животное',
	current_location_id INT NOT NULL REFERENCES locations(id),
	gende gender NOT NULL DEFAULT 'М'
);
CREATE TABLE animal_actions(
	 id SERIAL PRIMARY KEY,
	 action actions NOT NULL,
	 objects_id INT REFERENCES items(id),
	 subject_id INT,
	 time_of_action TIMESTAMP NOT NULL DEFAULT NOW()
);
CREATE TABLE horns(
	id SERIAL PRIMARY KEY,
	located_id INTEGER,
	degree_of_acuity BOOLEAN DEFAULT TRUE,
	counts INT 
);
CREATE TABLE body_parts(
	id SERIAL PRIMARY KEY,
	leg_id INT,
	head_id INT
);
CREATE TABLE proximity(
	id SERIAL PRIMARY KEY,
	for_what_id INT NOT NULL REFERENCES locations(id),
	animal entity_table  DEFAULT 'животное',
	anima_id INTEGER NOT NULL REFERENCES animal(id)
);

INSERT INTO items(type) VALUES('locations');
INSERT INTO items(type) VALUES('locations');
INSERT INTO locations(name, coords, item_id)
VALUES('тропа', POINT(10,10),1),
	('гора', POINT(1,2),2);

INSERT INTO animal(name,gender,current_location_id)
VALUES ('Антилопа', 'М',1),
		('Шакал','М',2),
		('Аноним','Ж',2);

INSERT INTO items(type) VALUES ('horns');
INSERT INTO horns(located_id,counts) VALUES (1,2);

INSERT INTO proximity(for_what_id, animal, animal_id)
VALUES(1,'Антилопа',1);


INSERT INTO animal_actions(action, objects_id, subject_id)
VALUES('лежать',1,1),
	('сломана',1,1),
	('знать',2,2);
	
COMMIT;
