package org.yacare.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.api.ex.ApiException;
import org.yacare.model.ApiError;
import org.yacare.model.user.User;

@Api(value = "guardian_users")
public interface LegalGuardianUsersApi {

	public static String tagName = "User";
	public static String notes = "Usuarios que son tutores. Tutor o Responsable Legal de Estudiantes, también llamados tutores legales, o padres.";
	public static String produces = "application/json";

	public static final String msg404 = "Usuario no encontrado";
	public static final String msg422 = "Id de usuario inválido";
	public static final String msg500 = "Error interno del servidor";

	public static final String msg201 = "Usuario creado";
	public static final String msg400 = "Campos incorrectos";

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_1 = "/guardian_users";
	public static String endPointTitle_1 = "Usuarios paginados";
	public static String endPointReturn_1 = "Retorna un listado de usuarios";

	public static String endPointArg1Title_1 = "Desplazamiento de la lista de resultados devueltos por esta cantidad. El valor predeterminado es cero.";
	public static String endPointArg1_1 = "offset";

	public static String endPointArg2Title_1 = "Cantidad de usuarios que se recuperará. El valor predeterminado es 5, el máximo es 100.";
	public static String endPointArg2_1 = "limit";

	@ApiOperation(value = endPointTitle_1, notes = notes, response = User.class, responseContainer = "List", tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_1, response = User.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_1, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<List<User>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_2 = endPointUrl_1 + "/{user_name}";
	public static String endPointTitle_2 = "Usuario por user name";
	public static String endPointReturn_2 = "Retorna un usuario";

	public static String endPointArg1Title_2 = "Nombre de usuario";
	public static String endPointArg1_2 = "user_name";

	@ApiOperation(value = endPointTitle_2, notes = notes, response = User.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_2, response = User.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_2, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<User> getLegalGuardianUsersByUserName(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String userName

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_3 = "/guardian_users";
	public static String endPointTitle_3 = "Crear usuario";
	public static String endPointReturn_3 = "Retorna un listado de usuarios";

	public static String endPointArg1Title_3 = "Usuario a dar de alta.";

	// public static String endPointArg1_3 = "user";

	@ApiOperation(value = endPointTitle_3, notes = notes, response = User.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = msg201, response = User.class),
			@ApiResponse(code = 400, message = msg400, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 409, message = msg404, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_3, produces = { produces }, method = RequestMethod.POST)
	ResponseEntity<User> createLegalGuardianUser(

			@ApiParam(value = endPointArg1Title_3, required = true) @RequestBody User user

	) throws ApiException;

}
