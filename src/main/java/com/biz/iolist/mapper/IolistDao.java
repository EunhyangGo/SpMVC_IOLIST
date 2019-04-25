package com.biz.iolist.mapper;

import java.util.List;

import com.biz.iolist.model.IoDTO;
import com.biz.iolist.model.IoListVO;

public interface IolistDao {

	public List<IoListVO> selectAll();
	public List<IoDTO> iolistJoin();
	public IoListVO findById(long io_id);
	public int insert(IoListVO iolistVO);
	public int update(IoListVO iolistVO);
	public int delete(long io_id);
	
}
