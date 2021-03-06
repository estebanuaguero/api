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
import org.yacare.api.IdentityTypesApi;
import org.yacare.bo.person.identity_document.IdentityTypeBo;
import org.yacare.model.person.identity_document.IdentityType;

@Controller
public class IdentityTypesApiController implements IdentityTypesApi {

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<List<IdentityType>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getIdentityTypes(offset, limit);
	}
 
	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<IdentityType> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<IdentityType>(HttpStatus.OK);
	}

	// ================================================================================

	public ResponseEntity<List<IdentityType>> getIdentityTypes(Integer offset,
			Integer limit) {

		IdentityTypeBo identityTypeBo = new IdentityTypeBo();
		identityTypeBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<IdentityType> identityTypes = identityTypeBo.getIdentityTypes(
				offset, limit);

		return new ResponseEntity<List<IdentityType>>(identityTypes,
				HttpStatus.OK);
	}

}
