package kr.or.ddit.prjct_hist.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PrjctHistVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("prjctHistDao")
public class IPrjctHistDaoImpl implements IPrjctHistDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<PrjctHistVO> prjctHistList(Map<String, String> params)
			throws Exception {
		return client.queryForList("prjctHist.prjctHistList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("prjctHist.totalCount", params);
	}

	@Override
	public List<PrjctHistVO> prjctHistPageList(Map<String, String> params)
			throws Exception {
		return client.queryForList("prjctHist.prjctHistPageList", params);
	}

	@Override
	public void insertPrjctHist(PrjctHistVO prjctHistInfo) throws Exception {
		client.insert("prjctHist.insertPrjctHist", prjctHistInfo);
	}

	@Override
	public PrjctHistVO prjctHistView(Map<String, String> params)
			throws Exception {
		return (PrjctHistVO) client.queryForObject("prjctHist.prjctHistView", params);
	}

	@Override
	public void deletePrjctHist(Map<String, String> params) throws Exception {
		client.delete("prjctHist.deletePrjctHist", params);
	}

	@Override
	public List<PrjctHistVO> prjctMemberList(Map<String, String> params)
			throws Exception {
		return client.queryForList("prjctHist.prjctMemberList",params);
	}

}
