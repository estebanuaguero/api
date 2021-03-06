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
import org.yacare.api.PhoneTypesApi;
import org.yacare.bo.communication_options.phone.PhoneTypeBo;
import org.yacare.model.person.communication_options.phone.PhoneType;

@Controller
public class PhoneTypesApiController implements PhoneTypesApi {

	// -------------------------------------------------------------------------------
  
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<PhoneType>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getTypesOfPhones(offset, limit);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<PhoneType> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<PhoneType>(HttpStatus.OK);
	}

	// ================================================================================

	private ResponseEntity<List<PhoneType>> getTypesOfPhones(Integer offset,
			Integer limit) {

		PhoneTypeBo phoneTypeBo = new PhoneTypeBo();
		phoneTypeBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<PhoneType> phoneTypes = phoneTypeBo
				.getTypesOfPhones(offset, limit);

		return new ResponseEntity<List<PhoneType>>(phoneTypes, HttpStatus.OK);
	}

}
