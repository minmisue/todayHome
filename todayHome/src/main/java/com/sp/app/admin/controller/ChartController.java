package com.sp.app.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.common.APISerializer;

// 2015년 평균기온
// 서울 : -0.9,1.0,6.3,13.3,18.9,23.6,25.8,26.3,22.4,15.5,8.9,1.6
// 제주 : 7.4,7.3,10.4,15.1,18.8,22.0,25.6,26.4,23.2,19.2,15.2,10.0
// 부산 : 4.7,5.4,9.5,13.9,18.8,21.0,23.9,26.1,22.1,18.1,13.6,7.9
// 대구 : 2.3,3.8,9.2,14.6,21.7,22.9,25.0,26.0,20.6,15.8,11.0,4.5
// 광주 : 1.7,3.0,8.0,13.9,19.4,22.5,25.4,26.0,22.0,16.9,11.6,5.3
// 전주 : 1.0,2.5,7.2	,13.9,19.2,22.7,25.1,25.9,21.6,16.1,10.9,4.4
// 대전 : 0.0,1.9,7.2	,13.3,19.5,23.4,25.4,26.4,21.7,15.5,10.1,3.1
// 춘천 : -2.7,-0.3,5.5,12.3,19.1,23.4,25.0,25.6,20.4,13.7,7.9,0.0
// 철원 : -4.0,-1.3,4.0,11.3,17.6,21.6,23.8,24.1,18.9,12.3,6.6,-1.2 

/*
// highchart 에 출력하는 데이터 형식. 값은 숫자이어야함
   [{name:'이름', data:[값]}]

[{
    name: '서울',
    data: [-0.9,1.0,6.3,13.3,18.9,23.6,25.8,26.3,22.4,15.5,8.9,1.6]
}, {
    name: '제주',
    data: [7.4,7.3,10.4,15.1,18.8,22.0,25.6,26.4,23.2,19.2,15.2,10.0]
}]		
*/

@Controller("echart.chartController")
public class ChartController {
	
	@Autowired
	private APISerializer apiSerializer;
	
	@GetMapping("admin/echart/chart")
	public String main() throws Exception {
		return "admin/echart/chart";
	}
	
	@GetMapping("admin/echart/chart/line1")
	@ResponseBody
	public Map<String, Object> line1() throws Exception {
	       Map<String, Object> model = new HashMap<>();

	        List<Integer> seriesData = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200);
	        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	        model.put("year", currentYear);
	        model.put("series", seriesData);

	        return model;
	}
	
	
}
