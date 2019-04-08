package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.IHnfInptFileDao;
import kr.or.ddit.vo.HnfInptFileVO;
@Service
public class HnfInptFileServiceImpl implements IHnfInptFileService {
	@Autowired
	private IHnfInptFileDao dao;
	
	/**
	* 인원투입계획서의 관련 파일의 정보를 가져오는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @return 가져온 인원투입계획세의 관련 파일들의 정보
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public HnfInptFileVO fileItemInfo(Map<String, String> params) {
		HnfInptFileVO hnfInptFileInfo = null;
		try {
			hnfInptFileInfo = dao.fileItemInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hnfInptFileInfo;
	}

	@Override
	public List<HnfInptFileVO> HnfInptFileList(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	* 인원투입계획서의 관련 파일을 추가하는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public void insertHnfInptFile(HnfInptFileVO hnfInptFileInfo) {
		try {
			dao.insertHnfInptFile(hnfInptFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hnfInptFileListSize() throws Exception {
		return dao.hnfInptFileListSize();
	}

	@Override
	public void updateHnfInptFile(HnfInptFileVO hnfInptFileInfo) {
		try {
			dao.updateHnfInptFile(hnfInptFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
