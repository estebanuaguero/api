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
import org.yacare.api.FamilyRelationshipTypesApi;
import org.yacare.bo.person.physical.FamilyRelationshipTypeBo;
import org.yacare.model.academic.student.FamilyRelationshipType;

@Controller
public class FamilyRelationshipTypesApiController implements
		FamilyRelationshipTypesApi {

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<List<FamilyRelationshipType>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getFamilyRelationshipTypes(offset, limit);
	}
 
	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<FamilyRelationshipType> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<FamilyRelationshipType>(HttpStatus.OK);
	}

	// ================================================================================

	private ResponseEntity<List<FamilyRelationshipType>> getFamilyRelationshipTypes(
			Integer offset, Integer limit) {

		FamilyRelationshipTypeBo bloodGroupBo = new FamilyRelationshipTypeBo();
		bloodGroupBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<FamilyRelationshipType> familyRelationshipTypes = bloodGroupBo
				.getFamilyRelationshipTypes(offset, limit);

		return new ResponseEntity<List<FamilyRelationshipType>>(
				familyRelationshipTypes, HttpStatus.OK);
	}

}
