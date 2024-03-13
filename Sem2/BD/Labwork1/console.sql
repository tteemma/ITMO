DROP TYPE IF EXISTS gender CASCADE;
DROP TYPE IF EXISTS animal_type CASCADE;
DROP TYPE IF EXISTS difficulty_enum CASCADE;
DROP TYPE IF EXISTS consequences_enum CASCADE;
DROP TYPE IF EXISTS priority_enum CASCADE;

--
DROP TABLE IF EXISTS animal CASCADE ;
DROP TABLE IF EXISTS animal_actions CASCADE ;
DROP TABLE IF EXISTS location CASCADE ;
DROP TABLE IF EXISTS object CASCADE ;
DROP TABLE IF EXISTS trouble CASCADE ;
DROP TABLE IF EXISTS animal_trouble CASCADE ;
DROP TABLE IF EXISTS animal_origin CASCADE ;


---Создание ENUM'ов
CREATE TYPE gender_enum AS ENUM('М','Ж');
CREATE TYPE animal_type AS ENUM('антилопа','шакал','корова','собака');
CREATE TYPE difficulty_enum AS ENUM('легко','средне','сложно');
CREATE TYPE consequences_enum AS ENUM('минимальный','больше минимума','среднее','большие','огромные');
CREATE TYPE priority_enum AS ENUM('высокая','средняя','легкая');

---Создание Таблиц
CREATE TABLE IF NOT EXISTS animal(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    gener gender_enum NOT NULL,
    place INTEGER NOT NULL,
    origin INTEGER NOT NULL,
    age INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS animal_actions(
    id SERIAL PRIMARY KEY,
    action TEXT NOT NULL,
    object animal NOT NULL,
    subject animal NOT NULL,
    time_of_action INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS location(
    id SERIAL PRIMARY KEY,
    coordinates POINT NOT NULL,
    name TEXT NOT NULL,
    who_is_there TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS object(
    id SERIAL PRIMARY KEY,
    type text NOT NULL
);
CREATE TABLE IF NOT EXISTS trouble(
    id SERIAL PRIMARY KEY,
    priority text NOT NULL,
    consequences text NOT NULL
);
CREATE TABLE IF NOT EXISTS animal_trouble(
    PRIMARY KEY (animal_id, trouble_id),
    animal_id INTEGER REFERENCES animal(id) NOT NULL,
    trouble_id INTEGER REFERENCES trouble(id) NOT NULL
);
CREATE TABLE IF NOT EXISTS animal_origin(
    id SERIAL PRIMARY KEY,
    place TEXT NOT NULL,
    type_of_animal text NOT NULL
);
---Заполнение Таблиц Текстовыми Значениями
