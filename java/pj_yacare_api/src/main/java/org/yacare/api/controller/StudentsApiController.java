package org.yacare.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.cendra.commons.ex.AbstractGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.MainYacare;
import org.yacare.api.StudentsApi;
import org.yacare.bo.academic.student.StudentBo;
import org.yacare.model.ApiError;
import org.yacare.model.academic.student.Student;

@Controller
public class StudentsApiController implements StudentsApi {

	// ---------------------------------------------------------------------------------------

	public final static String endPointUrl_4 = endPointUrl_2 + "/photos";
	public final static String endPointTitle_4 = "Actualiza la foto del estudiante.";
	public final static String endPointReturn_4 = "Foto actualizada, retorna un estudiante";

	public final static String endPointArg1Title_4 = "Identificador de la persona que es estudiante";
	public final static String endPointArg1_4 = "id";

	public final static String endPointArg2Title_4 = "Foto del estudiante";
	public final static String endPointArg2_4 = "photo";

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = endPointTitle_4, notes = notes, response = Student.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = endPointReturn_4, response = Student.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_4, produces = { produces }, method = RequestMethod.PUT)
	public ResponseEntity updateStudentPhoto(
			@ApiParam(value = endPointArg1Title_4, required = true) @PathVariable(endPointArg1_4) String id,
			@ApiParam(value = endPointTitle_4, required = true) @RequestBody byte[] photo

	) {
		try {

			StudentBo studentBo = new StudentBo();
			studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
			studentBo.setGeneralProperties(MainYacare.generalProperties);

			Student student = studentBo.updateStudentPhoto(id, photo);

			return new ResponseEntity<Student>(student, HttpStatus.CREATED);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

	// ---------------------------------------------------------------------------------------

	public final static String endPointUrl_5 = endPointUrl_2 + "/photos";
	public final static String endPointTitle_5 = "Crea la foto del estudiante.";
	public final static String endPointReturn_5 = "Foto creada, retorna un estudiante";

	public final static String endPointArg1Title_5 = "Identificador de la persona que es estudiante";
	public final static String endPointArg1_5 = "id";

	public final static String endPointArg2Title_5 = "Foto del estudiante";
	public final static String endPointArg2_5 = "photo";

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = endPointTitle_5, notes = notes, response = Student.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = endPointReturn_5, response = Student.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_4, produces = { produces }, method = RequestMethod.POST)
	public ResponseEntity insertStudentPhoto(
			@ApiParam(value = endPointArg1Title_5, required = true) @PathVariable(endPointArg1_5) String id,
			@ApiParam(value = endPointTitle_5, required = true) @RequestBody byte[] photo

	) {
		try {

			StudentBo studentBo = new StudentBo();
			studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
			studentBo.setGeneralProperties(MainYacare.generalProperties);

			Student student = studentBo.insertStudentPhoto(id, photo);

			return new ResponseEntity<Student>(student, HttpStatus.CREATED);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}
	
	// ---------------------------------------------------------------------------------------

	public final static String endPointUrl_6 = endPointUrl_2 + "/photos";
	public final static String endPointTitle_6 = "Borra la foto del estudiante.";
	public final static String endPointReturn_6 = "Foto borrada, retorna un estudiante";

	public final static String endPointArg1Title_6 = "Identificador de la persona que es estudiante";
	public final static String endPointArg1_6 = "id";

	

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = endPointTitle_6, notes = notes, response = Student.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = endPointReturn_6, response = Student.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_4, produces = { produces }, method = RequestMethod.DELETE)
	public ResponseEntity deleteStudentPhoto(
			@ApiParam(value = endPointArg1Title_6, required = true) @PathVariable(endPointArg1_6) String id

	) {
		try {

			StudentBo studentBo = new StudentBo();
			studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
			studentBo.setGeneralProperties(MainYacare.generalProperties);

			Student student = studentBo.deleteStudentPhoto(id);

			return new ResponseEntity<Student>(student, HttpStatus.CREATED);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

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
	public ResponseEntity personPhotoGet(
			@ApiParam(value = endPointArg1Title_3, required = true) @PathVariable(endPointArg1_3) String id,
			@ApiParam(value = endPointArg2Title_3, required = true) @PathVariable(endPointArg2_3) String pohoto_id

	) {

		return utilPersonPhotoGet(id);

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

		return new ResponseEntity<Student>(student, HttpStatus.OK);

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

	private ResponseEntity utilPersonPhotoGet(String id) {

		try {

			StudentBo studentBo = new StudentBo();
			studentBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
			studentBo.setGeneralProperties(MainYacare.generalProperties);

			byte[] b = studentBo.getStudentPhotoByPersonId(id);

			return new ResponseEntity<byte[]>(b, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

}
