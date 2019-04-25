package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.DeptDao;
import com.biz.iolist.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptService {

	@Autowired
	SqlSession session;
	
	/*
	 * session으로 계속 부르기 힘들기때문에
	 * 세션을 만들어서 달라는 메서드 
	 * 스프링다운 코드는 아님
	 */
	private DeptDao dDao() {
		return session.getMapper(DeptDao.class);
	}
	
	public List<DeptVO> selectAll(){
		
		log.debug("DeptService Call");
		//DeptDao dDao = session.getMapper(DeptDao.class);
		List<DeptVO> deptVO = dDao().selectAll();
		return deptVO;

	}
	
	public String getDCode() {
		
		// tbl_dept에서 가장 큰 코드값을 가져오는 부분
		String d_code = dDao().getDCode();
		String new_dcode ="D0001";
		if(d_code != null) { //null인 경우는 테이블의 값이 없을때
			
			d_code = d_code.substring(1); //1번째 문자부터 잘라라(d코드의 0099만 추출하라는코드)

			// 트림은 빈칸을 제거하는 것.
			// d_code값은 db로부터 가져온 값이어서 혹시 앞뒤에 빈칸이 있을 수 있어서
			// 빈칸을 제거
			int temp_code = Integer.valueOf(d_code.trim()) + 1; // +1을하니까 100이됨
			new_dcode =String.format("D%04d", temp_code);
			// tempcode에는 100이라는 숫자가 들어잇고 %d = (정수)숫자를 문자모양으로
			// %4d는 5자리로 만들고 (앞에 빈칸추가) %04d는 앞의 빈칸을 0으로 채워서 5개로 만들어라:0100
			// 최종 결과는 D0100이 됨.

			
			
			
		}
		return new_dcode;
	} //getDCode
	
	public String getDName(String d_code) {
		DeptVO vo = dDao().findByDCode(d_code);
		return vo.getD_name();
	}

	public int insert(DeptVO deptVO) {
		// TODO Service insert 메서드
		
		// TODO Service insert 테스트케이스
		// 조건 : session으로부터 DeptDao mapper를 추출
		// 결과 : deptDao mapper의 insert를 수행하여
		//		테이블에 데이터 저장 완료
	//	DeptDao dDao = session.getMapper(DeptDao.class);
		int ret = dDao().insert(deptVO);
		return ret;
	}

	public List<DeptVO> findByDName(String d_name) {
		// TODO Auto-generated method stub
		
		List<DeptVO> dList = dDao().findByDName(d_name);
		return dList;
	
	}
	
}
