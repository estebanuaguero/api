package org.yacare.api.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.Swagger2SpringBoot;
import org.yacare.api.StudentsApi;
import org.yacare.bo.academic.student.StudentBo;
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

	// ================================================================================

	private ResponseEntity<Student> getStudentByPersonId(String id) {

		// try {

		if (id == null || id.trim().length() == 0) {
			return new ResponseEntity<Student>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		StudentBo studentBo = new StudentBo();
		studentBo.setDataSourceWrapper(Swagger2SpringBoot
				.getDataSourceWrapper());

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
		studentBo.setDataSourceWrapper(Swagger2SpringBoot
				.getDataSourceWrapper());

		List<Student> students = studentBo.getStudents(offset, limit);

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

}