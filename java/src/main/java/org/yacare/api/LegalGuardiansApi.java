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
import org.yacare.model.academic.student.legal_guardian.LegalGuardian;

@Api(value = "legal_guardians")
public interface LegalGuardiansApi {

	public static String tagName = "LegalGuardian";
	public static String notes = "Tutor o Responsable Legal de Estudiantes, también llamados tutores legales, o padres.";
	public static String produces = "application/json";

	public static final String msg404 = "Tutor no encontrado";
	public static final String msg422 = "Id de tutor inválido";
	public static final String msg500 = "Error interno del servidor";

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_1 = "/legal_guardians";
	public static String endPointTitle_1 = "Tutores paginados";
	public static String endPointReturn_1 = "Retorna un listado de tutores";

	public static String endPointArg1Title_1 = "Desplazamiento de la lista de resultados devueltos por esta cantidad. El valor predeterminado es cero.";
	public static String endPointArg1_1 = "offset";

	public static String endPointArg2Title_1 = "Cantidad de tutores que se recuperará. El valor predeterminado es 5, el máximo es 100.";
	public static String endPointArg2_1 = "limit";

	@ApiOperation(value = endPointTitle_1, notes = notes, response = LegalGuardian.class, responseContainer = "List", tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_1, response = LegalGuardian.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_1, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<List<LegalGuardian>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_2 = endPointUrl_1 + "/{id}";
	public static String endPointTitle_2 = "Tutor por id de la persona (tutor)";
	public static String endPointReturn_2 = "Retorna un tutor";

	public static String endPointArg1Title_2 = "Identificador de la persona que es tutor";
	public static String endPointArg1_2 = "id";

	@ApiOperation(value = endPointTitle_2, notes = notes, response = LegalGuardian.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_2, response = LegalGuardian.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 422, message = msg422),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_2, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<LegalGuardian> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id

	);

}
