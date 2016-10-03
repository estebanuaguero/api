package org.yacare.api.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.cendra.commons.ex.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.Swagger2SpringBoot;
import org.yacare.api.LegalGuardianUsersApi;
import org.yacare.bo.user.UserBo;
import org.yacare.model.ApiError;
import org.yacare.model.user.User;

@Controller
public class LegalGuardianUsersApiController implements LegalGuardianUsersApi {

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<User>> getList(
			@ApiParam(value = endPointArg1Title_1) @RequestParam(value = endPointArg1_1, required = false) Integer offset,
			@ApiParam(value = endPointArg2Title_1) @RequestParam(value = endPointArg2_1, required = false) Integer limit) {

		return getLegalGuardianUsers(offset, limit);
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*")
	public ResponseEntity<User> getLegalGuardianUsersByUserName(
			@ApiParam(value = endPointArg1Title_2, required = true) @PathVariable(endPointArg1_2) String userName) {

		return utilGetLegalGuardianUsersByUserName(userName);
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public ResponseEntity<User> createLegalGuardianUser(
			@ApiParam(value = endPointTitle_3, required = true) @RequestBody User user

	) {

		return utilCreateLegalGuardianUser(user);
		// return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// ================================================================================

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilGetLegalGuardianUsersByUserName(String userName) {

		try {

			UserBo userBo = new UserBo();
			userBo.setDataSourceWrapper(Swagger2SpringBoot
					.getDataSourceWrapper());

			User user = userBo.getLegalGuardianUsersByUserName(userName);

			if (user == null) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			} else if (user.getId() == null
					|| user.getId().trim().length() == 0) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (GenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity getLegalGuardianUsers(Integer offset, Integer limit) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(Swagger2SpringBoot.getDataSourceWrapper());

		try {

			List<User> users = userBo.getLegalGuardianUsers(offset, limit);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);

		} catch (GenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilCreateLegalGuardianUser(User user) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(Swagger2SpringBoot.getDataSourceWrapper());

		try {

			user = userBo.createLegalGuardianUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);

		} catch (GenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

}
