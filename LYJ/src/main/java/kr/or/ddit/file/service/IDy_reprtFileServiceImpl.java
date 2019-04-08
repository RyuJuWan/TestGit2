package kr.or.ddit.file.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.IDy_reprtFileDao;
import kr.or.ddit.vo.ReprtFileVO;

@Service("dy_reprtFileService")
public class IDy_reprtFileServiceImpl implements IDy_reprtFileService {
	
	@Autowired
	private IDy_reprtFileDao dao;
	
	@Override
	public void insertReprtFile(ReprtFileVO reprtFileInfo) throws Exception {
		dao.insertReprtFile(reprtFileInfo);
	}

	@Override
	public ReprtFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return dao.fileItemInfo(params);
	}

}
