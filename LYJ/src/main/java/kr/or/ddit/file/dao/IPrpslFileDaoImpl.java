package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.prpsl.dao.IPrpslDao;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.PrpslFileVO;
@Repository
public class IPrpslFileDaoImpl implements PrpslFileDao {
	@Autowired
	private SqlMapClient client;
	
	@Override
	public PrpslFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (PrpslFileVO) client.queryForObject("prpslFile.prpslFileInfo", params);
	}
	
	@Override
	public List<PrpslFileVO> PrpslFileList(Map<String, String> params)
			throws Exception {
		return null;
	}
	
	@Override
	public void insertPrpslFile(PrpslFileVO prpslFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.insert("prpslFile.insertPrpslFile", prpslFileInfo);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
	}

	@Override
	public int PrpslFileListSize() throws Exception {
		return (int) client.queryForObject("prpslFile.prpslFileListSize");
	}

	@Override
	public void updatePrpslFile(PrpslFileVO prpslFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.update("prpslFile.updatePrpslFile", prpslFileInfo);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
	}

}
