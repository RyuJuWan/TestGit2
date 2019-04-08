package kr.or.ddit.file.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dy_reprt.dao.IDy_reprtDao;
import kr.or.ddit.vo.ReprtFileVO;

@Repository("dy_reprtFileDao")
public class IDy_reprtFileDaoImpl implements IDy_reprtFileDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Autowired
	private IDy_reprtDao dao;
	
	@Override
	public void insertReprtFile(ReprtFileVO reprtFileInfo) throws Exception {
		client.insert("reprtFile.insertReprtFile", reprtFileInfo);
	}

	@Override
	public ReprtFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (ReprtFileVO) client.queryForObject("reprtFile.fileItemInfo", params);
	}

	@Override
	public void updateReprtFile(ReprtFileVO reprtFileInfo) throws Exception {
		client.update("reprtFile.updateReprtFile", reprtFileInfo);
	}

	@Override
	public void deleteReprtFile(Map<String, String> params) throws Exception {
		client.delete("reprtFile.deleteReprtFile", params);
		dao.deleteReprt(params);
	}

}
