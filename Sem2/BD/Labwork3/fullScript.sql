--Тригер
--Я добавил поле loc_traffic в таблицу location, которое отвечает за
--количество машин на дороге и написал для автоматического обновления этого атрибута тригер
CREATE OR REPLACE FUNCTION update_location_traffic()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        UPDATE location
        SET loc_traffic = loc_traffic + 1
        WHERE id = NEW.location_id;
    ELSIF(TG_OP = 'DELETE') THEN
        UPDATE location
        SET loc_traffic = loc_traffic - 1
        WHERE id = OLD.location_id;
    ELSIF(TG_OP = 'UPDATE') THEN
        UPDATE location
        SET loc_traffic = loc_traffic - 1
        WHERE id = OLD.location_id;
            UPDATE location
        SET loc_traffic = loc_traffic + 1
        WHERE id = NEW.location_id;
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER update_location_traffic_trigger
    AFTER INSERT OR DELETE OR UPDATE ON location
    FOR EACH ROW
    EXECUTE FUNCTION update_location_traffic();

SELECT * FROM location;