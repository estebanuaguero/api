package org.yacare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.cendra.commons.model.infodebug.error.ErrorInfo;
import org.springframework.http.HttpStatus;

/**
 * API Error
 */
@ApiModel(description = "API Error")
public class ApiError extends ErrorInfo {

	@SuppressWarnings("rawtypes")
	public ApiError(Exception exception, Class clazz) {
		super(exception, clazz);
	}

	/**
	 * Get httpStatus
	 *
	 * @return httpStatus
	 **/
	@ApiModelProperty(value = "")
	public HttpStatus httpStatus() {

		if (this.getCode() == 422) {
			return HttpStatus.UNPROCESSABLE_ENTITY;
		} else if (this.getCode() == 404) {
			return HttpStatus.NOT_FOUND;
		} else if (this.getCode() == 409) {
			return HttpStatus.CONFLICT;
		}

		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
