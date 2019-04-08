package kr.or.ddit.pblanc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PblancVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("pblancDao")
public class IpblancDaoImpl implements IpblancDao{

		@Autowired
		private SqlMapClient client;
		
		@Override
		public List<PblancVO> pblancList(Map<String, String> params) throws Exception {
			
			return (List<PblancVO>) client.queryForList("pblanc.pblancList",params);
		}

		@Override
		public int totalCount(Map<String, String> params) throws Exception {
			return (int) client.queryForObject("pblanc.totalCount",params);
		}

		@Override
		public PblancVO pblancInfo(Map<String, String> param) throws Exception {
			return (PblancVO) client.queryForObject("pblanc.pblancInfo",param);
		}

		@Override
		public void pblancModify(PblancVO pblancInfo) throws Exception {
			client.update("pblanc.pblancModify",pblancInfo);
			
		}

		@Override
		public void deletePblanc(Map<String, String> params) throws Exception {
			client.delete("pblanc.pblancDelete",params);
		}

		@Override
		public void pblancInsert(PblancVO pblancInfo) throws Exception {
			client.insert("pblanc.pblancInsert",pblancInfo);
			
		}

		@Override
		public void pblancAll() throws Exception {
				client.delete("pblanc.pblancAll");
		}
}
