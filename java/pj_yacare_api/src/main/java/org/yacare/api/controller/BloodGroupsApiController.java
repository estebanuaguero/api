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
import org.yacare.api.BloodGroupsApi;
import org.yacare.bo.health.BloodGroupBo;
import org.yacare.model.health.BloodGroup;

@Controller
public class BloodGroupsApiController implements BloodGroupsApi {
	
	// -------------------------------------------------------------------------------
 
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<BloodGroup>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getBloodGroups(offset, limit);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<BloodGroup> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<BloodGroup>(HttpStatus.OK);
	}

	// ================================================================================

	private ResponseEntity<List<BloodGroup>> getBloodGroups(Integer offset,
			Integer limit) {

		BloodGroupBo bloodGroupBo = new BloodGroupBo();
		bloodGroupBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<BloodGroup> bloodGroups = bloodGroupBo.getBloodGroups(offset,
				limit);

		return new ResponseEntity<List<BloodGroup>>(bloodGroups, HttpStatus.OK);
	}

}
