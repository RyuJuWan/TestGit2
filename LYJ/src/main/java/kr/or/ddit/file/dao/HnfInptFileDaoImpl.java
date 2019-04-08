package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.HnfInptFileVO;
@Repository
public class HnfInptFileDaoImpl implements IHnfInptFileDao {
	@Autowired
	private SqlMapClient client;
	
	/**
	* 인원투입계획서의 관련 파일의 정보를 가져오는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @return 인원투입계획서에 관련 파일 정보
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public HnfInptFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (HnfInptFileVO) client.queryForObject("hnfInptFile.hnfInptFileInfo", params);
	}
	
	@Override
	public List<HnfInptFileVO> HnfInptFileList(Map<String, String> params)
			throws Exception {
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
	public void insertHnfInptFile(HnfInptFileVO hnfInptFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.insert("hnfInptFile.insertHnfInptFile", hnfInptFileInfo);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
	}

	@Override
	public int hnfInptFileListSize() throws Exception {
		return (int) client.queryForObject("hnfInptFile.hnfInptFileListSize");
	}

	@Override
	public void updateHnfInptFile(HnfInptFileVO hnfInptFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.update("hnfInptFile.updateHnfInptFile", hnfInptFileInfo);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
	}

}
