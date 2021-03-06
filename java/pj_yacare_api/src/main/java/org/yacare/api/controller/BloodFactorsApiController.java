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
import org.yacare.api.BloodFactorsApi;
import org.yacare.bo.health.BloodFactorBo;
import org.yacare.model.health.BloodFactor;

@Controller
public class BloodFactorsApiController implements BloodFactorsApi {
	
	// -------------------------------------------------------------------------------
 
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<BloodFactor>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getBloodFactors(offset, limit);
	}
	
	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<BloodFactor> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<BloodFactor>(HttpStatus.OK);
	}
	
	// ================================================================================

	private ResponseEntity<List<BloodFactor>> getBloodFactors(Integer offset,
			Integer limit) {

		BloodFactorBo bloodFactorBo = new BloodFactorBo();
		bloodFactorBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<BloodFactor> bloodFactors = bloodFactorBo.getBloodFactors(offset,
				limit);

		return new ResponseEntity<List<BloodFactor>>(bloodFactors,
				HttpStatus.OK);
	}

}
