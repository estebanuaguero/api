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
import org.yacare.model.user.UserAvaileability;

@Api(value = "guardian_users")
public interface LegalGuardianUsersApi {
	
	

	public static String tagName = "User";
	public static String notes = "Usuarios que son tutores. Tutor o Responsable Legal de Estudiantes, también llamados tutores legales, o padres.";
	public static String produces = "application/json";

	public static final String msg404 = "Objeto no encontrado";
	public static final String msg409 = "Error de negocio";
	public static final String msg422 = "Argumento inválido";
	public static final String msg500 = "Error interno del servidor";

	public static final String msg201_post = "Usuario creado";
	public static final String msg201_put = "Usuario creado";
	// public static final String msg400 = "Campos incorrectos";

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
	public static String endPointTitle_2 = "Usuario por nombre de usuario";
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
	public static String endPointReturn_3 = "Retorna un usuario";

	public static String endPointArg1Title_3 = "Usuario a dar de alta.";

	// public static String endPointArg1_3 = "user";

	@ApiOperation(value = endPointTitle_3, notes = notes, response = User.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = msg201_post, response = User.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_3, produces = { produces }, method = RequestMethod.POST)
	ResponseEntity<User> createLegalGuardianUser(

			@ApiParam(value = endPointArg1Title_3, required = true) @RequestBody User user

	) throws ApiException;

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_4 = "/guardian_users";
	public static String endPointTitle_4 = "Crear usuario";
	public static String endPointReturn_4 = "Retorna un usuario";

	public static String endPointArg1Title_4 = "Usuario a modificar.";

	// public static String endPointArg1_3 = "user";

	@ApiOperation(value = endPointTitle_4, notes = notes, response = User.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = msg201_put, response = User.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_4, produces = { produces }, method = RequestMethod.PUT)
	ResponseEntity<User> updateLegalGuardianUser(

			@ApiParam(value = endPointArg1Title_4, required = true) @RequestBody User user

	) throws ApiException;

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_5 = endPointUrl_2 + "/availeability";
	public static String endPointTitle_5 = "Disponibilidad de un Usuario verificando por nombre de usuario";
	public static String endPointReturn_5 = "Retorna un usuario";

	public static String endPointArg1Title_5 = "Nombre de usuario";
	public static String endPointArg1_5 = "user_name";

	@ApiOperation(value = endPointTitle_5, notes = notes, response = UserAvaileability.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_5, response = UserAvaileability.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_5, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<UserAvaileability> availeabilityGet(
			@ApiParam(value = endPointArg1Title_5, required = true) @PathVariable(endPointArg1_5) String userName

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_6 = endPointUrl_2 + "/tokens/{token_id}";
	public static String endPointTitle_6 = "Valida el correo electrónico del usuario.";
	public static String endPointReturn_6 = "Retorna un usuario";

	public static String endPointArg1Title_6 = "Valor del token";
	public static String endPointArg1_6 = "user_name";

	public static String endPointArg2Title_6 = "Token id. Identificador del Token.";
	public static String endPointArg2_6 = "token_id";

	public static final String msg201_6_put = "Correo electrónico (de usuario) validado";

	@ApiOperation(value = endPointTitle_6, notes = notes, response = UserAvaileability.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = msg201_6_put, response = UserAvaileability.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_6, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<UserAvaileability> checkEmailGet(
			@ApiParam(value = endPointArg1Title_6, required = true) @PathVariable(endPointArg1_6) String userName,
			@ApiParam(value = endPointArg2Title_6, required = true) @PathVariable(endPointArg2_6) String tokenId

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_7 = endPointUrl_2 + "/passwords_recovery";
	public static String endPointTitle_7 = "Recuperación de contraseña. Se envía la contraseña al correo electróinico del usuario.";
	public static String endPointReturn_7 = "Retorna un usuario";

	public static String endPointArg1Title_7 = "Nombre de usuario";
	public static String endPointArg1_7 = "user_name";

	@ApiOperation(value = endPointTitle_7, notes = notes, response = UserAvaileability.class, tags = { tagName, })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_5),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 409, message = msg409, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_7, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<UserAvaileability> passwordsRecovery(
			@ApiParam(value = endPointArg1Title_7, required = true) @PathVariable(endPointArg1_7) String userName

	);

	// ---------------------------------------------------------------------------------------

	public static String endPointUrl_8 = endPointUrl_1 + "/logins";
	public static String endPointTitle_8 = "Autenticación de usuario";
	public static String endPointReturn_8 = "Retorna un usuario";

	public static String endPointArg1Title_8 = "Nombre de usuario";
	public static String endPointArg1_8 = "user_name";

	public static String endPointArg2Title_8 = "Contraseña del usuario";
	public static String endPointArg2_8 = "password";

	@ApiOperation(value = endPointTitle_8, notes = notes, response = User.class, tags = { tagName })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = endPointReturn_8, response = User.class),
			@ApiResponse(code = 404, message = msg404, response = ApiError.class),
			@ApiResponse(code = 422, message = msg422, response = ApiError.class),
			@ApiResponse(code = 500, message = msg500, response = ApiError.class) })
	@RequestMapping(value = endPointUrl_8, produces = { produces }, method = RequestMethod.GET)
	ResponseEntity<User> login(
			@ApiParam(value = endPointArg1Title_8, required = true) @RequestParam(value = endPointArg1_8, required = true) String userName,
			@ApiParam(value = endPointArg2Title_8, required = true) @RequestParam(value = endPointArg2_8, required = true) String password

	);

	// ---------------------------------------------------------------------------------------

} // END CLASS
