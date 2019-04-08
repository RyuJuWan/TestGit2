package kr.or.ddit.dy_mtg.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.MtgVO;

@Repository("dy_mtgDao")
public class IDy_mtgDaoImpl implements IDy_mtgDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("mtg.totalCount", params);
	}

	@Override
	public List<MtgVO> mtgPageList(Map<String, String> params) throws Exception {
		return client.queryForList("mtg.mtgPageList", params);
	}

	@Override
	public String insertDy_mtg(MtgVO mtgInfo) throws Exception {
		return (String) client.insert("mtg.insertDy_mtg", mtgInfo);
	}

	@Override
	public MtgVO mtgView(Map<String, String> params) throws Exception {
		return (MtgVO) client.queryForObject("mtg.mtgView", params);
	}

	@Override
	public void updateDy_mtg(MtgVO mtgInfo)
			throws Exception {
		client.update("mtg.updateDy_mtg", mtgInfo);
	}

	@Override
	public void deleteMtg(Map<String, String> params) throws Exception {
		client.delete("mtg.deleteMtg", params);
	}

}
