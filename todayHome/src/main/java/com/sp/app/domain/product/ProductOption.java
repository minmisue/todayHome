package com.sp.app.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductOption {
	private String mainOption;
	private List<String> subOption;
}
