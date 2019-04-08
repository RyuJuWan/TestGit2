package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.IHnfInptFileDao;
import kr.or.ddit.file.dao.IPrpslFileDaoImpl;
import kr.or.ddit.file.dao.PrpslFileDao;
import kr.or.ddit.prpsl.dao.IPrpslDao;
import kr.or.ddit.prpsl.dao.IPrpslDaoImpl;
import kr.or.ddit.prpsl.service.IPrpslService;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.PrpslFileVO;
@Service
public class IPrpslFileServiceImpl implements PrpslFileService {
	@Autowired
	private PrpslFileDao dao;
	
	@Override
	public PrpslFileVO fileItemInfo(Map<String, String> params) {
		PrpslFileVO prpslFileInfo = null;
		try {
			prpslFileInfo = dao.fileItemInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prpslFileInfo;
	}

	@Override
	public List<PrpslFileVO> prpslFileList(Map<String, String> params) {
		return null;
	}
	
	@Override
	public void insertPrpslFile(PrpslFileVO prpslFileInfo) {
		try {
			dao.insertPrpslFile(prpslFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int prpslFileListSize() throws Exception {
		return dao.PrpslFileListSize();
	}

	@Override
	public void updatePrpslFile(PrpslFileVO prpslFileInfo) {
		try {
			dao.updatePrpslFile(prpslFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
