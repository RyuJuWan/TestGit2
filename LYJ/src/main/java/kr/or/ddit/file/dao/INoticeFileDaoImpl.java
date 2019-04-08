package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.prpsl.dao.IPrpslDao;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PrpslFileVO;
@Repository
public class INoticeFileDaoImpl implements NoticeFileDao {
	@Autowired
	private SqlMapClient client;

	@Override
	public void insertNoticeFile(NoticeFileVO noticeFileInfo) throws Exception {
		try {
			client.startTransaction();
			client.insert("noticeFile.insertNoticeFile",noticeFileInfo);
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public List<NoticeFileVO> noticeFileList(Map<String, String> params)
			throws Exception {
		return null;
	}

	@Override
	public NoticeFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (NoticeFileVO) client.queryForObject("noticeFile.noticeFileInfo", params);
	}

	@Override
	public void updateNoticeFile(NoticeFileVO noticeFileInfo) throws Exception {
		try {
			client.startTransaction();
			client.insert("noticeFile.updateNoticeFile",noticeFileInfo);
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public int noticeFileListSize() throws Exception {
		return (int) client.queryForObject("noticeFile.noticeFileListSize");
	}


	

}
