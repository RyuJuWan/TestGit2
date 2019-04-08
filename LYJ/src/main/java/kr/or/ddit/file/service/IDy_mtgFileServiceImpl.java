package kr.or.ddit.file.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.IDy_mtgFileDao;
import kr.or.ddit.vo.MtgFileVO;

@Service("dy_mtgFileService")
public class IDy_mtgFileServiceImpl implements IDy_mtgFileService {
	
	@Autowired
	private IDy_mtgFileDao dao;
	
	@Override
	public void insertMtgFile(MtgFileVO mtgFileInfo) throws Exception {
		dao.insertMtgFile(mtgFileInfo);
	}

	@Override
	public MtgFileVO fileItemInfo(Map<String, String> params) throws Exception {
		return dao.fileItemInfo(params);
	}

}
