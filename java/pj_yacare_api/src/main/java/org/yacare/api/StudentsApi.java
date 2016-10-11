package org.yacare.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yacare.model.ApiError;
import org.yacare.model.academic.student.Student;

@Api(value = "students")
public interface StudentsApi {

	public static String tagName = "Student";
	public static String notes = "El endpoint de Estudiantes devuelve el Expediente Académico (o Legajo Académico) del mismo, entre sus datos se encuentra su información personal, Colegio y Plan de Estudio que cursa, estado del estudiante, listado de matrículas anuales, y datos como cuando ingreso al colegio, cuando egreso, etc.  ";
	public static String produces = "application/json";

	public static final String msg404 = "Objeto no encontrado";
	public static final String msg409 = "Error de negocio";
	public static final String msg422 = "Argumento inválido";
	public static final String msg500 = "Error interno del servidor";

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_1 = "/students";
	public static String endPointTitle_1 = "Estudiantes paginados";
	public static String endPointReturn_1 = "Retorna un listado de estudiantes";

	public static String endPointArg1Title_1 = "Desplazamiento de la lista de resultados devueltos por esta cantidad. El valor predeterminado es cero.";
	public static String endPointArg1_1 = "offset";

	public static String endPointArg2Title_1 = "Cantidad de estudiantes que se recuperará. El valor predeterminado es 5, el máximo es 100.";
	public static String endPointArg2_1 = "limit";

	@ApiOperation(value = endPointTitle_1, notes = notes, response = Student.class, responseContainer = "List", tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_1, response = Student.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_1, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<List<Student>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_2 = endPointUrl_1 + "/{id}";
	public static String endPointTitle_2 = "Estudiante por id de la persona (estudiante)";
	public static String endPointReturn_2 = "Retorna un estudiante";

	public static String endPointArg1Title_2 = "Identificador de la persona que es estudiante";
	public static String endPointArg1_2 = "id";

	@ApiOperation(value = endPointTitle_2, notes = notes, response = Student.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_2, response = Student.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 422, message = msg422),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_2, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<Student> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_3 = endPointUrl_2 + "/photos/{photo_id}";
	public static String endPointTitle_3 = "Retorna la foto del estudiante.";
	public static String endPointReturn_3 = "Retorna la foto del estudiante";

	public static String endPointArg1Title_3 = "Identificador de la persona que es estudiante";
	public static String endPointArg1_3 = "id";

	public static String endPointArg2Title_3 = "Identificador de la foto del estudiante";
	public static String endPointArg2_3 = "photo_id";

//	@ResponseBody
	@ApiOperation(value = endPointTitle_3, notes = notes, response = byte[].class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_3, response = byte[].class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_3, produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE }, method = RequestMethod.GET)
	Object personPhotoGet(
			@ApiParam(value = endPointArg1Title_3, required = true) @PathVariable(endPointArg1_3) String id,
			@ApiParam(value = endPointArg2Title_3, required = true) @PathVariable(endPointArg2_3) String pohoto_id

	);

}
