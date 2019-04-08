package kr.or.ddit.prpsl.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.PrpslVO;

@Repository("prpslDao")
public class IPrpslDaoImpl implements IPrpslDao {

	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<PrpslVO> prpslList(Map<String, String> params) throws Exception {
		
		return (List<PrpslVO>) client.queryForList("prpsl.prpslList",params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("prpsl.totalCount",params);
	}

	@Override
	public PrpslVO prpsInfo(Map<String, String> param) throws Exception {
		return (PrpslVO) client.queryForObject("prpsl.prpslInfo",param);
	}

	@Override
	public void prpslModify(PrpslVO prpslInfo) throws Exception {
		client.update("prpsl.prpslModify",prpslInfo);
		
	}

	@Override
	public void deletePrpsl(Map<String, String> params) throws Exception {
		client.delete("prpsl.prpslDelete",params);
	}

	@Override
	public void prpslInsert(PrpslVO prpslInfo) throws Exception {
		client.insert("prpsl.prpslInsert", prpslInfo);
	}

	@Override
	public List<PrpslVO> getPrpslId()
			throws Exception {
		return client.queryForList("prpsl.getPrpslId");
	}

}
