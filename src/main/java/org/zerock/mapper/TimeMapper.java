package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	
	public String getTime2();
}

// 	클래스 로딩
// 	커넥션 열고
// 	statement 얻고
// 	query 실행

//	SELECT sysdate FROM dual

// 	resultSet처리
//	커넥션 닫고
