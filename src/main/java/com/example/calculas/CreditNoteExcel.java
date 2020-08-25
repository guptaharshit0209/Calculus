/*     */ package com.example.calculas;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*     */ import org.apache.poi.ss.usermodel.PrintOrientation;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFFont;
/*     */ import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ public class CreditNoteExcel {
/*  21 */   static int CDExcelNo = 1;
/*  22 */   double CDTotal = 0.0D;
/*  23 */   double DNTotal = 0.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   public int ListToExcel(ArrayList<CashDiscount> CRDNList) {
/*  28 */     XSSFWorkbook workbook = new XSSFWorkbook();
/*  29 */     XSSFSheet s = workbook.createSheet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     XSSFCellStyle style1 = workbook.createCellStyle();
/*  36 */     XSSFFont font1 = workbook.createFont();
/*  37 */     font1.setBold(true);
/*  38 */     font1.setFontHeightInPoints((short)14);
/*  39 */     style1.setFont((Font)font1);
/*  40 */     style1.setAlignment(HorizontalAlignment.CENTER);
/*     */ 
/*     */     
/*  43 */     XSSFCellStyle style2 = workbook.createCellStyle();
/*  44 */     XSSFFont font2 = workbook.createFont();
/*  45 */     font2.setBold(true);
/*  46 */     font2.setFontHeightInPoints((short)12);
/*  47 */     style2.setFont((Font)font2);
/*  48 */     style2.setAlignment(HorizontalAlignment.CENTER);
/*     */ 
/*     */ 
/*     */     
/*  52 */     XSSFCellStyle style3 = workbook.createCellStyle();
/*  53 */     XSSFFont font3 = workbook.createFont();
/*  54 */     font3.setBold(false);
/*  55 */     font3.setFontHeightInPoints((short)10);
/*  56 */     style3.setFont((Font)font3);
/*  57 */     style3.setAlignment(HorizontalAlignment.CENTER);
/*     */ 
/*     */ 
/*     */     
/*  61 */     XSSFCellStyle style4 = workbook.createCellStyle();
/*  62 */     XSSFFont font4 = workbook.createFont();
/*  63 */     font4.setBold(true);
/*  64 */     font4.setFontHeightInPoints((short)10);
/*  65 */     style4.setFont((Font)font4);
/*  66 */     style4.setAlignment(HorizontalAlignment.LEFT);
/*  67 */     style4.setBorderBottom(BorderStyle.THICK);
/*  68 */     style4.setBorderTop(BorderStyle.THIN);
/*  69 */     style4.setBorderLeft(BorderStyle.THIN);
/*  70 */     style4.setBorderRight(BorderStyle.THIN);
/*  71 */     style4.setWrapText(true);
/*     */ 
/*     */ 
/*     */     
/*  75 */     XSSFCellStyle style5 = workbook.createCellStyle();
/*  76 */     XSSFFont font5 = workbook.createFont();
/*  77 */     font5.setBold(false);
/*  78 */     font5.setFontHeightInPoints((short)10);
/*  79 */     style5.setFont((Font)font5);
/*  80 */     style5.setBorderBottom(BorderStyle.THIN);
/*  81 */     style5.setBorderLeft(BorderStyle.THIN);
/*  82 */     style5.setBorderRight(BorderStyle.THIN);
/*     */ 
/*     */     
/*  85 */     XSSFCellStyle style6 = workbook.createCellStyle();
/*  86 */     XSSFFont font6 = workbook.createFont();
/*  87 */     font6.setBold(false);
/*  88 */     font6.setFontHeightInPoints((short)10);
/*  89 */     style6.setFont((Font)font6);
/*  90 */     style6.setAlignment(HorizontalAlignment.LEFT);
/*     */ 
/*     */ 
/*     */     
/*  94 */     XSSFCellStyle style7 = workbook.createCellStyle();
/*  95 */     XSSFFont font7 = workbook.createFont();
/*  96 */     font7.setBold(true);
/*  97 */     font7.setFontHeightInPoints((short)10);
/*  98 */     style7.setFont((Font)font7);
/*     */     
/* 100 */     s.addMergedRegion(new CellRangeAddress(1, 1, 0, 13));
/* 101 */     XSSFRow xSSFRow1 = s.createRow(1);
/* 102 */     Cell cShopName = xSSFRow1.createCell(0);
/* 103 */     cShopName.setCellValue("Manish Traders Ahirkheda 20-21");
/* 104 */     cShopName.setCellStyle((CellStyle)style1);
/*     */     
/* 106 */     s.addMergedRegion(new CellRangeAddress(3, 3, 0, 13));
/* 107 */     XSSFRow xSSFRow2 = s.createRow(3);
/* 108 */     Cell cledgerName = xSSFRow2.createCell(0);
/* 109 */     cledgerName.setCellValue(ExcelExtraction.ledgerName);
/* 110 */     cledgerName.setCellStyle((CellStyle)style2);
/*     */     
/* 112 */     s.addMergedRegion(new CellRangeAddress(4, 4, 0, 13));
/* 113 */     XSSFRow xSSFRow3 = s.createRow(4);
/* 114 */     Cell creportType = xSSFRow3.createCell(0);
/* 115 */     creportType.setCellValue("DETAILED CASH DISCOUNT / INTEREST REPORT");
/* 116 */     creportType.setCellStyle((CellStyle)style3);
/*     */     
/* 118 */     s.addMergedRegion(new CellRangeAddress(5, 5, 0, 13));
/* 119 */     XSSFRow xSSFRow4 = s.createRow(5);
/* 120 */     Cell cdateRange = xSSFRow4.createCell(0);
/* 121 */     cdateRange.setCellValue("(" + ExcelExtraction.dateRange + ")");
/* 122 */     cdateRange.setCellStyle((CellStyle)style3);
/*     */     
/* 124 */     s.setColumnWidth(0, 3000);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     String[] tableHeader = { "Receipt Date", "Receipt No", "Receipt Parti.", "Receipt Amount", "Receipt Remains", 
/* 130 */         "Invoice Date", "Invoice No", "Invoice Parti.", "Invoice Amount", "Invoice Remains", 
/* 131 */         "Payment Received(in Days)", "CD Percent(%)", "CD Amount" };
/*     */     
/* 133 */     XSSFRow xSSFRow5 = s.createRow(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     Cell cell80 = xSSFRow5.createCell(0);
/* 143 */     cell80.setCellValue("Receipt Date");
/* 144 */     cell80.setCellStyle((CellStyle)style4);
/*     */     
/* 146 */     Cell cell81 = xSSFRow5.createCell(1);
/* 147 */     cell81.setCellValue("Receipt No");
/* 148 */     cell81.setCellStyle((CellStyle)style4);
/*     */     
/* 150 */     Cell cell82 = xSSFRow5.createCell(2);
/* 151 */     cell82.setCellValue("Receipt Particulars");
/* 152 */     cell82.setCellStyle((CellStyle)style4);
/*     */     
/* 154 */     Cell cell83 = xSSFRow5.createCell(3);
/* 155 */     cell83.setCellValue("Receipt Amount");
/* 156 */     cell83.setCellStyle((CellStyle)style4);
/*     */     
/* 158 */     Cell cell84 = xSSFRow5.createCell(4);
/* 159 */     cell84.setCellValue("Receipt Remains");
/* 160 */     cell84.setCellStyle((CellStyle)style4);
/*     */     
/* 162 */     Cell cell85 = xSSFRow5.createCell(5);
/* 163 */     cell85.setCellValue("Invoice Date");
/* 164 */     cell85.setCellStyle((CellStyle)style4);
/*     */     
/* 166 */     Cell cell86 = xSSFRow5.createCell(6);
/* 167 */     cell86.setCellValue("Invoice No");
/* 168 */     cell86.setCellStyle((CellStyle)style4);
/*     */     
/* 170 */     Cell cell87 = xSSFRow5.createCell(7);
/* 171 */     cell87.setCellValue("Invoice Particulars");
/* 172 */     cell87.setCellStyle((CellStyle)style4);
/*     */     
/* 174 */     Cell cell88 = xSSFRow5.createCell(8);
/* 175 */     cell88.setCellValue("Invoice Amount");
/* 176 */     cell88.setCellStyle((CellStyle)style4);
/*     */     
/* 178 */     Cell cell89 = xSSFRow5.createCell(9);
/* 179 */     cell89.setCellValue("Invoice Remains");
/* 180 */     cell89.setCellStyle((CellStyle)style4);
/*     */     
/* 182 */     Cell cell810 = xSSFRow5.createCell(10);
/* 183 */     cell810.setCellValue("No Of Days Payment Received");
/* 184 */     cell810.setCellStyle((CellStyle)style4);
/*     */     
/* 186 */     Cell cell811 = xSSFRow5.createCell(11);
/* 187 */     cell811.setCellValue("Applicable CD Amount");
/* 188 */     cell811.setCellStyle((CellStyle)style4);
/*     */     
/* 190 */     Cell cell812 = xSSFRow5.createCell(12);
/* 191 */     cell812.setCellValue("CD Percent (%)");
/* 192 */     cell812.setCellStyle((CellStyle)style4);
/*     */     
/* 194 */     Cell cell813 = xSSFRow5.createCell(13);
/* 195 */     cell813.setCellValue("CD Amount");
/* 196 */     cell813.setCellStyle((CellStyle)style4);
/*     */     
/* 198 */     s.setRepeatingRows(new CellRangeAddress(8, 8, 0, 13));
/* 199 */     s.setAutobreaks(true);
/*     */ 
/*     */ 
/*     */     
/* 203 */     XSSFPrintSetup ps = s.getPrintSetup();
/* 204 */     ps.setLandscape(true);
/* 205 */     ps.setOrientation(PrintOrientation.LANDSCAPE);
/*     */     
/* 207 */     int i = 9;
/* 208 */     for (CashDiscount cds : CRDNList) {
/*     */       
/* 210 */       xSSFRow5 = s.createRow(i);
/*     */       
/* 212 */       Cell c0 = xSSFRow5.createCell(0);
/* 213 */       c0.setCellValue(cds.getCreditDate());
/* 214 */       c0.setCellStyle((CellStyle)style5);
/*     */       
/* 216 */       Cell c1 = xSSFRow5.createCell(1);
/* 217 */       c1.setCellValue(cds.getCreditNo());
/* 218 */       c1.setCellStyle((CellStyle)style5);
/*     */       
/* 220 */       Cell c2 = xSSFRow5.createCell(2);
/* 221 */       c2.setCellValue(cds.getCreditParticulars());
/* 222 */       c2.setCellStyle((CellStyle)style5);
/*     */       
/* 224 */       Cell c3 = xSSFRow5.createCell(3);
/* 225 */       c3.setCellValue(cds.getCreditAmt());
/* 226 */       c3.setCellStyle((CellStyle)style5);
/*     */       
/* 228 */       Cell c4 = xSSFRow5.createCell(4);
/* 229 */       c4.setCellValue(cds.getCreditRemains());
/* 230 */       c4.setCellStyle((CellStyle)style5);
/*     */       
/* 232 */       Cell c5 = xSSFRow5.createCell(5);
/* 233 */       c5.setCellValue(cds.getDebitDate());
/* 234 */       c5.setCellStyle((CellStyle)style5);
/*     */       
/* 236 */       Cell c6 = xSSFRow5.createCell(6);
/* 237 */       c6.setCellValue(cds.getDebitNo());
/* 238 */       c6.setCellStyle((CellStyle)style5);
/*     */       
/* 240 */       Cell c7 = xSSFRow5.createCell(7);
/* 241 */       c7.setCellValue(cds.getDebitParticulars());
/* 242 */       c7.setCellStyle((CellStyle)style5);
/*     */       
/* 244 */       Cell c8 = xSSFRow5.createCell(8);
/* 245 */       c8.setCellValue(cds.getDebitAmt());
/* 246 */       c8.setCellStyle((CellStyle)style5);
/*     */       
/* 248 */       Cell c9 = xSSFRow5.createCell(9);
/* 249 */       c9.setCellValue(cds.getDebitRemains());
/* 250 */       c9.setCellStyle((CellStyle)style5);
/*     */       
/* 252 */       Cell c10 = xSSFRow5.createCell(10);
/* 253 */       c10.setCellValue(cds.getDaysCount());
/* 254 */       c10.setCellStyle((CellStyle)style5);
/*     */       
/* 256 */       Cell c11 = xSSFRow5.createCell(11);
/* 257 */       c11.setCellValue(cds.getCDApplicableAmount());
/* 258 */       c11.setCellStyle((CellStyle)style5);
/*     */       
/* 260 */       Cell c12 = xSSFRow5.createCell(12);
/* 261 */       c12.setCellValue(100.0D * cds.getCDPercent());
/* 262 */       c12.setCellStyle((CellStyle)style5);
/*     */       
/* 264 */       Cell c13 = xSSFRow5.createCell(13);
/* 265 */       c13.setCellValue(cds.getCDAmount());
/* 266 */       c13.setCellStyle((CellStyle)style5);
/*     */       
/* 268 */       if (cds.getCDAmount() >= 0.0D) {
/*     */         
/* 270 */         this.CDTotal += cds.getCDAmount();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 275 */         this.DNTotal += cds.getCDAmount();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 299 */       i++;
/*     */     } 
/* 301 */     i += 4;
/* 302 */     String TotalCreditNoteLabel = "Total CD Calculated(Till Date)";
/* 303 */     String CNGivenSooFarLabel = "CD Credited to Account Soo far";
/* 304 */     String CNRemainsLabel = "CD Remaining to give";
/*     */     
/* 306 */     String TotalLFLabel = "Total Late Fee Calculated(Till Date)";
/* 307 */     String LFSoofarLabel = "Late Fee Debited to Account Soo far";
/* 308 */     String LFRemainsLabel = "Late Fee Remaining to give";
/*     */ 
/*     */     
/* 311 */     XSSFRow xSSFRow6 = s.createRow(i - 2);
/* 312 */     s.addMergedRegion(new CellRangeAddress(i - 2, i - 2, 0, 13));
/* 313 */     Cell ccd0 = xSSFRow6.createCell(0);
/* 314 */     ccd0.setCellValue("Report Summary");
/* 315 */     ccd0.setCellStyle((CellStyle)style2);
/*     */ 
/*     */     
/* 318 */     XSSFRow xSSFRow7 = s.createRow(i);
/* 319 */     s.addMergedRegion(new CellRangeAddress(i, i, 0, 4));
/* 320 */     Cell ccd01 = xSSFRow7.createCell(0);
/* 321 */     ccd01.setCellValue("Cash Discount Summary");
/* 322 */     ccd01.setCellStyle((CellStyle)style7);
/*     */     
/* 324 */     XSSFRow xSSFRow8 = s.createRow(i + 1);
/* 325 */     s.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 0, 2));
/* 326 */     Cell ccd1 = xSSFRow8.createCell(0);
/* 327 */     ccd1.setCellValue(TotalCreditNoteLabel);
/* 328 */     ccd1.setCellStyle((CellStyle)style6);
/*     */     
/* 330 */     s.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 3, 4));
/* 331 */     Cell ccd11 = xSSFRow8.createCell(3);
/* 332 */     ccd11.setCellValue(this.CDTotal);
/* 333 */     ccd11.setCellStyle((CellStyle)style7);
/*     */ 
/*     */ 
/*     */     
/* 337 */     XSSFRow xSSFRow9 = s.createRow(i + 2);
/* 338 */     s.addMergedRegion(new CellRangeAddress(i + 2, i + 2, 0, 2));
/* 339 */     Cell ccd2 = xSSFRow9.createCell(0);
/* 340 */     ccd2.setCellValue(CNGivenSooFarLabel);
/* 341 */     ccd2.setCellStyle((CellStyle)style6);
/*     */     
/* 343 */     s.addMergedRegion(new CellRangeAddress(i + 2, i + 2, 3, 4));
/* 344 */     Cell ccd21 = xSSFRow9.createCell(3);
/* 345 */     ccd21.setCellValue(ExcelExtraction.CDsooFar);
/* 346 */     ccd21.setCellStyle((CellStyle)style7);
/*     */ 
/*     */     
/* 349 */     XSSFRow xSSFRow10 = s.createRow(i + 3);
/* 350 */     s.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 0, 2));
/* 351 */     Cell ccd3 = xSSFRow10.createCell(0);
/* 352 */     ccd3.setCellValue(CNRemainsLabel);
/* 353 */     ccd3.setCellStyle((CellStyle)style6);
/*     */     
/* 355 */     s.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 3, 4));
/* 356 */     Cell ccd31 = xSSFRow10.createCell(3);
/* 357 */     double CDRemains = this.CDTotal - ExcelExtraction.CDsooFar;
/* 358 */     ccd31.setCellValue(CDRemains);
/* 359 */     ccd31.setCellStyle((CellStyle)style7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     s.addMergedRegion(new CellRangeAddress(i, i, 8, 12));
/* 366 */     Cell ccd02 = xSSFRow7.createCell(8);
/* 367 */     ccd02.setCellValue("Late Fee Interest Summary");
/* 368 */     ccd02.setCellStyle((CellStyle)style7);
/*     */ 
/*     */ 
/*     */     
/* 372 */     s.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 8, 10));
/* 373 */     Cell ci1 = xSSFRow8.createCell(8);
/* 374 */     ci1.setCellValue(TotalLFLabel);
/* 375 */     ci1.setCellStyle((CellStyle)style6);
/*     */     
/* 377 */     s.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 11, 12));
/* 378 */     Cell ci11 = xSSFRow8.createCell(11);
/* 379 */     ci11.setCellValue(this.DNTotal);
/* 380 */     ci11.setCellStyle((CellStyle)style7);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     s.addMergedRegion(new CellRangeAddress(i + 2, i + 2, 8, 10));
/* 386 */     Cell ci2 = xSSFRow9.createCell(8);
/* 387 */     ci2.setCellValue(LFSoofarLabel);
/* 388 */     ci2.setCellStyle((CellStyle)style6);
/*     */     
/* 390 */     s.addMergedRegion(new CellRangeAddress(i + 2, i + 2, 11, 12));
/* 391 */     Cell ci21 = xSSFRow9.createCell(11);
/* 392 */     ci21.setCellValue(ExcelExtraction.DNsooFar);
/* 393 */     ci21.setCellStyle((CellStyle)style7);
/*     */ 
/*     */     
/* 396 */     double DNRemains = this.DNTotal - ExcelExtraction.DNsooFar;
/*     */ 
/*     */ 
/*     */     
/* 400 */     s.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 8, 10));
/* 401 */     Cell ci3 = xSSFRow10.createCell(8);
/* 402 */     ci3.setCellValue(LFRemainsLabel);
/* 403 */     ci3.setCellStyle((CellStyle)style6);
/*     */     
/* 405 */     s.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 11, 12));
/* 406 */     Cell ci31 = xSSFRow10.createCell(11);
/* 407 */     ci31.setCellValue(DNRemains);
/* 408 */     ci31.setCellStyle((CellStyle)style7);
/*     */     
/* 410 */     s.addMergedRegion(new CellRangeAddress(i + 5, i + 5, 0, 13));
/* 411 */     XSSFRow xSSFRow11 = s.createRow(i + 5);
/* 412 */     Cell FinalMerged = xSSFRow11.createCell(0);
/* 413 */     FinalMerged.setCellStyle((CellStyle)style5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 430 */       String outputFileLocation = "E:\\CreditNotes\\";
/* 431 */       String outputFileName = ExcelExtraction.ledgerName;
/* 432 */       String outputFileType = ".xlsx";
/* 433 */       String absPath = String.valueOf(outputFileLocation) + Integer.toString(CDExcelNo) + "_" + outputFileName + outputFileType;
/*     */       
/* 435 */       FileOutputStream out = new FileOutputStream(new File(absPath));
/* 436 */       workbook.write(out);
/*     */       
/* 438 */       out.close();
/*     */ 
/*     */       
/* 441 */       CDExcelNo++;
/*     */       
/* 443 */       int checker = 1;
/* 444 */       return checker;
/*     */     }
/* 446 */     catch (Exception e) {
/*     */       
/* 448 */       e.printStackTrace();
/* 449 */       int checker = 0;
/* 450 */       return checker;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\CreditNoteExcel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */