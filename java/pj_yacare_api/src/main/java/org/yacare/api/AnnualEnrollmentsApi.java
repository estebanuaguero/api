package org.yacare.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;

@Api(value = "annual_enrollments")
public interface AnnualEnrollmentsApi {

	public static String tagName = "AnnualEnrollment";
	public static String notes = "Matrícula anual del estudiante";
	public static String produces = "application/json";

	public static final String msg404 = "Matrícula no encontrada";
	public static final String msg422 = "Id de matrícula anual inválido";
	public static final String msg500 = "Error interno del servidor";

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_1 = "/annual_enrollments";
	public static String endPointTitle_1 = "Matrículas paginadas";
	public static String endPointReturn_1 = "Retorna un listado de matrículas";

	public static String endPointArg1Title_1 = "Desplazamiento de la lista de resultados devueltos por esta cantidad. El valor predeterminado es cero.";
	public static String endPointArg1_1 = "offset";

	public static String endPointArg2Title_1 = "Cantidad de matrículas que se recuperará. El valor predeterminado es 5, el máximo es 100.";
	public static String endPointArg2_1 = "limit";

	public static String endPointArg3Title_1 = "";
	public static String endPointArg3_1 = "idStudent";

	public static String endPointArg4Title_1 = "Última matrícula admitida (sin confirmar)";
	public static String endPointArg4_1 = "lastAdmission";

	@ApiOperation(value = endPointTitle_1, notes = notes, response = AnnualEnrollment.class, responseContainer = "List", tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_1, response = AnnualEnrollment.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_1, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<List<AnnualEnrollment>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit,
			@ApiParam(value = endPointArg3Title_1) @RequestParam(value = endPointArg3_1, required = false) String idStudent,
			@ApiParam(value = endPointArg4Title_1) @RequestParam(value = endPointArg4_1, required = false) Boolean lastAdmission

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_2 = endPointUrl_1 + "/{id}";
	public static String endPointTitle_2 = "Matrícula por id";
	public static String endPointReturn_2 = "Retorna una matrícula";

	public static String endPointArg1Title_2 = "Identificador de la matrícula";
	public static String endPointArg1_2 = "id";

	@ApiOperation(value = endPointTitle_2, notes = notes, response = AnnualEnrollment.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_2, response = AnnualEnrollment.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 422, message = msg422),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_2, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<AnnualEnrollment> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id

	);

}
