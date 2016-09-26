package org.yacare.api.ex;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-12T14:42:20.090Z")
public class ApiException extends Exception {

	private static final long serialVersionUID = -2346592211202333787L;

	@SuppressWarnings("unused")
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
