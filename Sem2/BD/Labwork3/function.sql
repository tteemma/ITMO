--Функция для поиска животного, в чьей стае минимального количества животных
CREATE OR REPLACE FUNCTION low_number_pack_id() RETURNS INTEGER AS
$$
DECLARE
    min_animal integer;
BEGIN
    IF (EXISTS (
       SELECT *
       FROM animal
       LEFT JOIN number_in_the_pack
       ON number_in_the_pack.animal_id = animal.id
       WHERE number_in_the_pack.id IS NULL
    )) THEN
       SELECT animal.id INTO min_animal
       FROM animal
       LEFT JOIN number_in_the_pack
       ON number_in_the_pack.animal_id = animal.id
       WHERE number_in_the_pack.id IS NULL
       LIMIT 1;
       RETURN min_animal;
    ELSE
        SELECT animal_id INTO min_animal
        FROM number_in_the_pack
        GROUP BY number_in_the_pack.animal_id
       ORDER BY COUNT(*)
        LIMIT 1;
        RETURN min_animal;
    END IF;
END;
$$
LANGUAGE plpgsql;
SELECT * FROM low_number_pack_id();
