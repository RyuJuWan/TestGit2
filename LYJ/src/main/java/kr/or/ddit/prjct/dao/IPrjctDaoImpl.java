package kr.or.ddit.prjct.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PrjctVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("prjctDao")
public class IPrjctDaoImpl implements IPrjctDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<PrjctVO> prjctList() throws Exception {
		return client.queryForList("prjct.prjctList");
	}

	@Override
	public List<PrjctVO> currentPrjctList() throws Exception {
		return client.queryForList("prjct.currentPrjctList");
	}

	@Override
	public void insertProject(PrjctVO projectInfo) throws Exception {
		client.insert("prjct.insertProject",projectInfo);
	}

	@Override
	public void updateProject(PrjctVO projectInfo) throws Exception {
		client.update("prjct.updateProject", projectInfo);
	}

	@Override
	public PrjctVO projectInfo(Map<String, String> params) throws Exception {
		return (PrjctVO) client.queryForObject("prjct.projectInfo", params);
	}

}
