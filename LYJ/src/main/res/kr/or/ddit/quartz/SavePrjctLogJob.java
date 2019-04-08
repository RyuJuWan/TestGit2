package kr.or.ddit.quartz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dynm.dyRecsRoom.service.IDyRecsRoomService;
import kr.or.ddit.log.service.ILogService;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.vo.DynmRecsroomVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PrjctVO;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.quartz.JobExecutionContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class SavePrjctLogJob extends AbstractQuartzJob{
	private String path = "D:\\temp\\fileDocBase";
	
	@Override
	protected void executeJob(JobExecutionContext jobExecutionContext){
		IPrjctService prjctService = (IPrjctService) super.getBean("prjctService");
		List<PrjctVO> prjctList = null;
		try {
			prjctList = prjctService.prjctList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ILogService logService = (ILogService) super.getBean("logService");
		IDyRecsRoomService dyRecsRoomService = (IDyRecsRoomService) super.getBean("dyRecsRoomService");
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmm");
		String today = sf.format(now);
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
		String today2 = sf2.format(now);
		
		for(PrjctVO prjctInfo : prjctList){
			DataSourceTransactionManager txManager = (DataSourceTransactionManager) super.getBean("transactionMgr");
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus txStatus = txManager.getTransaction(def);
			
			Map<String, String> params = new HashMap<String, String>();
			String prjct_id = prjctInfo.getPrjct_id();
			params.put("prjct_id", prjct_id);
			
			List<LogVO> prjctLogList = null;
			try {
				
				prjctLogList = logService.prjctLogList(params);
				if(prjctLogList.size() != 0){
					
					File directory = new File(this.path);
					if(!directory.exists()) directory.mkdirs();
					
					String fileName = today + prjct_id + ".pdf";
					String filePath = this.path + "\\" + fileName;
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream(filePath));
					
					document.open();
					
					BaseFont objBaseFont = BaseFont.createFont("H2MJRE.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					Font objFont = new Font(objBaseFont, 11);
					
					document.add(new Paragraph(today2 + " " + prjct_id + " 로그", objFont));
					for(LogVO prjctLogInfo : prjctLogList){
						document.add(new Paragraph(prjctLogInfo.getLog_date()));
						document.add(new Paragraph(prjctLogInfo.getLog_empl_id()));
						document.add(new Paragraph(prjctLogInfo.getLog_cn(), objFont));
						document.add(new Paragraph("---------------------------------------------------"));
					}
					document.close();
					
					DynmRecsroomVO dyRecsRoomInfo = new DynmRecsroomVO();
					dyRecsRoomInfo.setDynm_recsroom_nm(today + " Log");
					dyRecsRoomInfo.setDynm_recsroom_empl("admin");
					dyRecsRoomInfo.setDynm_recsroom_cn("<p>" + today + "Log</p>");
					dyRecsRoomInfo.setPrjct_id(prjct_id);
					
					File file = new File(filePath);
					FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
					try {
						InputStream input = new FileInputStream(file);
						OutputStream os = fileItem.getOutputStream();
						IOUtils.copy(input, os);
					} catch (IOException e) {}
					MultipartFile logFile = new CommonsMultipartFile(fileItem);
					dyRecsRoomInfo.setFileitem(logFile);
					
					dyRecsRoomService.dyRecsRoomInsert(dyRecsRoomInfo);
				}
			} catch (Exception e) {
				txManager.rollback(txStatus);
				e.printStackTrace();
			}
			txManager.commit(txStatus);
		}
		
		DataSourceTransactionManager tsManager = (DataSourceTransactionManager) super.getBean("transactionMgr");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus tsStatus = tsManager.getTransaction(def);
		
		try {
			logService.deleteAllLog();
		} catch (Exception e) {
			tsManager.rollback(tsStatus);
			e.printStackTrace();
		}
		tsManager.commit(tsStatus);
		
	}

}
