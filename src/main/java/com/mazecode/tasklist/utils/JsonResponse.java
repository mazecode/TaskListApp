package com.mazecode.tasklist.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class JsonResponse
 *
 * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class JsonResponse {
	@Builder.Default
	@JsonProperty
	private Object data = null;
	@Builder.Default
	@JsonProperty
	private HttpStatus code = HttpStatus.OK;
	@Builder.Default
	@JsonProperty
	private String status = HttpStatus.OK.toString();
	@Builder.Default
	@JsonProperty
	private List<String> messages = new ArrayList<>();
	@Builder.Default
	@JsonProperty
	private boolean error = false;

	/**
	 * @param message Message
	 *
	 * @return JsonResponse
	 */
	public JsonResponse addMessage(String message) {
		this.messages.add(message);
		return this;
	}

	/**
	 *
	 */
	public void clearMessages() {
		this.messages = new ArrayList<>();
	}

	/**
	 *
	 * @param code
	 */
	public void errorTrue(HttpStatus code) {
		this.errorTrue();
		this.setCode(code);
	}

	/**
	 *
	 */
	public void errorTrue() {
		this.error = true;
		this.code = HttpStatus.CONFLICT;
		this.status = HttpStatus.CONFLICT.toString();
	}

	/**
	 *
	 * @param code
	 */
	public void setCode(HttpStatus code) {
		this.code = code;
		this.status = code.toString();
	}
}
