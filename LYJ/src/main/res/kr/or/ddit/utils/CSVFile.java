package kr.or.ddit.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;

@Component
public class CSVFile {
	public void createCSV(List<Map<String, Object>> nounList, String mtg_id, String filepath){
		try {
			CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(filepath + "\\" + mtg_id + ".csv"), "EUC-KR"), ',', '"');
			try {
				for(Map<String, Object> map : nounList){
					cw.writeNext(new String[] {String.valueOf(map.get("noun")), String.valueOf(map.get("frequency"))});
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeCSV(List<Map<String, Object>> nounList, String mtg_id, String filepath){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath + "\\" + mtg_id + ".csv", true));
			
			for(Map<String, Object> map : nounList){
				bw.write(String.valueOf(map.get("noun")) + "," + String.valueOf(map.get("frequency")));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
