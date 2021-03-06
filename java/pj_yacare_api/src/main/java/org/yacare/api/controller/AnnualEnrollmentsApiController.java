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
import org.yacare.api.AnnualEnrollmentsApi;
import org.yacare.bo.academic.student.annual_enrollment.AnnualEnrollmentBo;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;

@Controller
public class AnnualEnrollmentsApiController implements AnnualEnrollmentsApi {

	// --------------------------------------------------------------------------------
 
	@CrossOrigin(origins = "*")
	//@CrossOrigin(origins = "http://localhost:9000")
	public ResponseEntity<List<AnnualEnrollment>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit,
			@ApiParam(value = endPointArg3Title_1) @RequestParam(value = endPointArg3_1, required = false) String idStudent,
			@ApiParam(value = endPointArg4Title_1) @RequestParam(value = endPointArg4_1, required = false) Boolean lastAdmission) {

		return getAnnualEnrollments(offset, limit, idStudent, lastAdmission);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<AnnualEnrollment> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return new ResponseEntity<AnnualEnrollment>(HttpStatus.OK);
	}

	// ================================================================================

	private ResponseEntity<List<AnnualEnrollment>> getAnnualEnrollments(
			Integer offset, Integer limit, String idStudent,
			Boolean lastAdmission) {

		AnnualEnrollmentBo annualEnrollmentBo = new AnnualEnrollmentBo();
		annualEnrollmentBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<AnnualEnrollment> annualEnrollments = annualEnrollmentBo
				.getAnnualEnrollments(offset, limit, idStudent, lastAdmission);

		return new ResponseEntity<List<AnnualEnrollment>>(annualEnrollments,
				HttpStatus.OK);
	}

}
