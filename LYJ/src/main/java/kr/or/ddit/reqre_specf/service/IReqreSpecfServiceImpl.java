package kr.or.ddit.reqre_specf.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.reqre_specf.dao.IReqreSpecfDao;
import kr.or.ddit.vo.ReqreSpecfVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("reqreSpecfService")
public class IReqreSpecfServiceImpl implements IReqreSpecfService {
	
	@Autowired
	private IReqreSpecfDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertReqreSpecf(ReqreSpecfVO reqreSpecfInfo)
			throws Exception {
		return dao.insertReqreSpecf(reqreSpecfInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public String getPrjctName(Map<String, String> params)   {
		String prjctNM = null;
		try {
			prjctNM = dao.getPrjctName(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prjctNM;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public ReqreSpecfVO reqreSpecfInfo(Map<String, String> params)
			throws Exception {
		return dao.reqreSpecfInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<ReqreSpecfVO> reqreSpecfList() throws Exception {
		return dao.reqreSpecfList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateReqreSpecf(ReqreSpecfVO reqreSpecfInfo) throws Exception {
		dao.updateReqreSpecf(reqreSpecfInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public String getReqreSpecfId(Map<String, String> params) throws Exception {
		return dao.getReqreSpecfId(params);
	}
	

}
