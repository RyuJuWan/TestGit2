package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.ExpndtrAnactFileDao;
import kr.or.ddit.vo.ExpndtrAnactFileVO;

@Service
public class IExpndtrAnactFileServiceImpl implements ExpndtrAnactFileService{
	@Autowired
	private ExpndtrAnactFileDao dao;
	
	@Override
	public void insertExpFile(ExpndtrAnactFileVO ExpFileInfo)  {
		try {
			dao.insertExpFile(ExpFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ExpndtrAnactFileVO> expFileList(Map<String, String> params)
			throws Exception {
		return null;
	}

	@Override
	public ExpndtrAnactFileVO fileItemInfo(Map<String, String> params) {
		ExpndtrAnactFileVO expFileInfo = null;
		try {
			expFileInfo = dao.fileItemInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expFileInfo;
	}

	@Override
	public void updateExpFile(ExpndtrAnactFileVO expndFileInfo) {
		try {
			dao.updateExpFile(expndFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int expFileListSize() throws Exception {
		return dao.expFileListSize();
	}

}
