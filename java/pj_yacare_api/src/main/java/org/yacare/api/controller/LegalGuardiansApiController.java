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
import org.yacare.api.LegalGuardiansApi;
import org.yacare.bo.legal_guardian.LegalGuardianBo;
import org.yacare.model.academic.student.legal_guardian.LegalGuardian;

@Controller
public class LegalGuardiansApiController implements LegalGuardiansApi {

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<List<LegalGuardian>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getLegalGuardians(offset, limit);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<LegalGuardian> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return getLegalGuardianByPersonId(id);
	}

	// ================================================================================

	private ResponseEntity<LegalGuardian> getLegalGuardianByPersonId(String id) {

		if (id == null || id.trim().length() == 0) {
			return new ResponseEntity<LegalGuardian>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

		LegalGuardianBo legalGuardianBo = new LegalGuardianBo();
		legalGuardianBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		LegalGuardian legalGuardian = legalGuardianBo
				.getLegalGuardianByPersonId(id);

		if (legalGuardian == null) {
			return new ResponseEntity<LegalGuardian>(HttpStatus.NOT_FOUND);
		} else if (legalGuardian.getPersonalInformation().getId() == null
				|| legalGuardian.getPersonalInformation().getId().trim()
						.length() == 0) {
			return new ResponseEntity<LegalGuardian>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<LegalGuardian>(legalGuardian, HttpStatus.OK);
	}

	// -------------------------------------------------------------------------------

	private ResponseEntity<List<LegalGuardian>> getLegalGuardians(
			Integer offset, Integer limit) {

		LegalGuardianBo legalGuardianBo = new LegalGuardianBo();
		legalGuardianBo.setDataSourceWrapper(MainYacare
				.getDataSourceWrapper());

		List<LegalGuardian> legalGuardians = legalGuardianBo.getLegalGuardians(
				offset, limit);

		return new ResponseEntity<List<LegalGuardian>>(legalGuardians,
				HttpStatus.OK);
	}

}
