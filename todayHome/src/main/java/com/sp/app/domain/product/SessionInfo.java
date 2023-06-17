package com.sp.app.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class SessionInfo {
	private Long memberId;
	private String userNickname;
	private Long userRole;
}
