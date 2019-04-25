package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.IolistDao;
import com.biz.iolist.model.IoDTO;
import com.biz.iolist.model.IoListVO;

@Service
public class IolistService {

	@Autowired
	SqlSession session;
	
	private IolistDao iDao() {
		return session.getMapper(IolistDao.class);
	}
	public List<IoListVO> selectAll() {
		//IolistDao iDao = session.getMapper(IolistDao.class);
		List<IoListVO> io_list = iDao().selectAll();
		return io_list;
	}
	public List<IoDTO> selectJoin(){
		List<IoDTO> io_list = iDao().iolistJoin();
		return io_list;
		
	}
	public int insert(IoListVO iolistVO) {
		//IolistDao iDao = session.getMapper(IolistDao.class);
		int ret = iDao().insert(iolistVO);
		return ret;
	}

	public IoListVO findById(long io_id) {
		//IolistDao iDao = session.getMapper(IolistDao.class);
		IoListVO vo = iDao().findById(io_id);
		return vo;
	}

	public int update(IoListVO iolistVO) {
		//IolistDao iDao = session.getMapper(IolistDao.class);
		int ret = iDao().update(iolistVO);
		return ret;
	}
}
