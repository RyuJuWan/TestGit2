package kr.or.ddit.pblanc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pblanc.dao.IpblancDao;
import kr.or.ddit.vo.PblancVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("pblancService")
public class IpblancServiceImpl implements IpblancService {

		@Autowired
		private IpblancDao dao;
		
		@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
		@Override
		public List<PblancVO> pblancList(Map<String, String> params) throws Exception {
			List<PblancVO> pblancList =null;
			pblancList =(List<PblancVO>) dao.pblancList(params);
			return pblancList;
		}

		@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
		@Override
		public int totalCount(Map<String, String> params) throws Exception {
			int totalCount=0;
			totalCount=dao.totalCount(params);
			return totalCount;
		}

		@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
		@Override
		public PblancVO pblancInfo(Map<String, String> param) throws Exception {
			PblancVO pblancInfo =null;
			pblancInfo = dao.pblancInfo(param);
			
			return pblancInfo;
		}

		@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@Override
		public void pblancModify(PblancVO pblancInfo) throws Exception {
			dao.pblancModify(pblancInfo);
		}

		@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@Override
		public void deletePblanc(Map<String, String> params) throws Exception {
			dao.deletePblanc(params);
		}

		@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@Override
		public void pblancInsert(PblancVO pblancInfo) throws Exception {
			dao.pblancInsert(pblancInfo);
			
		}

		@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@Override
		public void pblancAll() throws Exception {
			dao.pblancAll();
			
		}
}
