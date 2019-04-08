package kr.or.ddit.sanctn_line.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SanctnLineVO;

public interface ISanctnlineService {
	public List<SanctnLineVO> sanctnlineList(Map<String, String> params) throws Exception;
}
