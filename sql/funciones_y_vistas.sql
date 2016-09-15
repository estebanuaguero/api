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

-- =============================================================================================================================

-- TIPO BOOLEAN

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val BOOLEAN, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val BOOLEAN, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

-- TIPO INTEGER

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val INTEGER, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val INTEGER, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

-- TIPO DOUBLE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

-- TIPO DATE

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DATE, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DATE, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

-- TIPO TIMESTAMP

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIMESTAMP, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIMESTAMP, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

-- TIPO TIME

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIME, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIME, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, is_start);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR) RETURNS VARCHAR AS $$
BEGIN
	IF att_val IS NOT NULL THEN
		att_val = REPLACE(att_val, '"', '');
	END IF;
	
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val INTEGER) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DOUBLE PRECISION) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, false, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val DATE) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val DATE) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIMESTAMP) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIMESTAMP) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val TIME) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val TIME) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name, att_val::VARCHAR, true, false);
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN) CASCADE;

CREATE OR REPLACE FUNCTION yacare.ja(att_name VARCHAR, att_val VARCHAR, is_string BOOLEAN, is_start BOOLEAN) RETURNS VARCHAR AS $$
BEGIN
	RETURN yacare.ja(att_name , att_val , is_string , is_start, true );
END;
$$  LANGUAGE plpgsql;

-- =============================================================================================================================

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


 
--select REPLACE(REPLACE(REPLACE(age('1979-11-12'::timestamp)::VARCHAR, 'years', 'años'), 'mons', 'meses'), 'days', 'días')

-- =============================================================================================================================

DROP TABLE IF EXISTS yacare.gender CASCADE;

CREATE TABLE yacare.gender
(
	  id character varying(255) NOT NULL,
	  erased boolean,
	  code character varying(50),
	  name character varying(50),
	  description character varying(255),  
	  CONSTRAINT gender_pkey PRIMARY KEY (id)
);


-- =============================================================================================================================

DELETE FROM yacare.gender;

