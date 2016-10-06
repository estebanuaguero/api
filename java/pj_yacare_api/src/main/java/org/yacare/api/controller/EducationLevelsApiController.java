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
import org.yacare.api.EducationLevelsApi;
import org.yacare.model.academic.student.legal_guardian.EducationLevel;
import org.yacare.model.academic.student.legal_guardian.EducationLevelBo;

@Controller
public class EducationLevelsApiController implements EducationLevelsApi {

	// -------------------------------------------------------------------------------
	
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<EducationLevel>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getEducationLevels(offset, limit);
	}
	 
	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<EducationLevel> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<EducationLevel>(HttpStatus.OK);
	}
	
	// ================================================================================

	private ResponseEntity<List<EducationLevel>> getEducationLevels(
			Integer offset, Integer limit) {

		EducationLevelBo educationLevelBo = new EducationLevelBo();
		educationLevelBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<EducationLevel> educationLevels = educationLevelBo
				.getEducationLevels(offset, limit);

		return new ResponseEntity<List<EducationLevel>>(educationLevels,
				HttpStatus.OK);
	}

}
