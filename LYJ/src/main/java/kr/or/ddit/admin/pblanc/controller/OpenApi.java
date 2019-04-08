package kr.or.ddit.admin.pblanc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenApi {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			String urlstr = "http://apis.data.go.kr/1230000/BidPublicInfoService/"
					+ "getBidPblancListInfoServcPPSSrch?inqryDiv=1&inqryBgnDt=201705010000&inqryEndDt=201705012359&"
					+ "pageNo=1&numOfRows=10&"
					+ "ServiceKey=rgXeP2RFAgaf21m7ni8Inqz4sbT%2BFrKmdakTxcdWvfL5ZO0%2FVT6cs0ESA5SWpYAp4fFOZHrhSf1FxwYrpLyAuA%3D%3D";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url
					.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(
					urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