INSERT INTO yacare.gender (id, erased, code, name, description) VALUES ('e3521105-9eba-45f4-b51f-63108158cfbc', false, 'M', 'Masculino', 'Sexo masculino');

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_gender_by_id(gender_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_gender_by_id(gender_id character varying) RETURNS SETOF character varying AS $BODY$
--------------------------------------------------------------------------------------------------------------------------------

SELECT	'{'
	------------------------------------------------------------------------------------------------
		|| yacare.ja('id', gender.id, true)
		|| yacare.ja('erased', gender.erased)
		|| yacare.ja('code', gender.code)
		|| yacare.ja('name', gender.name)
		|| yacare.ja('description', gender.description)
	------------------------------------------------------------------------------------------------
	|| '}'
FROM 	yacare.gender AS gender	
WHERE 	gender.id = $1

--------------------------------------------------------------------------------------------------------------------------------
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_gender_by_code(gender_code character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_gender_by_code(gender_code character varying) RETURNS SETOF character varying AS $BODY$
--------------------------------------------------------------------------------------------------------------------------------

SELECT	'{'
	------------------------------------------------------------------------------------------------
		|| yacare.ja('id', gender.id, true)
		|| yacare.ja('erased', gender.erased)
		|| yacare.ja('code', gender.code)
		|| yacare.ja('name', gender.name)
		|| yacare.ja('description', gender.description)
	------------------------------------------------------------------------------------------------
	|| '}'
FROM 	yacare.gender AS gender	
WHERE 	gender.code = $1

--------------------------------------------------------------------------------------------------------------------------------
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_gender CASCADE; 

CREATE OR REPLACE VIEW yacare.v_gender AS
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


-- =============================================================================================================================

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
		pp.education_level_type_id 
		

		/*
		
		--
		
		
		
		
		
		
		--
		--pp.country_id, 
		--pp.document_object_id, 
		--pp.married, 
		
		
		--pp.finished
		*/
		

	FROM 	yacare.physical_person pp
	--JOIN	yacare.family_relationship fr
	--	ON 	fr.physical_person_id = pp.id
	--	AND 	fr.legal_responsibility = true
	--WHERE	pp.state_enable = true;	
	;


-- SELECT * FROM yacare.v_person;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_country CASCADE; 

CREATE OR REPLACE VIEW yacare.v_country AS

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

-- =============================================================================================================================

--- GeoLocation

DROP VIEW IF EXISTS yacare.v_geo_location CASCADE; 

CREATE OR REPLACE VIEW yacare.v_geo_location AS

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
		JOIN	yacare.v_country c
			ON s.country_id = c.id;

-- =============================================================================================================================

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

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_identification_type_person CASCADE; 

CREATE OR REPLACE VIEW yacare.v_identification_type_person AS

	SELECT 	t.id::VARCHAR, 
		CASE 	WHEN t.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,
		t.code::VARCHAR,
		t.name::VARCHAR,
		t.comment::VARCHAR AS description
	FROM	yacare.identification_type_person t;

-- =============================================================================================================================

DELETE FROM yacare.identification_type_person WHERE code = 'ARG_CUIL';

INSERT INTO yacare.identification_type_person(id, state_enable, name, comment, code)
    VALUES ('e3521105-9eba-45f4-b51f-63108158cfbc', true, 'CUIL', 'CUIL', 'ARG_CUIL');


-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_identity_type CASCADE; 

CREATE OR REPLACE VIEW yacare.v_identity_type AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', t.id, true)
			|| yacare.ja('erased', t.erased)
			|| yacare.ja('code', t.code)
			|| yacare.ja('name', t.name)			
			|| yacare.ja('description', t.description)			
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.v_identification_type_person t;

	-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_identity_type(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_identity_type(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

	SELECT 	COALESCE('[ ' || string_agg(identity_type.json,', ' ORDER BY identity_type.id) || ']', 'null')	
	FROM 	yacare.v_identity_type AS identity_type
	OFFSET $1 
	LIMIT $2	
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_identity_type(0, 100);



	
-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_blood_factor CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_factor AS

	SELECT 	t.id::VARCHAR, 
		CASE 	WHEN t.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,
		TRIM(t.code)::VARCHAR AS code,
		TRIM(t.name)::VARCHAR AS name,
		TRIM(t.comment)::VARCHAR AS description
	FROM	yacare.blood_factor t;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_blood_factor_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_factor_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', t.erased)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.description))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.v_blood_factor t;	

-- SELECT * FROM yacare.v_blood_factor_json;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_blood_group CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_group AS

	SELECT 	t.id::VARCHAR, 
		CASE 	WHEN t.state_enable = true THEN false::BOOLEAN
			ELSE true::BOOLEAN
		END AS erased,
		TRIM(t.code)::VARCHAR AS code,
		TRIM(t.name)::VARCHAR AS name,
		TRIM(t.comment)::VARCHAR AS description
	FROM	yacare.blood_group t;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_blood_group_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_blood_group_json AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', t.erased)
			|| yacare.ja('code', TRIM(t.code))
			|| yacare.ja('name', TRIM(t.name))			
			|| yacare.ja('description', TRIM(t.description))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.v_blood_group t;	

-- SELECT * FROM yacare.v_blood_group_json;

-- =============================================================================================================================

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

-- =============================================================================================================================

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

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_phone CASCADE; 

CREATE OR REPLACE VIEW yacare.v_phone AS

	SELECT 	*,
		(
		'{'
			|| yacare.ja('id', TRIM(t.id), true)
			|| yacare.ja('erased', (NOT t.state_enable)::BOOLEAN)			
			|| yacare.ja('number', TRIM(t.name))			
			|| yacare.ja('comment', TRIM(t.comment))
			
		|| '}'
		)::VARCHAR AS json
	FROM	yacare.phone t;	

-- SELECT * FROM yacare.v_phone;	

-- =============================================================================================================================

/*

	SELECT 	COALESCE('[ ' || string_agg(address.json,', ' ORDER BY address.id) || ']', 'null')
	FROM	yacare.physical_person_address_list address_list							
	LEFT JOIN yacare.v_address address
		ON address_list.address_id = address.id
	WHERE address_list.physical_person_id = '2c9090b544db0f6f0144e5dc909d0882' 
	LIMIT 1

	SELECT 	COALESCE('[ ' || string_agg(address.json,', ' ORDER BY address.id) || ']', 'null')
	FROM	yacare.physical_person_address_list address_list							
	LEFT JOIN yacare.v_address address
		ON address_list.address_id = address.id
	WHERE address_list.physical_person_id = '2c9090b544db0f6f0144e5dc909d0882' 
	OFFSET 1
*/		
-- =============================================================================================================================


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
	JOIN	yacare.city l
		ON t.city_id = l.id
		JOIN	yacare.department_state_country d
			ON l.department_state_country_id = d.id
			JOIN	yacare.state_country s
				ON d.state_country_id = s.id
				JOIN	yacare.v_country c
					ON s.country_id = c.id
	WHERE 	address_list.physical_person_id = $1	
	ORDER BY t.id	
	LIMIT 1				

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_main_address_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_main_address_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');


-- =============================================================================================================================

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
	JOIN	yacare.city l
		ON t.city_id = l.id
		JOIN	yacare.department_state_country d
			ON l.department_state_country_id = d.id
			JOIN	yacare.state_country s
				ON d.state_country_id = s.id
				JOIN	yacare.v_country c
					ON s.country_id = c.id
	WHERE 	address_list.physical_person_id = $1	
	ORDER BY t.id
	OFFSET 1
	--LIMIT 2
) AS t							

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_alternative_addresses_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_alternative_addresses_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');

-- =============================================================================================================================

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
	WHERE mail_list.physical_person_id = $1		
	ORDER BY t.id		
	LIMIT 1			

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


--SELECT * FROM yacare.f_main_email_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_main_email_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');

-- =============================================================================================================================

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
	WHERE mail_list.physical_person_id = $1		
	ORDER BY t.id
	OFFSET 1			
) AS t	

$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_alternative_emails_person_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');
-- SELECT * FROM yacare.f_alternative_emails_person_by_person_id('2c9090b544db0f6f0144e5dc8b130778');

-- =============================================================================================================================

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

-- =============================================================================================================================

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



-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_person_json CASCADE; 

CREATE OR REPLACE VIEW yacare.v_person_json AS


SELECT	person.id,
	person.file_number, 
	person.comment, 
	education_level_type_id,
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
				|| yacare.ja('mainEmail', 					
					COALESCE(
					(
						/*
						SELECT 	email.json
						FROM	yacare.physical_person_email_list mail_list							
						LEFT JOIN yacare.v_email email
							ON mail_list.email_id = email.id
						WHERE person.id = mail_list.physical_person_id		
						ORDER BY email.id		
						LIMIT 1
						*/
						null
					)::VARCHAR, 'null')::VARCHAR 
				, false, true)	
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
LEFT JOIN yacare.v_gender gender
	ON gender.code = person.gender_code
LEFT JOIN yacare.v_geo_location geo_location
	ON person.birth_address_id = geo_location.locality_id		
LEFT JOIN yacare.v_country nationality_country
	ON person.nationality_country_id = nationality_country.id	
LEFT JOIN yacare.v_identity_type identity_type
	ON person.identification_type_person_id = identity_type.id	
LEFT JOIN yacare.v_identity_type identity_type_cuil
	ON person.cuil_cuit IS NOT NULL
	AND identity_type_cuil.code = 'ARG_CUIL'	
LEFT JOIN yacare.v_blood_factor_json blood_factor
	ON person.blood_factor_id = blood_factor.id	
LEFT JOIN yacare.v_blood_group_json blood_group
	ON person.blood_group_id = blood_group.id;

------------------------------------------										
-- SELECT * FROM yacare.v_person_json WHERE id = '2c9090b544db0f6f0144e5dc909d0882'

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_person_by_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_person_by_id(person_id character varying) RETURNS SETOF character varying AS $BODY$
	SELECT 	person.json::VARCHAR 
	FROM 	yacare.v_person_json AS person 
	WHERE 	person.id = $1
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;


-- SELECT * FROM yacare.f_person_by_id('ff80818144e5b96d0144e5b9f28e00a0');

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_career CASCADE; 

CREATE OR REPLACE VIEW yacare.v_career AS

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

-- SELECT * FROM yacare.v_career;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_state_value CASCADE; 

CREATE OR REPLACE VIEW yacare.v_state_value AS

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

-- SELECT * FROM yacare.v_state_value;	

-- select * from yacare.state_value 

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_year_calendar CASCADE; 

CREATE OR REPLACE VIEW yacare.v_year_calendar AS

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

-- SELECT * FROM yacare.v_year_calendar;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_period CASCADE; 

CREATE OR REPLACE VIEW yacare.v_period AS

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

-- SELECT * FROM yacare.v_period;

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_turn CASCADE; 

CREATE OR REPLACE VIEW yacare.v_turn AS

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

-- SELECT * FROM yacare.v_turn;

-- =============================================================================================================================


DROP VIEW IF EXISTS yacare.v_admission_act_enrollment CASCADE; 

CREATE OR REPLACE VIEW yacare.v_admission_act_enrollment AS

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
			|| ', "admissionEnrollment":{'
				--|| yacare.ja('enrollmentDate', 'Matrícula admitida y sin confirmar', true)
				--|| yacare.ja('admissionDate', null, true)
				--|| yacare.ja('enrollmentDate', null)
				
			|| '}'	
			--|| yacare.ja('mainSchoolShift', turn.json, false, false)	
			|| yacare.ja('state', state_value.json, false, false, false)	
			
			
		|| '}')::VARCHAR AS json
	FROM	yacare.admission_act
	LEFT JOIN yacare.enrollment
		ON enrollment.admission_act_id = admission_act.id
	LEFT JOIN yacare.v_year_calendar year_calendar
		ON admission_act.year_calendar = year_calendar.year
	LEFT JOIN yacare.v_period period
		ON admission_act.period_id = period.id		
	--LEFT JOIN yacare.v_turn turn
	--	ON admission_act.turn_id = turn.id
	LEFT JOIN yacare.v_state_value state_value
		ON enrollment.state_lc = state_value.code
		AND state_value.life_cycle_code = 'ENROLLMENT_LC';

-- SELECT * FROM yacare.v_admission_act_enrollment; 

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_education_level_type CASCADE; 

CREATE OR REPLACE VIEW yacare.v_education_level_type AS

	SELECT 	*,
		(
			'{'
				|| yacare.ja('id', TRIM(education_level_type.id), true)
				|| yacare.ja('erased', (NOT education_level_type.state_enable)::BOOLEAN)
				|| yacare.ja('code', TRIM(education_level_type.code))
				|| yacare.ja('name', TRIM(education_level_type.name))			
				|| yacare.ja('description', TRIM(education_level_type.comment))
				
			|| '}'
		)::VARCHAR AS json
	FROM 	yacare.education_level_type;
	
-- SELECT * FROM yacare.v_education_level_type;	

-- select * from yacare.education_level_type 


-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_student CASCADE; 

CREATE OR REPLACE VIEW yacare.v_student AS

	SELECT	person.id AS person_id,
		student.id AS student_id,
		('{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('id', student.id, true)
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
			|| yacare.ja('annualEnrollmentList', 
				(
					SELECT 	COALESCE('[ ' || string_agg(enrollment.json,', ' ORDER BY enrollment.year_calendar) || ']', 'null')
					FROM	yacare.v_admission_act_enrollment enrollment  
					WHERE 	student.id = enrollment.student_id						
					--LIMIT 1
					--OFFSET 0
				)::VARCHAR
			, false, false)			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json	
	FROM	yacare.student
	JOIN	yacare.v_person_json AS person
		ON student.physical_person_id = person.id
	JOIN	yacare.v_career career
		ON student.career_id = career.id
	LEFT JOIN yacare.v_state_value state_value
		ON student.state_lc = state_value.code
		AND state_value.life_cycle_code = 'ENROLLMENT_STUDENT_LC'
	LEFT JOIN yacare.v_country c
		ON c.iso_alfa2 = 'AR';
	--WHERE person.id = 'ff80818144e5b96d0144e5b9f28e00a0'


-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_student_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_student_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$
	SELECT 	student.json::VARCHAR 
	FROM 	yacare.v_student AS student 
	WHERE 	student.person_id = $1
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_student_by_person_id('ff80818144e5b96d0144e5b9f28e00a0');

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_student(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_student(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


	SELECT 	student.json::VARCHAR 
	FROM 	yacare.v_student AS student 
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_student(0, 100);

-- =============================================================================================================================

DROP VIEW IF EXISTS yacare.v_legal_guardian CASCADE; 

CREATE OR REPLACE VIEW yacare.v_legal_guardian AS

	SELECT	person.id,
		('{'
		------------------------------------------------------------------------------------------------
			|| yacare.ja('person', person.json, false, true, false)			
			|| yacare.ja('educationLevel', education_level_type.json, false, false, false)			
			|| yacare.ja('comment', TRIM(person.comment))		
			|| yacare.ja('summary', null::VARCHAR)
			
			|| yacare.ja('students', 
				(
				
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
				 
				)::VARCHAR
			, false, false)			
			
		------------------------------------------------------------------------------------------------
		|| '}')::VARCHAR AS json	
	FROM	yacare.v_person_json AS person
	LEFT JOIN yacare.v_education_level_type education_level_type
		ON person.education_level_type_id = education_level_type.id
	WHERE	(
			SELECT 	COUNT(*) 
			FROM 	yacare.family_relationship fr
				JOIN	yacare.physical_person_family_relationship_list ppfrl
					ON 	ppfrl.family_relationship_id = fr.id
					JOIN 	yacare.physical_person pp_child	
						ON ppfrl.physical_person_id = pp_child.id
						JOIN yacare.student s
							ON s.physical_person_id = pp_child.id
							AND s.state_enable = true
			WHERE	fr.physical_person_id = person.id
				AND 	fr.legal_responsibility = true
		) > 0	
		--AND	person.id = '31438562-21c3-47fa-a211-6c97262894b5'
		;			
	--JOIN	yacare.family_relationship fr
	--	ON 	fr.physical_person_id = person.id
	--	AND 	fr.legal_responsibility = true;
	--JOIN	yacare.physical_person_family_relationship_list ppfrl
	--	ON 	ppfrl.family_relationship_id = fr.id
	--	JOIN 	yacare.physical_person pp_child	
	--		ON ppfrl.physical_person_id = pp_child.id		
	--WHERE person.id = 'ff80818144e5b96d0144e5b9f28e00a0'

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_legal_guardian_by_person_id(person_id character varying) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian_by_person_id(person_id character varying) RETURNS SETOF character varying AS $BODY$
	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian AS legal_guardian 
	WHERE 	legal_guardian.id = $1
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

-- SELECT * FROM yacare.f_legal_guardian_by_person_id('31438562-21c3-47fa-a211-6c97262894b5');

-- =============================================================================================================================

DROP FUNCTION IF EXISTS yacare.f_legal_guardian(offsetArg INTEGER, limitArg INTEGER) CASCADE;

CREATE OR REPLACE FUNCTION yacare.f_legal_guardian(offsetArg INTEGER, limitArg INTEGER) RETURNS SETOF character varying AS $BODY$

SELECT 	COALESCE('[ ' || string_agg(t.json,', ' ) || ']', 'null')	
FROM	(


	SELECT 	legal_guardian.json::VARCHAR 
	FROM 	yacare.v_legal_guardian AS legal_guardian
	OFFSET 	$1
	LIMIT	$2	
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

 SELECT * FROM yacare.f_legal_guardian(0, 100);

-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================



--SELECT * FROM yacare.f_person_by_id('31438562-21c3-47fa-a211-6c97262894b5');
--SELECT * FROM yacare.f_person_by_id('2c9090b544db0f6f0144e5dc909d0882');
--SELECT * FROM yacare.f_person_by_id((select pp.id from yacare.physical_person pp WHERE pp.birth_address_id is not null limit 1));
-- SELECT * FROM yacare.f_person_by_id((select pp.id from yacare.physical_person pp WHERE pp.cuil_cuit is not null limit 1));


--select * from yacare.physical_person where cuil_cuit is not null 
/*
COPY (

--SELECT * FROM yacare.f_cadastre_by_id('b35d618d-ccb8-4895-ae88-6a7f659150ff')
--SELECT * FROM yacare.f_cadastre_by_id('f7a5a276-13bc-479e-ad40-6e9347a240a2')
--SELECT * FROM yacare.f_cadastre_by_id('5da07132-c1df-4e8b-82fd-852213d627c2')
SELECT * FROM yacare.f_cadastre_by_id('c3640d4c-e00c-410a-87e8-da094b10bb75')

) TO '/home/java/Descargas/json.json';
*/
-- =============================================================================================================================

-- =============================================================================================================================


/*
DROP VIEW IF EXISTS yacare.v_responsible_family CASCADE; 

CREATE OR REPLACE VIEW yacare.v_responsible_family AS

	SELECT 	pp.id, 
		pp.state_enable, 
		pp.name, 
		pp.last_name, 
		--pp.file_number, 
		pp.comment, 
		pp.identification_type_person_id, 
		pp.identification_number, 
		pp.cuil_cuit, 
		pp.masculine, 
		pp.blood_group_id, 
		pp.blood_factor_id, 
		pp.birth_date, 
		--pp.birth_address_id, 
		--pp.country_id, 
		--pp.document_object_id, 
		--pp.married, 
		--pp.nationality_country_id, 
		pp.education_level_type_id 
		--pp.finished
		
		

	FROM 	yacare.physical_person pp
	JOIN	yacare.family_relationship fr
		ON 	fr.physical_person_id = pp.id
		AND 	fr.legal_responsibility = true
	WHERE	pp.state_enable = true	
	--WHERE	pp.id = '31438562-21c3-47fa-a211-6c97262894b5'	
;
			

SELECT * FROM yacare.v_responsible_family;

-- select * from yacare.student where physical_person_id = 'ee2921ff-cfb5-11e3-97be-b5c9a3df597d'
-- select * from yacare.student where physical_person_id = 'ee375318-cfb5-11e3-97be-b5c9a3df597d'
-- select * from yacare.student where physical_person_id = '01559598-ac98-4c6a-9ee2-87b57cbcfd28'
*/
/*

SELECT 	pp.id,
	pp.last_name,
	pp.name,	
	pp_child.id,
	pp_child.last_name,
	pp_child.name

FROM 	yacare.physical_person pp
JOIN	yacare.family_relationship fr
	ON 	fr.physical_person_id = pp.id
	AND 	fr.legal_responsibility = true
	JOIN	yacare.physical_person_family_relationship_list ppfrl
		ON 	ppfrl.family_relationship_id = fr.id
		JOIN 	yacare.physical_person pp_child	
			ON ppfrl.physical_person_id = pp_child.id	
WHERE	pp.id = '31438562-21c3-47fa-a211-6c97262894b5'
	

select pp.id from yacare.physical_person pp WHERE pp.birth_address_id is not null	

*/
