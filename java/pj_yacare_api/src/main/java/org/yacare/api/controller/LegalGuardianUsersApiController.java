package org.yacare.api.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.cendra.commons.ex.AbstractGenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.yacare.MainYacare;
import org.yacare.api.LegalGuardianUsersApi;
import org.yacare.bo.user.UserBo;
import org.yacare.model.ApiError;
import org.yacare.model.user.User;
import org.yacare.model.user.UserAvaileability;

@Controller
public class LegalGuardianUsersApiController implements LegalGuardianUsersApi {

	@Autowired
	private MailSender mailSender;

	// @Value("${send.from.email}")
	// private String fromEmail;
	//
	// @Value("${send.to.email}")
	// private String toEmail;

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
	@CrossOrigin(origins = "*")
	public ResponseEntity<User> createLegalGuardianUser(
			@ApiParam(value = endPointTitle_3, required = true) @RequestBody User user

	) {

		return utilCreateLegalGuardianUser(user);
		// return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*")
	public ResponseEntity<User> updateLegalGuardianUser(
			@ApiParam(value = endPointTitle_4, required = true) @RequestBody User user

	) {

		return utilUpdateLegalGuardianUser(user);
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserAvaileability> availeabilityGet(
			@ApiParam(value = endPointArg1Title_5, required = true) @PathVariable(endPointArg1_5) String userName) {

		return utilAvaileabilityGet(userName);
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserAvaileability> checkEmailGet(
			@ApiParam(value = endPointArg1Title_6, required = true) @PathVariable(endPointArg1_6) String userName,
			@ApiParam(value = endPointArg2Title_6, required = true) @PathVariable(endPointArg2_6) String tokenId) {

		return utilCheckEmailPut(userName, tokenId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@CrossOrigin(origins = "*")
	public ResponseEntity passwordsRecovery(
			@ApiParam(value = endPointArg1Title_7, required = true) @PathVariable(endPointArg1_7) String userName

	) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			userBo.passwordsRecovery(userName);

			return new ResponseEntity<UserAvaileability>(HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@CrossOrigin(origins = "*")
	public ResponseEntity login(
			@ApiParam(value = endPointArg1Title_8, required = true) @RequestParam(value = endPointArg1_8, required = true) String userName,
			@ApiParam(value = endPointArg2Title_8, required = true) @RequestParam(value = endPointArg2_8, required = true) String password

	) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			User user = userBo.login(userName, password);

			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}
	}

	// -------------------------------------------------------------------------------

	// ================================================================================

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilGetLegalGuardianUsersByUserName(String userName) {

		try {

			UserBo userBo = new UserBo();
			userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
			userBo.setGeneralProperties(MainYacare.generalProperties);

			User user = userBo.getLegalGuardianUsersByUserName(userName);

			if (user == null) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			} else if (user.getId() == null
					|| user.getId().trim().length() == 0) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity getLegalGuardianUsers(Integer offset, Integer limit) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			List<User> users = userBo.getLegalGuardianUsers(offset, limit);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());
		}
	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilCreateLegalGuardianUser(User user) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			user = userBo.createLegalGuardianUser(user);

			return new ResponseEntity<User>(user, HttpStatus.CREATED);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilUpdateLegalGuardianUser(User user) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			user = userBo.updateLegalGuardianUser(user);

			return new ResponseEntity<User>(user, HttpStatus.CREATED);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilAvaileabilityGet(String userName) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			UserAvaileability user = userBo.userAvaileability(userName);

			return new ResponseEntity<UserAvaileability>(user, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}

	}

	// -------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	private ResponseEntity utilCheckEmailPut(String userName, String tokenId) {

		UserBo userBo = new UserBo();
		userBo.setDataSourceWrapper(MainYacare.getDataSourceWrapper());
		userBo.setMailSender(mailSender);
		userBo.setGeneralProperties(MainYacare.generalProperties);

		try {

			UserAvaileability user = userBo.updateLegalGuardianUserCheckEMail(
					userName, tokenId);

			return new ResponseEntity<UserAvaileability>(user, HttpStatus.OK);

		} catch (AbstractGenericException e) {

			ApiError apiError = new ApiError(e, this.getClass());

			return new ResponseEntity<ApiError>(apiError, apiError.httpStatus());

		}
	}

} // END CLASS
