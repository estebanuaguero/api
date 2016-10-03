

-- ALTER TABLE yacare.physical_person ADD COLUMN main_email character varying;

------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS yacare.legal_guardian_user CASCADE;

CREATE TABLE yacare.legal_guardian_user
(
	  id VARCHAR NOT NULL,
	  erased BOOLEAN DEFAULT false NOT NULL,
	  password  VARCHAR NOT NULL,	  
	  physical_person_id VARCHAR NOT NULL,
	  
	  CONSTRAINT legal_guardian_user_pkey PRIMARY KEY (id),
	  CONSTRAINT physical_person_id_fkey FOREIGN KEY (physical_person_id)
		REFERENCES yacare.physical_person (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- SELECT * FROM yacare.legal_guardian_user;

------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS yacare.legal_guardian_user_token CASCADE;

CREATE TABLE yacare.legal_guardian_user_token
(
	  id VARCHAR NOT NULL,
	  erased BOOLEAN DEFAULT false NOT NULL,	  	  
	  used BOOLEAN DEFAULT false NOT NULL,
	  creation_date TIMESTAMP NOT NULL DEFAULT now()::TIMESTAMP,
	  legal_guardian_user_id VARCHAR NOT NULL,
	  
	  CONSTRAINT legal_guardian_user_token_pkey PRIMARY KEY (id),
	  CONSTRAINT legal_guardian_user_id_fkey FOREIGN KEY (legal_guardian_user_id)
		REFERENCES yacare.legal_guardian_user (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- SELECT * FROM yacare.legal_guardian_user_token;

------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS yacare.gender CASCADE;

CREATE TABLE yacare.gender
(
	  id VARCHAR NOT NULL,
	  erased BOOLEAN DEFAULT false NOT NULL,
	  code VARCHAR NOT NULL UNIQUE,	  
	  name VARCHAR NOT NULL UNIQUE,	  
	  description VARCHAR,  
	  CONSTRAINT gender_pkey PRIMARY KEY (id)
);


DELETE FROM yacare.gender;

INSERT INTO yacare.gender (id, erased, code, name, description) VALUES ('e3521105-9eba-45f4-b51f-63108158cfbc', false, 'M', 'Masculino', 'Sexo masculino');
INSERT INTO yacare.gender (id, erased, code, name, description) VALUES ('e3521105-9eba-45f4-b51f-63108158cfbf', false, 'F', 'Femenino', 'Sexo femenino');

-- SELECT * FROM yacare.gender

-- =============================================================================================================================
/*
DROP VIEW IF EXISTS yacare.v_identification_type_person CASCADE; 

CREATE OR REPLACE VIEW yacare.v_identification_type_person AS

	SELECT 	t.id::VARCHAR, 
		CASE 	WHEN t.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,
		t.code::VARCHAR,
		t.name::VARCHAR,
		t.comment::VARCHAR AS description
	FROM	yacare.identification_type_person t
	WHERE	t.state_enable = true;
*/
-- =============================================================================================================================

DELETE FROM yacare.identification_type_person WHERE code = 'ARG_CUIL';

INSERT INTO yacare.identification_type_person(id, state_enable, name, comment, code)
    VALUES ('e3521105-9eba-45f4-b51f-63108158cfbc', true, 'CUIL', 'CUIL', 'ARG_CUIL');


SELECT 'COMIENZO'::VARCHAR; 

-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================

-- =============================================================================================================================
--							JSON FUNCTIONS
-- =============================================================================================================================


-- TIPO VARCHAR

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	IF att_val IS NOT NULL THEN
		att_val = REPLACE(att_val, '"', '');
	END IF;
		
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO BOOLEAN

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val BOOLEAN, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val BOOLEAN, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO INTEGER

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val INTEGER, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val INTEGER, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO DOUBLE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO DATE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DATE, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DATE, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO TIMESTAMP

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIMESTAMP, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIMESTAMP, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO TIME

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIME, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIME, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO BOOLEAN

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR) RETURNS VARCHAR AS $$
BEGIN
	IF att_val IS NOT NULL THEN
		att_val = REPLACE(att_val, '"', '');
	END IF;
	
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO INTEGER

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val INTEGER) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO DOUBLE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO DATE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DATE) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DATE) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO TIMESTAMP

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIMESTAMP) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIMESTAMP) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

