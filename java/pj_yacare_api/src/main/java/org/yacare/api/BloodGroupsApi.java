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
import org.yacare.model.health.BloodGroup;

@Api(value = "blood_groups")
public interface BloodGroupsApi {

	public static String tagName = "BloodGroup";
	public static String notes = "Grupo sanguineo de una persona. Ver https://es.wikipedia.org/wiki/Grupo_sangu%C3%ADneo";
	public static String produces = "application/json";

	public static final String msg404 = "Grupo sanguineo no encontrado";
	public static final String msg422 = "Id de grupo sanguineo inválido";
	public static final String msg500 = "Error interno del servidor";

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_1 = "/blood_groups";
	public static String endPointTitle_1 = "Grupos sanguineos paginados";
	public static String endPointReturn_1 = "Retorna un listado de grupos sanguineos";

	public static String endPointArg1Title_1 = "Desplazamiento de la lista de resultados devueltos por esta cantidad. El valor predeterminado es cero.";
	public static String endPointArg1_1 = "offset";

	public static String endPointArg2Title_1 = "Cantidad de grupos sanguineos que se recuperará. El valor predeterminado es 5, el máximo es 100.";
	public static String endPointArg2_1 = "limit";

	@ApiOperation(value = endPointTitle_1, notes = notes, response = BloodGroup.class, responseContainer = "List", tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_1, response = BloodGroup.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_1, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<List<BloodGroup>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_2 = endPointUrl_1 + "/{id}";
	public static String endPointTitle_2 = "Grupo sanguineo por id";
	public static String endPointReturn_2 = "Retorna un grupo sanguineo";

	public static String endPointArg1Title_2 = "Identificador del grupo sanguineo";
	public static String endPointArg1_2 = "id";

	@ApiOperation(value = endPointTitle_2, notes = notes, response = BloodGroup.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_2, response = BloodGroup.class),
			@ApiResponse(code = 404, message = msg404),
			@ApiResponse(code = 422, message = msg422),
			@ApiResponse(code = 500, message = msg500) })
	@RequestMapping(value = endPointUrl_2, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<BloodGroup> getById(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String id

	);

}
