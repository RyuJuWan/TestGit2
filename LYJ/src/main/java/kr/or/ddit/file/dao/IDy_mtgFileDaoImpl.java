package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dy_mtg.dao.IDy_mtgDao;
import kr.or.ddit.vo.MtgFileVO;
import kr.or.ddit.vo.MtgVO;

@Repository("dy_mtgFileDao")
public class IDy_mtgFileDaoImpl implements IDy_mtgFileDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Autowired
	private IDy_mtgDao dao;
	
	@Override
	public void insertMtgFile(MtgFileVO mtgFileInfo) throws Exception {
		client.insert("mtgFile.insertMtgFile", mtgFileInfo);
	}

	@Override
	public MtgFileVO fileItemInfo(Map<String, String> params) throws Exception {
		return (MtgFileVO) client.queryForObject("mtgFile.fileItemInfo", params);
	}

	@Override
	public void updateMtgFile(MtgFileVO mtgFileInfo) throws Exception {
		client.update("mtgFile.updateMtgFile", mtgFileInfo);
	}

	@Override
	public void deleteMtgFile(Map<String, String> params) throws Exception {
		client.delete("mtgFile.deleteMtgFile", params);
		dao.deleteMtg(params);
	}
	
}
