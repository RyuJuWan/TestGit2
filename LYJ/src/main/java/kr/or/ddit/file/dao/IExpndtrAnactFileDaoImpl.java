package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ExpndtrAnactFileVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IExpndtrAnactFileDaoImpl implements ExpndtrAnactFileDao{
	
	@Autowired
	private SqlMapClient client;

	@Override
	public void insertExpFile(ExpndtrAnactFileVO ExpFileInfo) throws Exception {
		try {
			client.startTransaction();
			client.insert("expndtrAnactFile.insertExpFile",ExpFileInfo);
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public List<ExpndtrAnactFileVO> expFileList(Map<String, String> params)
			throws Exception {
		return null;
	}

	@Override
	public ExpndtrAnactFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (ExpndtrAnactFileVO) client.queryForObject("expndtrAnactFile.expFileInfo",params);
	}

	@Override
	public void updateExpFile(ExpndtrAnactFileVO expndFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.insert("expndtrAnactFile.updateExnFile",expndFileInfo);
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public int expFileListSize() throws Exception {
		return (int) client.queryForObject("expndtrAnactFile.expFileListSize");
	}
	
}
