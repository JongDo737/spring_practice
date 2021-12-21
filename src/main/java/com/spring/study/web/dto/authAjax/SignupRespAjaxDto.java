package com.spring.study.web.dto.authAjax;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupRespAjaxDto {
	private String username;
	private String password;
	private String name;
	private String email;
	
	private boolean idCheckFlag;
}
