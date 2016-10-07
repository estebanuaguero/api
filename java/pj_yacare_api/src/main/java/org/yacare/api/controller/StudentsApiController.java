package org.yacare.api.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.cendra.commons.ex.AbstractGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.MainYacare;
import org.yacare.api.StudentsApi;
import org.yacare.bo.academic.student.StudentBo;
import org.yacare.model.ApiError;
import org.yacare.model.academic.student.Student;

@Controller
public class StudentsApiController implements StudentsApi {

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Student>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getStudents(offset, limit);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public ResponseEntity<Student> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id) {

		return getStudentByPersonId(id);
	}

	// -------------------------------------------------------------------------------

	@CrossOrigin(origins = "*")
	public Object personPhotoGet(
			@ApiParam(value = endPointArg1Title_3, required = true) @PathVariable(endPointArg1_3) String id,
			@ApiParam(value = endPointArg2Title_3, required = true) @PathVariable(endPointArg2_3) String pohoto_id

	) {

		Object o = utilPersonPhotoGet(id);
		
		if (o instanceof byte[]) {
			byte[] b = (byte[]) o;
			
			return b;
		}

		return o;
	}

	// ================================================================================

	private ResponseEntity<Student> getStudentByPersonId(String id) {

		// try {

		if (id == null || id.trim().length() == 0) {
			return new ResponseEntity<Student>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		StudentBo studentBo = new StudentBo();
		studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());

		Student student = studentBo.getStudentByPersonId(id);

		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		} else if (student.getId() == null
				|| student.getId().trim().length() == 0) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		// else if (student.getId() == null
		// || student.getId().trim().equals(id.trim()) == false) {
		// return new ResponseEntity<Student>(
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }

		return new ResponseEntity<Student>(student, HttpStatus.OK);

		// } catch (Exception e) {
		// return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
		// }

	}

	// -------------------------------------------------------------------------------

	private ResponseEntity<List<Student>> getStudents(Integer offset,
			Integer limit) {

		StudentBo studentBo = new StudentBo();
		studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());

		List<Student> students = studentBo.getStudents(offset, limit);

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	// -------------------------------------------------------------------------------

	private Object utilPersonPhotoGet(String id) {

		try {

			StudentBo studentBo = new StudentBo();
			studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());			
			studentBo.setGeneralProperties(MainYacare.generalProperties);

			return studentBo.getStudentPhotoByPersonId(id);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

}