-- TIPO TIME

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIME) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIME) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name , att_val , is_string , is_start, true );
END;
$$  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN, replace_double_quote BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN, replace_double_quote BOOLEAN) RETURNS VARCHAR AS $$
BEGIN

		--att_val = REPLACE(REPLACE(att_val, '"', ''), '
--', '\\n');

	--IF replace_double_quote = true THEN
	--	att_val = REPLACE(att_val, '"', '');
	--END IF;		

	--att_val = REPLACE(att_val, '"', '');

	IF att_val IS NULL AND is_start = true THEN
	        RETURN null;
	ELSEIF att_val IS NULL AND is_start = false THEN
		RETURN '';
	END IF;	

	IF att_name IS NOT NULL THEN
		att_name = ' "' || att_name || '":';
	ELSE 	
		att_name = '';
	END IF;	
		
	IF is_string = true AND is_start = false THEN

		RETURN ', ' || att_name  || '"' || att_val || '" ';
		
	ELSEIF is_string = true AND is_start = true THEN

		RETURN ' ' || att_name || '"' || att_val || '" ';
		
	ELSEIF is_string = false AND is_start = false THEN
	
		RETURN ', ' || att_name || att_val  || ' ';

	ELSEIF is_string = false AND is_start = true THEN

		RETURN ' ' || att_name|| att_val  || ' ';
	END IF;		
	
	
END;
$$  LANGUAGE plpgsql;



-- =============================================================================================================================
--							GEO OBJECTS
-- =============================================================================================================================



-- ____________________________________________________ COUNTRY _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_country_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_country_json AS

	SELECT *,
		(
		'{'
			|| yacare.ja('codeIsoAlfa2', c.iso_alfa2, true)
			|| yacare.ja('codeIsoAlfa3', c.iso_alfa3)
			|| yacare.ja('codeIsoNumber', c.iso)
			|| yacare.ja('shortName', c.name)
			|| yacare.ja('name', c.comment)
			--|| yacare.ja('callingCode', null)
			|| yacare.ja('nationalityName', c.citizenship)
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.country c;

-- SELECT * FROM yacare.v_country_json;


-- ____________________________________________________ GEO LOCATION _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_geo_location_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_geo_location_json AS

	SELECT 	c.iso_alfa2 AS country_iso_alfa2,
		c.iso_alfa3 AS country_iso_alfa3,
		c.iso AS country_iso_number,
		c.name AS country_short_name,
		c.comment AS country_name,
		c.citizenship AS country_nationality_name,

		s.code AS admin_area_level1_iso_code,
		s.name AS admin_area_level1_name,

		d.id::VARCHAR AS admin_area_level2_id,
		null::VARCHAR AS admin_area_level2_code,
		null::VARCHAR AS admin_area_level2_name,
		
		l.id AS locality_id,
		--l.code AS locality_code,
		l.name AS locality_name,
		l.postal_code AS zip_code,
		(
		'{'
		------------------------------------------------------------------------------------------------		
			|| yacare.ja('country', c.json, false, true, false)
			|| ', "adminAreaLevel1":{'
				|| yacare.ja('isoCode', s.code, true)
				|| yacare.ja('name', s.name)			
			|| '}'		
			|| ', "adminAreaLevel2":{'				
			|| '}'		
			|| yacare.ja('locality', l.name)
			|| yacare.ja('zipCode', l.postal_code)
			
		------------------------------------------------------------------------------------------------
		|| '}'
		)::VARCHAR AS json
		
	FROM	yacare.city l
	JOIN	yacare.department_state_country d
		ON l.department_state_country_id = d.id
		JOIN	yacare.state_country s
			ON d.state_country_id = s.id
			JOIN	yacare.v_country_json c
				ON s.country_id = c.id;
	

-- SELECT * FROM yacare.v_geo_location_json;

-- ____________________________________________________ ADDRESS _________________________________________________________________

/* 

DROP VIEW IF EXISTS yacare.v_address CASCADE; 

CREATE OR REPLACE VIEW yacare.v_address AS

	SELECT 	t.id::VARCHAR, 
		CASE 	WHEN t.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,		
		address_type_id, 
		---------------------------------------------------------
		c.iso_alfa2 AS country_iso_alfa2,
		c.iso_alfa3 AS country_iso_alfa3,
		c.iso AS country_iso_number,
		c.name AS country_short_name,
		c.comment AS country_name,
		c.citizenship AS country_nationality_name,

		s.code AS admin_area_level1_iso_code,
		s.name AS admin_area_level1_name,

		d.id::VARCHAR AS admin_area_level2_id,
		null::VARCHAR AS admin_area_level2_code,
		null::VARCHAR AS admin_area_level2_name,
		
		l.id AS locality_id,
		--l.code AS locality_code,
		l.name AS locality_name,
		--l.postal_code AS zip_code,
	
		---------------------------------------------------------		
		--t.city_id AS locality_id,
		--district_id, 
		t.district_comment AS neightbourhood, 
		--street_id, 
		t.street_comment AS street, 
		t."number" AS street_number, 
		t.floor, 
		t.flat AS room, 
		t.building, 
		t.comment::VARCHAR,
		t.postal_code AS zip_code,		
		(
			'{'
			------------------------------------------------------------------------------------------------		
				|| yacare.ja('id', t.id, true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)

				|| yacare.ja('country', c.json, false, false, false)
				|| ', "adminAreaLevel1":{'
					|| yacare.ja('isoCode', s.code, true)
					|| yacare.ja('name', s.name)			
				|| '}'		
				|| ', "adminAreaLevel2":{'				
				|| '}'		
				|| yacare.ja('locality', l.name)
				|| yacare.ja('zipCode', t.postal_code)
				|| yacare.ja('neightbourhood', t.district_comment)
				|| yacare.ja('street', t.street_comment)
				|| yacare.ja('streetNumber', t."number")
				|| yacare.ja('floor', t.floor)
				|| yacare.ja('room', t.flat)
				|| yacare.ja('building', t.building)
				|| yacare.ja('comment', t.comment)
				
			------------------------------------------------------------------------------------------------
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.address t
	JOIN	yacare.city l
		ON t.city_id = l.id
		JOIN	yacare.department_state_country d
			ON l.department_state_country_id = d.id
			JOIN	yacare.state_country s
				ON d.state_country_id = s.id
				JOIN	yacare.v_country c
					ON s.country_id = c.id;

	
-- SELECT * FROM yacare.v_address;

*/

-- =============================================================================================================================
--							PERSON
-- =============================================================================================================================

-- ____________________________________________________ GENDER _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_gender_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_gender_json AS
	SELECT 	*,
		(
		'{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('id', gender.id, true)
			|| yacare.ja('erased', gender.erased)
			|| yacare.ja('code', gender.code)
			|| yacare.ja('name', gender.name)
			|| yacare.ja('description', gender.description)
		------------------------------------------------------------------------------------------------
		|| '}'
		)::VARCHAR AS json		
		--(SELECT * FROM yacare.f_gender_by_id(id))::VARCHAR AS json
	FROM 	yacare.gender;

-- SELECT * FROM yacare.gender_json;	

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_gender(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_gender(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(gender.json,', ' ORDER BY gender.id) || ']', 'null')	
	FROM 	yacare.v_gender_json AS gender
	WHERE	gender.erased = false
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_gender(0, 100);

-- ____________________________________________________ BLODE FACTOR _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_blood_factor_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_factor_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.blood_factor t;	

-- SELECT * FROM yacare.v_blood_factor_json;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_blood_factor(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_blood_factor(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(blood_factor.json,', ' ORDER BY blood_factor.name) || ']', 'null')	
	FROM 	yacare.v_blood_factor_json AS blood_factor
	WHERE	blood_factor.state_enable = true
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_blood_factor(0, 100);	

-- ____________________________________________________ BLODE GROUUP _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_blood_group_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_group_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.blood_group t;	

-- SELECT * FROM yacare.v_blood_group_json;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_blood_group(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_blood_group(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(blood_group.json,', ' ORDER BY blood_group.name) || ']', 'null')	
	FROM 	yacare.v_blood_group_json AS blood_group
	WHERE	blood_group.state_enable = true
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_blood_group(0, 100);	

-- ____________________________________________________ PHONE TYPE _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_phone_type_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_phone_type_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.phone_type t;	

-- SELECT * FROM yacare.v_phone_type_json;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_phone_type(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_phone_type(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(phone_type.json,', ' ORDER BY phone_type.name) || ']', 'null')	
	FROM 	yacare.v_phone_type_json AS phone_type
	WHERE	phone_type.state_enable = true	
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_phone_type(0, 100);

------------------------------------------------------------------------------------------------------------------------------



DROP VIEW IF EXISTS yacare.v_phone_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_phone_json AS

	SELECT 	t.id, 
		(
		'{'
			|| yacare.ja('id', t.id, true)
			|| yacare.ja('erased', (not t.state_enable)::boolean)
			|| yacare.ja('localCallingCode', t.local_calling_code)
			|| yacare.ja('number', t.name)
			|| yacare.ja('comment', t.comment)
			--|| yacare.ja('phoneType', pt.json,false,false)
			||', "phoneType": {'
				|| yacare.ja('id', TRIM(pt.id), true)
				|| yacare.ja('erased', (NOT pt.state_enable)::BOOLEAN)
				|| yacare.ja('code', TRIM(pt.code))
				|| yacare.ja('name', TRIM(pt.name))			
				|| yacare.ja('description', TRIM(pt.comment))
			
			|| '}'
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.phone t
	left join yacare.phone_type pt 
		on  t.phone_type_id = pt.id
	where t.state_enable=true;	

-- SELECT * FROM yacare.v_phone_json;



------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_main_phone_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_main_phone_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$
	
	SELECT 	
		(
			'{'
				|| yacare.ja('id', TRIM(t.id), true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
				|| yacare.ja('number', TRIM(t.name))			
				|| yacare.ja('comment', TRIM(t.comment))	
				|| yacare.ja('phoneType', pt.json, false, false, false)	
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_phone_list l							
	JOIN 	yacare.phone t
		ON l.phone_id = t.id
		AND t.state_enable = true	
	LEFT JOIN yacare.v_phone_type_json pt
		ON t.phone_type_id = pt.id	
	WHERE l.physical_person_id = $1		
	ORDER BY t.id		
	LIMIT 1			

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_main_phone_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_main_phone_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');

/*

select 	distinct p.id 
from 	yacare.student s
join	yacare.physical_person p
	on s.physical_person_id = p.id
where	(select count(l.*) from yacare.physical_person_phone_list l where l.physical_person_id = p.id) > 6

*/

------------------------------------------------------------------------------------------------------------------------------


DROP FUNCTION IF EXISTS yacare.f_alternative_phones_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_alternative_phones_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	
		(
			'{'
				|| yacare.ja('id', TRIM(t.id), true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
				|| yacare.ja('number', TRIM(t.name))			
				|| yacare.ja('comment', TRIM(t.comment))	
				|| yacare.ja('phoneType', pt.json, false, false, false)			
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_phone_list l	
	JOIN 	yacare.phone t
		ON l.phone_id = t.id	
		AND t.state_enable = true
	LEFT JOIN yacare.v_phone_type_json pt
		ON t.phone_type_id = pt.id	
	WHERE 	l.physical_person_id = $1		
	ORDER BY t.id
	OFFSET 1			
) AS t	

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_alternative_phones_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_alternative_phones_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');
-- SELECT * FROM yacare.f_alternative_phones_person_by_person_id('6f3c778a-a331-11e5-8e50-00f48900a927');



-- ____________________________________________________ E-MAIL _________________________________________________________________

/*
DROP VIEW IF EXISTS yacare.v_email CASCADE; 

CREATE OR REPLACE VIEW yacare.v_email AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
			|| yacare.ja('email', TRIM(t.name))			
			|| yacare.ja('comment', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.email t;	

-- SELECT * FROM yacare.v_email;
*/
------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_main_email_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_main_email_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	
		(
			'{'
				|| yacare.ja('id', TRIM(t.id), true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
				|| yacare.ja('email', TRIM(t.name))			
				|| yacare.ja('comment', TRIM(t.comment))			
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_email_list mail_list							
	JOIN 	yacare.email t
		ON mail_list.email_id = t.id	
		AND t.state_enable = true
	WHERE mail_list.physical_person_id = $1		
	ORDER BY t.id		
	LIMIT 1			

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_main_email_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_main_email_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_alternative_emails_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_alternative_emails_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	
		(
			'{'
				|| yacare.ja('id', TRIM(t.id), true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
				|| yacare.ja('email', TRIM(t.name))			
				|| yacare.ja('comment', TRIM(t.comment))			
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_email_list mail_list							
	JOIN 	yacare.email t
		ON mail_list.email_id = t.id
		AND t.state_enable = true	
	WHERE mail_list.physical_person_id = $1		
	ORDER BY t.id
	OFFSET 1			
) AS t	

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_alternative_emails_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_alternative_emails_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');



-- ____________________________________________________ IDENTITY TYPE _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_identity_type_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_identity_type_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', t.id, true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', t.code)
			|| yacare.ja('name', t.name)			
			|| yacare.ja('description', TRIM(t.comment))	
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.identification_type_person t;

-- SELECT * FROM yacare.v_identity_type_json;	

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_identity_type(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_identity_type(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(identity_type.json,', ' ORDER BY identity_type.id) || ']', 'null')	
	FROM 	yacare.v_identity_type_json AS identity_type
	WHERE	identity_type.state_enable = true
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_identity_type(0, 100);

-- ____________________________________________________ PERSON  ADDRESS _________________________________________________________________

DROP FUNCTION IF EXISTS yacare.f_main_address_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_main_address_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	
		(
			'{'
			------------------------------------------------------------------------------------------------		
				|| yacare.ja('id', t.id, true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)

				|| yacare.ja('country', c.json, false, false, false)
				|| ', "adminAreaLevel1":{'
					|| yacare.ja('isoCode', s.code, true)
					|| yacare.ja('name', s.name)			
				|| '}'		
				|| ', "adminAreaLevel2":{'				
				|| '}'		
				|| yacare.ja('locality', l.name)
				|| yacare.ja('zipCode', t.postal_code)
				|| yacare.ja('neightbourhood', t.district_comment)
				|| yacare.ja('street', t.street_comment)
				|| yacare.ja('streetNumber', t."number")
				|| yacare.ja('floor', t.floor)
				|| yacare.ja('room', t.flat)
				|| yacare.ja('building', t.building)
				|| yacare.ja('comment', t.comment)
				
			------------------------------------------------------------------------------------------------
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_address_list address_list							
	JOIN 	yacare.address t
		ON address_list.address_id = t.id
		AND t.state_enable = true	
	JOIN	yacare.city l
		ON t.city_id = l.id
		JOIN	yacare.department_state_country d
			ON l.department_state_country_id = d.id
			JOIN	yacare.state_country s
				ON d.state_country_id = s.id
				JOIN	yacare.v_country_json c
					ON s.country_id = c.id
	WHERE 	address_list.physical_person_id = $1	
	ORDER BY t.id	
	LIMIT 1				

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_main_address_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_main_address_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');


------------------------------------------------------------------------------------------------------------------------------


DROP FUNCTION IF EXISTS yacare.f_alternative_addresses_person_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_alternative_addresses_person_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$


SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	
		(
			'{'
			------------------------------------------------------------------------------------------------		
				|| yacare.ja('id', t.id, true)
				|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)

				|| yacare.ja('country', c.json, false, false, false)
				|| ', "adminAreaLevel1":{'
					|| yacare.ja('isoCode', s.code, true)
					|| yacare.ja('name', s.name)			
				|| '}'		
				|| ', "adminAreaLevel2":{'				
				|| '}'		
				|| yacare.ja('locality', l.name)
				|| yacare.ja('zipCode', t.postal_code)
				|| yacare.ja('neightbourhood', t.district_comment)
				|| yacare.ja('street', t.street_comment)
				|| yacare.ja('streetNumber', t."number")
				|| yacare.ja('floor', t.floor)
				|| yacare.ja('room', t.flat)
				|| yacare.ja('building', t.building)
				|| yacare.ja('comment', t.comment)
				
			------------------------------------------------------------------------------------------------
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_address_list address_list							
	JOIN 	yacare.address t
		ON address_list.address_id = t.id	
		AND t.state_enable = true
	JOIN	yacare.city l
		ON t.city_id = l.id
		JOIN	yacare.department_state_country d
			ON l.department_state_country_id = d.id
			JOIN	yacare.state_country s
				ON d.state_country_id = s.id
				JOIN	yacare.v_country_json c
					ON s.country_id = c.id
	WHERE 	address_list.physical_person_id = $1	
	ORDER BY t.id
	OFFSET 1
	--LIMIT 2
) AS t							

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_alternative_addresses_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_alternative_addresses_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');


-- ____________________________________________________ EMERGENCY CONTACTS _________________________________________________________________



DROP FUNCTION IF EXISTS yacare.f_emergency_contacts_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_emergency_contacts_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(
	SELECT 	
		(
			'{'
			------------------------------------------------------------------------------------------------		
				|| yacare.ja('id', contact.id, true)
				|| yacare.ja('erased', (NOT contact.state_enable)::BOOLEAN)
				|| yacare.ja('name', contact.contact_name)
				|| yacare.ja('lastName', contact.contact_last_name)
				|| yacare.ja('relationship', contact.contact_relationship)
				--|| yacare.ja('phone', phone.json, false, false, false)
				||COALESCE(', "phone":{'
					|| yacare.ja('id', phone.id, true)
					|| yacare.ja('erased', (not phone.state_enable)::boolean)
					|| yacare.ja('localCallingCode', phone.local_calling_code)
					|| yacare.ja('number', phone.name)
					|| yacare.ja('comment', phone.comment)
					--|| yacare.ja('phoneType', pt.json,false,false)
					|| COALESCE(',"phoneType": {'
						|| yacare.ja('id', TRIM(pt.id), true)
						|| yacare.ja('erased', (NOT pt.state_enable)::BOOLEAN)
						|| yacare.ja('code', TRIM(pt.code))
						|| yacare.ja('name', TRIM(pt.name))			
						|| yacare.ja('description', TRIM(pt.comment))
					
					|| '}', '')
					
				|| '}', '')
				
				
							
			------------------------------------------------------------------------------------------------
			|| '}'
		)::VARCHAR AS json		
	FROM	yacare.physical_person_emergency_contacts contact
	left JOIN yacare.phone phone
		ON contact.phone_id = phone.id and phone.state_enable=true
	left join yacare.phone_type pt 
		on phone.id = pt.id
	WHERE 	contact.physical_person_id = $1
		AND	contact.state_enable = true
	ORDER BY contact.contact_last_name, contact.contact_name	
) as t			

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_emergency_contacts_by_person_id('79cac2d7-d722-444a-a0e7-2f7983bbbea2');

-- ____________________________________________________ PERSON _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_person CASCADE; 

CREATE OR REPLACE VIEW yacare.v_person AS

	SELECT 	pp.id::VARCHAR, 
		CASE 	WHEN pp.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,
		CASE 	WHEN pp.name IS NOT NULL AND CHAR_LENGTH(TRIM(pp.name)) > 0 THEN '["' || REPLACE(TRIM(pp.name), '"', '\"') || '"]'::VARCHAR
			ELSE null::VARCHAR
		END AS names,
		CASE 	WHEN pp.last_name IS NOT NULL AND CHAR_LENGTH(TRIM(pp.last_name)) > 0 THEN '["' || REPLACE(TRIM(pp.last_name), '"', '\"') || '"]'::VARCHAR
			ELSE null::VARCHAR
		END AS last_names,
		CASE 	WHEN pp.masculine = true THEN 'M'::VARCHAR
			ELSE 'F'::VARCHAR
		END AS gender_code,
		pp.birth_date,
		pp.birth_address_id,
		pp.nationality_country_id,
		pp.identification_type_person_id, 
		pp.identification_number, 
		pp.cuil_cuit,
		pp.blood_group_id, 
		pp.blood_factor_id,
		pp.comment, 
		pp.file_number,
		pp.education_level_type_id,
		pp.main_email 		

	FROM 	yacare.physical_person pp
	WHERE	pp.state_enable = true;
	

-- SELECT * FROM yacare.v_person;

------------------------------------------------------------------------------------------------------------------------------

DROP VIEW IF EXISTS yacare.v_person_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_person_json AS

	SELECT	person.id,
		person.identification_number,
		person.file_number, 		
		person.comment, 		
		person.education_level_type_id,		
		('{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('id', person.id, true)
			|| yacare.ja('erased', person.erased)
			|| yacare.ja('givenNames', person.names, false, false)
			|| yacare.ja('surnames', person.last_names, false, false)
			|| yacare.ja('gender', gender.json, false, false, false)
			|| ', "birth":{'
				|| yacare.ja('id', person.id, true)
				|| yacare.ja('dateOfBirth', birth_date) 			
				|| yacare.ja('age', date_part('year',age(birth_date::TIMESTAMP))::INTEGER)
				|| yacare.ja('fullAge', REPLACE(REPLACE(REPLACE(REPLACE(age(birth_date::TIMESTAMP)::VARCHAR, 'years', 'años'), 'mons', 'meses'), 'days', 'días'), 'mon', 'mes')::VARCHAR)
				--|| yacare.ja('fullAge', REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(age('2015-08-17'::TIMESTAMP)::VARCHAR, 'years', 'años'), 'mons', 'meses'), 'days', 'días'), 'mon', 'mes'), 'day', 'día'), 'year', 'año')::VARCHAR)
				|| yacare.ja('placeOfBirth', COALESCE(geo_location.json, '{}')::VARCHAR, false, false, false)
				--|| ', "geoLocation":' || COALESCE(geo_location.json, '{}')			
			|| '}'
			|| ', "nationalities":{'
				|| COALESCE('"mainNationality":{'
					|| yacare.ja('country', nationality_country.json, false, true, false)
				|| '}', '')			
			|| '}'
			|| ', "identityDocuments":{'
				|| '"mainIdentity":{'
					|| yacare.ja('identityNumber', COALESCE(person.identification_number, ''), true)
					|| yacare.ja('identityType', identity_type.json, false, false, false)
				|| '}'
							
				|| COALESCE(', "identities":[' 
					|| '{'
						|| yacare.ja('identityNumber', person.cuil_cuit, true)
						|| yacare.ja('identityType', identity_type_cuil.json, false, false, false)
					|| '}'		
				|| ']', '')			
			|| '}'
			|| ', "communicationOptions":{'
				|| '"addresses":{'			
					|| yacare.ja('mainAddress', 					
						COALESCE(
						(
							/*
							SELECT 	address.json
							FROM	yacare.physical_person_address_list address_list							
							LEFT JOIN yacare.v_address address
								ON address_list.address_id = address.id
							WHERE person.id = address_list.physical_person_id		
							ORDER BY address.id		
							LIMIT 1
							*/
							null
						)::VARCHAR, 'null')::VARCHAR 
					, false, true)	
					|| yacare.ja('alternativeAddresses', 
						(
							/*
							SELECT 	COALESCE('[ ' || string_agg(address.json,', ' ORDER BY address.id) || ']', 'null')
							FROM	yacare.physical_person_address_list address_list							
							LEFT JOIN yacare.v_address address
								ON address_list.address_id = address.id
							WHERE address_list.physical_person_id = person.id
							--LIMIT 1
							--OFFSET 0
							*/
							null
						)::VARCHAR
					, false, false)				
								
				|| '}'
				|| ', "emails":{'	
					|| yacare.ja('mainEmail', COALESCE(person.main_email, 'null')::VARCHAR, false, true)	
					|| yacare.ja('alternativeEmails', 
						(
							/*
							SELECT 	COALESCE('[ ' || string_agg(email.json,', ' ORDER BY email.id) || ']', 'null')
							FROM	yacare.physical_person_email_list mail_list							
							LEFT JOIN yacare.v_email email
								ON mail_list.email_id = email.id
							WHERE person.id = mail_list.physical_person_id	
							--LIMIT 1
							--OFFSET 0
							*/
							null
						)::VARCHAR
					, false, false)				
				|| '}'		

				|| ', "phones":{'	
					|| yacare.ja('mainPhone', 					
						COALESCE(
						(
							/*
							SELECT 	phone.json
							FROM	yacare.physical_person_phone_list phone_list							
							LEFT JOIN yacare.v_phone phone
								ON phone_list.phone_id = phone.id
							WHERE person.id = phone_list.physical_person_id		
							ORDER BY phone.id		
							LIMIT 1
							*/
							null
						)::VARCHAR, 'null')::VARCHAR 
					, false, true)	
					|| yacare.ja('alternativePhones', 
						(
							/*			
							SELECT 	COALESCE('[ ' || string_agg(phone.json,', ' ORDER BY phone.id) || ']', 'null')
							FROM	yacare.physical_person_phone_list phone_list							
							LEFT JOIN yacare.v_phone phone
								ON phone_list.phone_id = phone.id
							WHERE person.id = phone_list.physical_person_id						
							--LIMIT 1
							--OFFSET 0
							*/
							null
						)::VARCHAR
					, false, false)				
				|| '}'		
				
			|| '}'
			|| ', "healthData":{'
				|| yacare.ja('bloodFactor', COALESCE(blood_factor.json, 'null'), false, true, false)
				|| yacare.ja('bloodGroup', COALESCE(blood_group.json, 'null'), false, false, false)
			|| '}'
			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json
	FROM 	yacare.v_person AS person	
	------------------------------------------
	LEFT JOIN yacare.v_gender_json gender
		ON gender.code = person.gender_code
	LEFT JOIN yacare.v_geo_location_json geo_location
		ON person.birth_address_id = geo_location.locality_id		
	LEFT JOIN yacare.v_country_json nationality_country
		ON person.nationality_country_id = nationality_country.id	
	LEFT JOIN yacare.v_identity_type_json identity_type
		ON person.identification_type_person_id = identity_type.id	
	LEFT JOIN yacare.v_identity_type_json identity_type_cuil
		ON person.cuil_cuit IS NOT NULL
		AND identity_type_cuil.code = 'ARG_CUIL'	
	LEFT JOIN yacare.v_blood_factor_json blood_factor
		ON person.blood_factor_id = blood_factor.id	
	LEFT JOIN yacare.v_blood_group_json blood_group
		ON person.blood_group_id = blood_group.id;


-- SELECT * FROM yacare.v_person_json WHERE id = '2c9090b544db0f6f0144e5dc909d0882'


------------------------------------------------------------------------------------------------------------------------------

/*

DROP FUNCTION IF EXISTS yacare.f_person_by_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_person_by_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	person.json::VARCHAR 
	FROM 	yacare.v_person_json AS person 
	WHERE 	person.id = $1
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_person_by_id('ff80818144e5b96d0144e5b9f28e00a0');

*/


-- =============================================================================================================================
--							LEGAL GUARDIAN
-- =============================================================================================================================

-- ____________________________________________________ EDUCATION LEVEL TYPE _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_education_level_type_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_education_level_type_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.education_level_type t;	

-- SELECT * FROM yacare.v_education_level_type_json;	

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_education_level_type(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_education_level_type(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(education_level_type.json,', ' ORDER BY education_level_type.code) || ']', 'null')	
	FROM 	yacare.v_education_level_type_json AS education_level_type
	WHERE	education_level_type.state_enable = true
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_education_level_type(0, 100);


-- ____________________________________________________ FAMILY RELATIONSHIP TYPE _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_family_relationship_type_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_family_relationship_type_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.family_relationship_type t;	

-- SELECT * FROM yacare.v_family_relationship_type_json;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_family_relationship_type(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_family_relationship_type(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(family_relationship_type.json,', ' ORDER BY family_relationship_type.code) || ']', 'null')	
	FROM 	yacare.v_family_relationship_type_json AS family_relationship_type
	WHERE	family_relationship_type.state_enable = true
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_family_relationship_type(0, 100);



-- ____________________________________________________ FAMILY STUDENTS _________________________________________________________________


DROP FUNCTION IF EXISTS yacare.f_legal_guardian_students(person_id VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_students(person_id VARCHAR) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


			SELECT 	(
					'{'
						|| '"person":{' 
							|| yacare.ja('id', pp_child.id, true)		
						|| '}'	
						|| yacare.ja('familyRelationshipType', rt.json, false, false, false)			
							
					|| '}'
				)::VARCHAR AS json	

			FROM 	yacare.family_relationship fr
			LEFT JOIN yacare.v_family_relationship_type_json rt
				ON 	fr.family_relationship_type_id = rt.id
			JOIN	yacare.physical_person_family_relationship_list ppfrl
				ON 	ppfrl.family_relationship_id = fr.id
				JOIN 	yacare.physical_person pp_child	
					ON 	ppfrl.physical_person_id = pp_child.id
					AND 	pp_child.state_enable = true
					JOIN yacare.student s
						ON 	s.physical_person_id = pp_child.id
						AND 	s.state_enable = true
			WHERE	fr.physical_person_id = $1 -- 'd898013a-256b-4ca0-a750-726ec667dfa3' --person.id
				AND 	fr.legal_responsibility = true	
				AND 	fr.state_enable = true
				
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_students('d898013a-256b-4ca0-a750-726ec667dfa3');


-- ____________________________________________________ LEGAL GUARDIAN  _________________________________________________________________


DROP FUNCTION IF EXISTS yacare.f_legal_guardian_check(id_person_arg VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_check(id_person_arg VARCHAR) RETURNS BOOLEAN AS $BODY$

			SELECT 	COUNT(*) > 0
			FROM 	yacare.family_relationship fr
				JOIN	yacare.physical_person_family_relationship_list ppfrl
					ON 	ppfrl.family_relationship_id = fr.id
					JOIN 	yacare.physical_person pp_child	
						ON 	ppfrl.physical_person_id = pp_child.id
						AND	pp_child.state_enable = true
						JOIN yacare.student s
							ON 	s.physical_person_id = pp_child.id
							AND 	s.state_enable = true
							-- falta condicionar por el estdo, que no sea egresado
			WHERE	fr.physical_person_id = $1
				AND 	fr.legal_responsibility = true
				AND 	fr.state_enable = true	
	
$BODY$ LANGUAGE sql; -- VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_check('31438562-21c3-47fa-a211-6c97262894b5');


			


DROP VIEW IF EXISTS yacare.v_legal_guardian_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_legal_guardian_json AS

	SELECT	person.id,
		('{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('personalInformation', person.json, false, true, false)			
			|| yacare.ja('educationLevel', education_level_type.json, false, false, false)			
			|| yacare.ja('comment', TRIM(person.comment))		
			|| yacare.ja('summary', null::VARCHAR)
			
			|| yacare.ja('students', 
				(
				/*
					SELECT 	COALESCE('[ ' || string_agg('{' || yacare.ja('id', pp_child.id, true) || '}',', ') || ']', 'null')
					FROM 	yacare.family_relationship r
					JOIN	yacare.physical_person_family_relationship_list l
						ON 	l.family_relationship_id = r.id
						JOIN 	yacare.physical_person pp_child	
							ON l.physical_person_id = pp_child.id
							JOIN yacare.student s
								ON s.physical_person_id = pp_child.id
								AND s.state_enable = true	
					WHERE	r.legal_responsibility = true
						AND r.physical_person_id = person.id
				 */
				 null
				)::VARCHAR
			, false, false)			
			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json	
	FROM	yacare.v_person_json AS person
	LEFT JOIN yacare.v_education_level_type_json education_level_type
		ON person.education_level_type_id = education_level_type.id
	WHERE	yacare.f_legal_guardian_check(person.id) = true;	



-- SELECT * FROM yacare.v_legal_guardian_json LIMIT 100;


------------------------------------------------------------------------------------------------------------------------------


DROP FUNCTION IF EXISTS yacare.f_legal_guardian(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian_json AS legal_guardian	
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian(0, 100);

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_legal_guardian_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian_json AS legal_guardian 
	WHERE 	legal_guardian.id = $1
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_by_person_id('31438562-21c3-47fa-a211-6c97262894b5');


-- =============================================================================================================================
--							ACADEMIC
-- =============================================================================================================================

-- ____________________________________________________ CAREER  _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_career CASCADE; 

CREATE OR REPLACE VIEW yacare.v_career_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
			|| yacare.ja('code', TRIM(t.code))			
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.comment))
			|| yacare.ja('yearOfImplementation', t.year_of_implementation)
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.career t;	

-- SELECT * FROM yacare.v_career_json;

-- ____________________________________________________ YEAR CALENDAR  _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_year_calendar_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_year_calendar_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
			|| yacare.ja('year', t.year)						
			|| yacare.ja('description', TRIM(t.comment))
			|| yacare.ja('start', t.start_calendar)
			|| yacare.ja('end', t.end_calendar)
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.year_calendar t;	

-- SELECT * FROM yacare.v_year_calendar_json;

-- ____________________________________________________ PERIOD  _________________________________________________________________

DROP VIEW IF EXISTS yacare.v_period_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_period_json AS

	SELECT 	period.*,		
		(
		'{'
			|| yacare.ja('id', TRIM(period.id), true)
			|| yacare.ja('erased', (NOT period.state_enable)::BOOLEAN)
			|| yacare.ja('code', period.number)			
			|| yacare.ja('description', TRIM(period.comment))
			/*|| ', "cycle":' || COALESCE('{'
				|| yacare.ja('id', TRIM(cycle.id), true)
				|| yacare.ja('erased', (NOT cycle.state_enable)::BOOLEAN)
				|| yacare.ja('code', cycle.number)
				|| yacare.ja('name', TRIM(cycle.name))			
				|| yacare.ja('description', TRIM(cycle.comment))		
			|| '}', 'null')*/
		|| '}'
		)::VARCHAR AS json
	FROM 	yacare.cycle
	JOIN	yacare.period
		ON period.cycle_id = cycle.id;	

-- SELECT * FROM yacare.v_period_json;

-- ____________________________________________________ SCHOOL SHIFT  _________________________________________________________________

/*

DROP VIEW IF EXISTS yacare.v_turn_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_turn_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
			|| yacare.ja('name', TRIM(t.name))						
			|| yacare.ja('description', TRIM(t.comment))
			|| yacare.ja('start', t.time_start)
			|| yacare.ja('end', t.time_end)
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.turn t;	

-- SELECT * FROM yacare.v_turn_json;

*/

-- =============================================================================================================================
--							STUDENT
-- =============================================================================================================================

-- ____________________________________________________ STATE VALUE  _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_state_value_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_state_value_json AS

	SELECT 	state_value.*,
		life_cycle.code AS life_cycle_code,
		(
		'{'
			|| yacare.ja('id', TRIM(state_value.id), true)
			|| yacare.ja('erased', (NOT state_value.state_enable)::BOOLEAN)
			|| yacare.ja('code', TRIM(state_value.code))
			|| yacare.ja('name', TRIM(state_value.name))			
			|| yacare.ja('description', TRIM(state_value.comment))
			/*|| ', "lifeCycle":' || COALESCE('{'
				|| yacare.ja('id', TRIM(life_cycle.id), true)
				|| yacare.ja('erased', (NOT life_cycle.state_enable)::BOOLEAN)
				|| yacare.ja('code', TRIM(life_cycle.code))
				|| yacare.ja('name', TRIM(life_cycle.name))			
				|| yacare.ja('description', TRIM(life_cycle.comment))		
			|| '}', 'null')*/
		|| '}'
		)::VARCHAR AS json
	FROM 	yacare.life_cycle
	JOIN	yacare.state_value
		ON state_value.life_cycle_id = life_cycle.id;	

-- SELECT * FROM yacare.v_state_value_json;	

-- SELECT * FROM yacare.state_value;	

-- ____________________________________________________ ENROLLMENT  _________________________________________________________________


DROP VIEW IF EXISTS yacare.v_admission_act_enrollment_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_admission_act_enrollment_json AS

	SELECT	admission_act.id AS admission_act_id,
		enrollment.id AS enrollment_id,		
		admission_act.student_id AS student_id,
		admission_act.year_calendar AS year_calendar,		
		(
		'{'
			|| yacare.ja('id', TRIM(admission_act.id), true)
			|| yacare.ja('erased', (NOT admission_act.state_enable)::BOOLEAN)			
			|| yacare.ja('academicYear', year_calendar.json, false, false, false)	
			|| yacare.ja('period', period.json, false, false, false)
			--|| ', "admissionEnrollment":{'
				--|| yacare.ja('enrollmentDate', 'Matrícula admitida y sin confirmar', true)
				--|| yacare.ja('admissionDate', null, true)
				--|| yacare.ja('enrollmentDate', null)
				
			--|| '}'	
			--|| yacare.ja('mainSchoolShift', turn.json, false, false)	
			|| yacare.ja('state', state_value.json, false, false, false)	
			
			
		|| '}')::VARCHAR AS json
	FROM	yacare.admission_act
	LEFT JOIN 	yacare.enrollment
		ON 	enrollment.admission_act_id = admission_act.id
		AND	enrollment.state_enable = true 	
	LEFT JOIN 	yacare.v_year_calendar_json year_calendar
		ON 	admission_act.year_calendar = year_calendar.year
	LEFT JOIN 	yacare.v_period_json period
		ON 	admission_act.period_id = period.id		
	--LEFT JOIN yacare.v_turn turn
	--	ON admission_act.turn_id = turn.id
	LEFT JOIN 	yacare.v_state_value_json state_value
		ON 	enrollment.state_lc = state_value.code
		AND 	state_value.life_cycle_code = 'ENROLLMENT_LC'
	WHERE	admission_act.state_enable = true;

-- SELECT * FROM yacare.v_admission_act_enrollment_json; 


------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_annual_enrollment(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_annual_enrollment(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	enrollment.json::VARCHAR 
	FROM	yacare.v_admission_act_enrollment_json enrollment   	
	ORDER BY enrollment.year_calendar
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_annual_enrollment(0, 100);

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, student_id_arg VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, student_id_arg VARCHAR) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	enrollment.json::VARCHAR 
	FROM	yacare.v_admission_act_enrollment_json enrollment   
	WHERE 	enrollment.student_id = $3 --WHERE ($3 IS NULL OR enrollment.student_id = $3) 
	ORDER BY enrollment.year_calendar
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_annual_enrollment(0, 100, null);
-- SELECT * FROM yacare.f_annual_enrollment(0, 100, 'ff80818144e5b96d0144e5ba611304cb');

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, student_id_arg VARCHAR, last_admission_arg BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, student_id_arg VARCHAR, last_admission_arg BOOLEAN) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	enrollment.json::VARCHAR 
	FROM	yacare.v_admission_act_enrollment_json enrollment   
	WHERE 	enrollment.student_id = $3 AND ((enrollment_id IS NULL AND $4 = true) OR (enrollment_id IS NOT NULL AND $4 = false)) --WHERE ($3 IS NULL OR enrollment.student_id = $3) 
	-- AGREGAR CONTROL POR AÑO CALENDARIO ACTUAL 	
	ORDER BY enrollment.year_calendar
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_annual_enrollment(0, 100, null, false);
-- SELECT * FROM yacare.f_annual_enrollment(0, 100, null, true);
-- SELECT * FROM yacare.f_annual_enrollment(0, 100, 'ff80818144e5b96d0144e5ba611304cb', true);
-- SELECT * FROM yacare.f_annual_enrollment(0, 100, 'ff80818144e5b96d0144e5ba611304cb', false);

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, last_admission_arg BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_annual_enrollment(offset_arg INTEGER, limit_arg INTEGER, last_admission_arg BOOLEAN) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(

	SELECT 	enrollment.json::VARCHAR 
	FROM	yacare.v_admission_act_enrollment_json enrollment   
	WHERE	(enrollment_id IS NULL AND $3 = true) OR (enrollment_id IS NOT NULL AND $3 = false)
	ORDER BY enrollment.year_calendar
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_annual_enrollment(0, 100, false);
-- SELECT * FROM yacare.f_annual_enrollment(0, 100, true);


-- ____________________________________________________ FAMILY LEGAL GUARDIANS  _________________________________________________________________


DROP FUNCTION IF EXISTS yacare.f_student_responsible_family(person_id VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_student_responsible_family(person_id VARCHAR) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


		SELECT 	(
				'{'
					|| '"person":{' 
						|| yacare.ja('id', tutor.id, true)		
					|| '}'	
					|| yacare.ja('familyRelationshipType', rt.json, false, false, false)			
					|| yacare.ja('educationLevel', el.json, false, false, false)			
				|| '}'
			)::VARCHAR AS json					
			
		FROM 	yacare.family_relationship r
		JOIN 	yacare.physical_person tutor
				ON r.physical_person_id = tutor.id
				AND tutor.state_enable = true
		LEFT JOIN yacare.v_education_level_type_json el
				ON tutor.education_level_type_id = el.id
		LEFT JOIN yacare.v_family_relationship_type_json rt
				ON r.family_relationship_type_id = rt.id		
		JOIN	yacare.physical_person_family_relationship_list l
			ON 	l.family_relationship_id = r.id
			JOIN 	yacare.physical_person pp_child	
				ON l.physical_person_id = pp_child.id
				AND pp_child.state_enable = true
				AND 	pp_child.id = $1
				JOIN yacare.student s
					ON s.physical_person_id = pp_child.id
					AND s.state_enable = true
		WHERE	r.legal_responsibility = true
			AND	r.state_enable = true	
			--AND 	pp_child.id = $1			
		ORDER BY rt.code	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_student_responsible_family('ff80818144e5b96d0144e5ba611304cc');


-- ____________________________________________________ STUDENT  _________________________________________________________________

DROP VIEW IF EXISTS yacare.v_student_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_student_json AS

	SELECT	person.id AS person_id,
		student.id AS student_id,
		('{'
		------------------------------------------------------------------------------------------------
			--|| yacare.ja('id', student.id, true)
			|| yacare.ja('id', person.id, true)
			|| yacare.ja('erased', (NOT student.state_enable)::BOOLEAN)
			|| yacare.ja('personalInformation', person.json, false, false, false)
			|| ', "institution":{'	
				|| yacare.ja('id', 'cnm.unc.edu.ar', true)
				|| yacare.ja('erased', false::BOOLEAN)			
				|| yacare.ja('shortName', 'CNM')						
				|| yacare.ja('name', 'Colegio Nacional de Monserrat')
				|| yacare.ja('webSite', 'www.cnm.unc.edu.ar')
				|| yacare.ja('country', c.json, false, false, false)							
			|| '}'
			|| yacare.ja('career', career.json, false, false, false)
			|| yacare.ja('state', state_value.json, false, false, false)			
			|| ', "inscriptionInstitution":{'				
			|| '}'
			|| ', "admissionInstitution":{'				
			|| '}'
			|| ', "graduationInstitution":{'				
			|| '}'	
			|| yacare.ja('annualEnrollments', 
				(
					--SELECT 	COALESCE('[ ' || string_agg(enrollment.json,', ' ORDER BY enrollment.year_calendar) || ']', 'null')
					--FROM	yacare.v_admission_act_enrollment enrollment  
					--WHERE 	student.id = enrollment.student_id											
					null
				)::VARCHAR
			, false, false)			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json	
	FROM	yacare.student
	JOIN	yacare.v_person_json AS person
		ON student.physical_person_id = person.id
	JOIN	yacare.v_career_json career
		ON student.career_id = career.id
	LEFT JOIN yacare.v_state_value_json state_value
		ON student.state_lc = state_value.code
		AND state_value.life_cycle_code = 'ENROLLMENT_STUDENT_LC'
	LEFT JOIN yacare.v_country_json c
		ON c.iso_alfa2 = 'AR';
	--WHERE person.id = 'ff80818144e5b96d0144e5b9f28e00a0'


-- SELECT * FROM yacare.v_student_json LIMIT 100;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_student(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_student(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


	SELECT 	student.json::VARCHAR 
	FROM 	yacare.v_student_json AS student 
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_student(0, 100);

------------------------------------------------------------------------------------------------------------------------------


DROP FUNCTION IF EXISTS yacare.f_student_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_student_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	student.json::VARCHAR 
	FROM 	yacare.v_student_json AS student 
	WHERE 	student.person_id = $1
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_student_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');


-- =============================================================================================================================
--							USER
-- =============================================================================================================================

-- ____________________________________________________ LEGAL GUARDIAN USER  _________________________________________________________________



DROP VIEW IF EXISTS yacare.v_legal_guardian_user_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_legal_guardian_user_json AS

	SELECT	u.id AS legal_guardian_user_id,
		person.id AS person_id,
		person.identification_number AS user_name,
		u.erased,		
		('{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('idxx', person.id, true)
			|| yacare.ja('personalInformation', person.json, false, true, false)
			|| yacare.ja('erased', u.erased)
			|| yacare.ja('userName', LOWER(TRIM(person.identification_number)))
			|| yacare.ja('password', TRIM(u.password))			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json	
	FROM	yacare.legal_guardian_user u
	JOIN	yacare.v_person_json AS person
		ON u.physical_person_id = person.id	
	WHERE	yacare.f_legal_guardian_check(person.id) = true;

-- SELECT * FROM yacare.v_legal_guardian_user_json LIMIT 100;

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_legal_guardian_users(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_users(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian_user_json AS legal_guardian	
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_users(0, 100);

------------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS yacare.f_legal_guardian_users_by_user_name(user_name_arg character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_users_by_user_name(user_name_arg character varying) RETURNS SETOF character varying AS $BODY$

	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian_user_json AS legal_guardian 
	WHERE 	LOWER(TRIM(legal_guardian.user_name)) = LOWER(TRIM($1))
		
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_users_by_user_name('13567967');


------------------------------------------------------------------------------------------------------------------------------




-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================

SELECT 'OK - FIN'::VARCHAR; 