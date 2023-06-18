package com.sp.app.common;

import java.util.List;
import java.util.Map;

public interface CommonDAO {
	int insertData(String id, Object value) throws Exception;
	int insertData(String id) throws Exception;
	
	int updateData(String id, Object value) throws Exception;
	int updateData(String id) throws Exception;
	
	int deleteData(String id, Object value) throws Exception;
	int deleteData(String id) throws Exception;
	
	<T> List<T> selectList(String id, Object value) throws Exception;
	<T> List<T> selectList(String id) throws Exception;
	
	<T> T selectOne(String id, Object value) throws Exception;
	<T> T selectOne(String id) throws Exception;
	
	// INSERT, UPDATE, DELETE 프로시져(IN)
	void callUpdateProcedure(String id, Object value) throws Exception;
	
	// SELECT(OUT)
	<T> Map<String, T> callSelectOneProcedureMap(String id, Map<String, T> map) throws Exception;
	<T> Map<String, T> callSelectListProcedureMap(String id, Map<String, T> map) throws Exception;
}
