package org.yacare.api.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.MainYacare;
import org.yacare.api.GendersApi;
import org.yacare.bo.person.physical.PersonGenderBo;
import org.yacare.model.person.physical.PersonGender;

@Controller
public class GendersApiController implements GendersApi {

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<List<PersonGender>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getBloodFactors(offset, limit);
	}
 
	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<PersonGender> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<PersonGender>(HttpStatus.OK);
	}

	// ================================================================================

	private ResponseEntity<List<PersonGender>> getBloodFactors(Integer offset,
			Integer limit) {

		PersonGenderBo genderBo = new PersonGenderBo();
		genderBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());

		List<PersonGender> genders = genderBo.getGenders(offset, limit);

		return new ResponseEntity<List<PersonGender>>(genders, HttpStatus.OK);
	}

}
