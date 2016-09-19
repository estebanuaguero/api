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
-- =============================================================================================================================
-- =============================================================================================================================

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



-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================
-- =============================================================================================================================

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

-- SELECT * FROM yacare.f_legal_guardian(0, 100);

-- =============================================================================================================================

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
					ON fr.family_relationship_type_id = rt.id
				JOIN	yacare.physical_person_family_relationship_list ppfrl
					ON 	ppfrl.family_relationship_id = fr.id
					JOIN 	yacare.physical_person pp_child	
						ON ppfrl.physical_person_id = pp_child.id
						JOIN yacare.student s
							ON s.physical_person_id = pp_child.id
							AND s.state_enable = true
			WHERE	fr.physical_person_id = $1 -- 'd898013a-256b-4ca0-a750-726ec667dfa3' --person.id
				AND 	fr.legal_responsibility = true				
				
) AS t
	
$BODY$ LANGUAGE sql VOLATILE COST 100 ROWS 1000;

 SELECT * FROM yacare.f_legal_guardian_students('d898013a-256b-4ca0-a750-726ec667dfa3');