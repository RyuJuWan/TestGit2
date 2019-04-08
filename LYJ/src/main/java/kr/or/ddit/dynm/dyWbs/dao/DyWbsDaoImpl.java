package kr.or.ddit.dynm.dyWbs.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;
@Repository
public class DyWbsDaoImpl implements IDyWbsDao {

	@Autowired
	private SqlMapClient client;
	
	@Override
	public String insertBoard(WBSVO flawInfo) throws Exception {
		return (String) client.insert("dyWbs.insertBoard", flawInfo);
	}

	@Override
	public void updateBoard(WBSVO flawInfo) throws Exception {
		client.update("dyWbs.updateBoard", flawInfo);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("dyWbs.totalCount", params);
	}

	@Override
	public List<WBSVO> boardList(Map<String, String> params) throws Exception {
		return client.queryForList("dyWbs.boardList", params);
	}

	@Override
	public WBSVO boardViewInfo(Map<String, String> params) throws Exception {
		return (WBSVO) client.queryForObject("dyWbs.boardViewInfo", params);
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("dyWbs.getPrjctName", params);
	}

	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("dyWbs.getPrjctEmpl", params);
	}

	@Override
	public List<IpcrVO> getAllIpcr() throws Exception {
		return client.queryForList("dyWbs.getAllIpcr");
	}

	@Override
	public List<SttusVO> getAllSttus() throws Exception {
		return client.queryForList("dyWbs.getAllSttus");
	}

	@Override
	public List<SmlCatVO> getSmlCat() throws Exception {
		return client.queryForList("dyWbs.getSmlCat");
	}

	@Override
	public List<WorkTyVO> getWorkTy() throws Exception {
		return client.queryForList("dyWbs.getWorkTy");
	}

	@Override
	public List<WBSVO> wbsListByPrjctID(Map<String, String> params)
			throws Exception {
		return client.queryForList("dyWbs.wbsListByPrjctID", params);
	}

	@Override
	public int wbsSttusCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("dyWbs.wbsSttusCount",params);
	}

}
