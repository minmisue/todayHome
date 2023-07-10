package com.sp.app.admin.controller;

import java.util.ArrayList;
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

@Controller("admin.controller.chartController")
@RequestMapping("/admin/echart/*")
public class ChartController {
	
	@Autowired
	private APISerializer apiSerializer;
	
	@RequestMapping(value="chart")
	public String main() throws Exception {
		return ".admin.echart.chart";
	}
	
	@RequestMapping(value="line1")
	@ResponseBody
	public Map<String, Object> line1() throws Exception {
		Map<String, Object> model = new HashMap<>();
		
		/*
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map;
		map = new HashMap<>();
		map.put("type", "line");
		map.put("data", new double[]{-0.9,1.0,6.3,13.3,18.9,23.6,25.8,26.3,22.4,15.5,8.9,1.6});

		list.add(map);
		
		model.put("series", list); // 차트를 작성할 연속된 값(시어리즈 값)
		*/
		
		List<Double> list = new ArrayList<>();
		list.add(-0.9);
		list.add(1.0);
		list.add(6.3);
		list.add(13.3);
		list.add(18.9);
		list.add(23.6);
		list.add(25.8);
		list.add(26.3);
		list.add(22.4);
		list.add(15.5);
		list.add(8.9);
		list.add(1.6);
		
		model.put("list", list);
		
		return model;
	}
	
	@RequestMapping(value="line2")
	@ResponseBody
	public Map<String, Object> line2() throws Exception {
		Map<String, Object> model = new HashMap<>();
		
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map;
		
		map = new HashMap<>();
		map.put("name", "서울");
		map.put("type", "line");
		map.put("data", new double[]{-0.9,1.0,6.3,13.3,18.9,23.6,25.8,26.3,22.4,15.5,8.9,1.6});
		list.add(map);

		map = new HashMap<>();
		map.put("name", "부산");
		map.put("type", "line");
		map.put("data", new double[]{4.7,5.4,9.5,13.9,18.8,21.0,23.9,26.1,22.1,18.1,13.6,7.9});
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "제주");
		map.put("type", "line");
		map.put("data", new double[]{7.4,7.3,10.4,15.1,18.8,22.0,25.6,26.4,23.2,19.2,15.2,10.0});
		list.add(map);

		map = new HashMap<>();
		map.put("name", "철원");
		map.put("type", "line");
		map.put("data", new double[]{-4.0,-1.3,4.0,11.3,17.6,21.6,23.8,24.1,18.9,12.3,6.6,-1.2});
		list.add(map);
		
		model.put("year", "2015");
		model.put("legend", new String[] {"서울","부산","제주","철원"});
		model.put("series", list);
		
		return model;
	}

	@RequestMapping(value="bar")
	@ResponseBody
	public Map<String, Object> bar() throws Exception {
		Map<String, Object> model = new HashMap<>();
		
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map;
		
		map = new HashMap<>();
		map.put("name", "서울");
		map.put("type", "bar");
		map.put("data", new double[]{-0.9,1.0,6.3,13.3,18.9,23.6,25.8,26.3,22.4,15.5,8.9,1.6});
		list.add(map);

		map = new HashMap<>();
		map.put("name", "부산");
		map.put("type", "bar");
		map.put("data", new double[]{4.7,5.4,9.5,13.9,18.8,21.0,23.9,26.1,22.1,18.1,13.6,7.9});
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "제주");
		map.put("type", "bar");
		map.put("data", new double[]{7.4,7.3,10.4,15.1,18.8,22.0,25.6,26.4,23.2,19.2,15.2,10.0});
		list.add(map);

		map = new HashMap<>();
		map.put("name", "철원");
		map.put("type", "bar");
		map.put("data", new double[]{-4.0,-1.3,4.0,11.3,17.6,21.6,23.8,24.1,18.9,12.3,6.6,-1.2});
		list.add(map);
		
		model.put("year", "2015");
		model.put("legend", new String[] {"서울","부산","제주","철원"});
		model.put("series", list);
		
		return model;
	}

	// produces : response의 Content-Type
	@RequestMapping(value="pie", produces="application/json; charset=utf-8")
	@ResponseBody
	public String pie() throws Exception {
		JSONArray jarr = new JSONArray();
		
		JSONObject job;
		
		job = new JSONObject();
		job.put("name", "07-10시");
		job.put("value", 10);
		jarr.put(job);
		
		job = new JSONObject();
		job.put("name", "10-13시");
		job.put("value", 30);
		jarr.put(job);

		job = new JSONObject();
		job.put("name", "13-16시");
		job.put("value", 33);
		jarr.put(job);

		job = new JSONObject();
		job.put("name", "16-19시");
		job.put("value", 20);
		jarr.put(job);

		job = new JSONObject();
		job.put("name", "기타");
		job.put("value", 10);
		jarr.put(job);

		return jarr.toString();
	}
	
	@GetMapping("covid")
	@ResponseBody
	public Map<String, Object> covid(@RequestParam String date) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();

		try {
			int numOfRows = 20;
			int pageNo = 1;

			String serviceKey = "GNYU2di1omxpwoiWQI6NdVOstbv1N1TLQ5Lq3h9jbY71TeXkYGpe7tU3P6UNHXu1fyWLK%2FU7pjAYZKOe%2F2fvTQ%3D%3D";
			String spec = "http://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api";
			spec += "?serviceKey=" + serviceKey + "&numOfRows=" + numOfRows + "&pageNo=" + pageNo;
			spec += "&std_day=" + date + "&apiType=JSON";
			
			String result = apiSerializer.receiveToString(spec);
			
			JSONObject job = new JSONObject(result);
			JSONArray items = job.getJSONArray("items");
			
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			String stdDay, gubun;
			double incDec;
			for(int i = 0; i< items.length(); i++) {
				JSONObject ob = items.getJSONObject(i);
				
				if(i == 0) {
					stdDay = ob.getString("stdDay");
					model.put("stdDay", stdDay);
				}
				
				gubun = ob.getString("gubun");
				incDec = ob.getDouble("incDec");
				
				if(! gubun.equals("합계")) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("gubun", gubun);
					map.put("incDec", incDec);
					list.add(map);
				}
			}
			
			model.put("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
}
