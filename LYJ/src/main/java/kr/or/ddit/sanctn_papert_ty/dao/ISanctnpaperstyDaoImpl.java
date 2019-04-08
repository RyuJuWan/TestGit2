package kr.or.ddit.sanctn_papert_ty.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.SanctnPapersTyVO;

@Repository("sanctnpaperstyDao")
public class ISanctnpaperstyDaoImpl implements ISanctnpaperstyDao{
	@Autowired
	private SqlMapClient client;

	@Override
	public List<SanctnPapersTyVO> sanctnpaperstyList(Map<String, String> params)
			throws Exception {
		return client.queryForList("sanctnpapersty.sanctnpaperstyList", params);
	}
}
