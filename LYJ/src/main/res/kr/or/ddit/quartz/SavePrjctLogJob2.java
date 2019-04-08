package kr.or.ddit.quartz;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.or.ddit.pblanc.service.IpblancService;

import org.quartz.JobExecutionContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import kr.or.ddit.vo.PblancVO;

@Component
public class SavePrjctLogJob2 extends AbstractQuartzJob {

	@Override
	protected void executeJob(JobExecutionContext jobExecutionContext) {

		IpblancService pblancService = (IpblancService) super
				.getBean("pblancService");
		PblancVO pblancInfo = new PblancVO();

		int page = 1; // 페이지 초기값
		DataSourceTransactionManager txManager = (DataSourceTransactionManager) super
				.getBean("transactionMgr");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			while (true) {
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://apis.data.go.kr/1230000/BidPublicInfoService/"
						+ "getBidPblancListInfoServcPPSSrch?inqryDiv=1&inqryBgnDt=201705010000&inqryEndDt=201705012359&"
						+ "pageNo=1&numOfRows=10&"
						+ "ServiceKey=rgXeP2RFAgaf21m7ni8Inqz4sbT%2BFrKmdakTxcdWvfL5ZO0%2FVT6cs0ESA5SWpYAp4fFOZHrhSf1FxwYrpLyAuA%3D%3D";

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);

				// root tag
				doc.getDocumentElement().normalize();
				System.out.println("Root element :"
						+ doc.getDocumentElement().getNodeName());

				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

				for (int temp = 0; temp < nList.getLength(); temp++) {
					
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						System.out.println("######################");
						// System.out.println(eElement.getTextContent());
						System.out.println("공고명  : "
								+ getTagValue("bidNtceNm", eElement));
						System.out.println("공고기관  : "
								+ getTagValue("ntceInsttNm", eElement));
						System.out.println("공고링크 : "
								+ getTagValue("bidNtceDtlUrl", eElement));
						System.out.println("예산  : "
								+ getTagValue("presmptPrce", eElement));

						pblancInfo.setPblanc_nm(getTagValue("bidNtceNm",
								eElement));
						pblancInfo.setPblanc_instt(getTagValue("ntceInsttNm",
								eElement));
						pblancInfo.setPblanc_link(getTagValue("bidNtceDtlUrl",
								eElement));
						pblancInfo.setPblanc_budget(getTagValue("presmptPrce",
								eElement));
						pblancInfo.setPblanc_clos("19/05/23");
						pblancInfo.setPblanc_bid("입찰자격");

					} // for end
					pblancService.pblancInsert(pblancInfo);
				} // if end

				page += 1;
				System.out.println("page number : " + page);
				if (page > 1) {
					break;
				}
			} // while end

		} catch (Exception e) {
			txManager.rollback(txStatus);
			e.printStackTrace();
		} // try~catch end
		txManager.commit(txStatus);

		DataSourceTransactionManager tsManager = (DataSourceTransactionManager) super
				.getBean("transactionMgr");
		DefaultTransactionDefinition deft = new DefaultTransactionDefinition();
		deft.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus tsStatus = tsManager.getTransaction(deft);

		try {
			pblancService.pblancAll();
		} catch (Exception e) {
			tsManager.rollback(tsStatus);
			e.printStackTrace();
		}
		tsManager.commit(tsStatus);

	
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}
}
