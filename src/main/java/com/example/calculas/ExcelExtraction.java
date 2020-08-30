/*     */ package com.example.calculas;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.time.LocalDate;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ 
/*     */ public class ExcelExtraction
/*     */ {
/*     */   public static String ledgerName;
/*     */   public static String dateRange;
/*     */   public static String firmName;
/*  25 */   public static double CDsooFar = 0.0D;
/*  26 */   public static double DNsooFar = 0.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   public int ExceltoObject(File selectedFile) {
/*     */     try {
/*     */       int lastVoucherIndexAdjuster, firstVoucherIndexAdjuster;
/*  33 */       String slocation = selectedFile.getAbsolutePath();
/*  34 */       String cn = "Credit Note";
/*  35 */       String dn = "Debit Note";
/*  36 */       String rep = "Receipt";
/*  37 */       String sg = "Sales GST";
/*  38 */       String salRe = "Sales Return Gst";
/*  39 */       String openBal = "Opening Balance";
/*  40 */       String closeBal = "Closing Balance";
/*     */ 
/*     */       
/*  43 */       FileInputStream file = new FileInputStream(new File(slocation));
/*     */ 
/*     */       
/*  46 */       XSSFWorkbook workbook = new XSSFWorkbook(file);
/*     */ 
/*     */       
/*  49 */       XSSFSheet sheet = workbook.getSheetAt(0);
/*     */ 
/*     */       
/*  52 */       XSSFRow xSSFRow1 = sheet.getRow(5);
/*  53 */       Cell lcell = xSSFRow1.getCell(0);
/*  54 */       ledgerName = lcell.getStringCellValue();
/*  55 */       System.out.println("*********** LEDGER NAME ************" + ledgerName);
/*     */ 
/*     */ 
/*     */       
/*  59 */       xSSFRow1 = sheet.getRow(9);
/*  60 */       lcell = xSSFRow1.getCell(0);
/*  61 */       dateRange = lcell.getStringCellValue();
/*  62 */       System.out.println("*********** LEDGER NAME ************" + dateRange);
/*     */ 
/*     */ 
/*     */       
/*  66 */       int z = sheet.getLastRowNum();
/*     */       
/*  68 */       XSSFRow xSSFRow2 = sheet.getRow(z - 1);
/*     */       
/*  70 */       Cell lastRowThirdCell = xSSFRow2.getCell(2);
/*  71 */       String lastRowParticular = lastRowThirdCell.getStringCellValue();
/*     */ 
/*  81 */       if (lastRowParticular.equals(closeBal)) {
/*  82 */         lastVoucherIndexAdjuster = 3;
/*     */       } else {
/*  84 */         lastVoucherIndexAdjuster = 1;
/*     */       } 
/*     */ 
/*     */       
/*  88 */       ArrayList<NewVoucher> voucherList = new ArrayList<>();
/*     */       NewVoucher eob = new NewVoucher();
/*     */       
/*  99 */       XSSFRow xSSFRow3 = sheet.getRow(11);
/* 100 */       Cell firstRowThirdCell = xSSFRow3.getCell(2);
/* 101 */       String firstRowThirdCellValue = firstRowThirdCell.getStringCellValue();
/*     */       
/* 103 */       if (firstRowThirdCellValue.equals(openBal)) {
/*     */         
/* 105 */         Cell firstRowFirstCell = xSSFRow3.getCell(0);
/* 106 */         Cell firstRowSixthCell = xSSFRow3.getCell(5);
/* 107 */         Cell firstRowSeventhCell = xSSFRow3.getCell(6);
/*     */         
/* 109 */         Date mydate = firstRowFirstCell.getDateCellValue();
/* 110 */         SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
/* 111 */         String result = formater.format(mydate);
/* 112 */         System.out.println(result);
/*     */         
/* 114 */         eob.setDate(result);
/* 115 */         eob.setVoucher(firstRowThirdCellValue);
/* 116 */         eob.setParticulars(firstRowThirdCellValue);
/* 117 */         eob.setDebit(Double.valueOf(firstRowSixthCell.getNumericCellValue()));
/* 118 */         eob.setCredit(Double.valueOf(firstRowSeventhCell.getNumericCellValue()));
/*     */         
/* 120 */         voucherList.add(eob);
/*     */ 
/*     */         
/* 123 */         firstVoucherIndexAdjuster = 12;
/*     */       }
/*     */       else {
/*     */         
/* 127 */         firstVoucherIndexAdjuster = 11;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 132 */       for (int i = sheet.getFirstRowNum() + firstVoucherIndexAdjuster; i <= sheet.getLastRowNum() - lastVoucherIndexAdjuster; i++) {
/*     */         
/* 134 */         System.out.println(i);
/*     */ 
/*     */         
/* 137 */         int k = sheet.getFirstRowNum() + firstVoucherIndexAdjuster;
/* 138 */         int o = sheet.getLastRowNum() - lastVoucherIndexAdjuster;
/* 139 */         System.out.println(k);
/* 140 */         System.out.println(o);
/*     */         
/* 142 */         NewVoucher e = new NewVoucher();
/* 143 */         XSSFRow xSSFRow = sheet.getRow(i);
/*     */         
/* 145 */         for (int j = xSSFRow.getFirstCellNum(); j <= xSSFRow.getLastCellNum(); j++) {
/* 146 */           Cell ce = xSSFRow.getCell(j);
/*     */           
/* 148 */           if (j == 0) {
/* 149 */             Date mydate = ce.getDateCellValue();
/* 150 */             SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
/* 151 */             String result = formater.format(mydate);
/* 152 */             System.out.println(result);
/* 153 */             e.setDate(result);
/*     */           System.out.println(result);
					}
/* 155 */           else if (j == 2) {
/* 156 */             e.setParticulars(ce.getStringCellValue());
/*     */           System.out.println(ce.getStringCellValue());
					}
/* 158 */           else if (j == 3) {
/* 159 */             e.setVoucher(ce.getStringCellValue());
/*     */           System.out.println(ce.getStringCellValue());

					}
/* 161 */           else if (j == 4) {
/* 162 */             e.setVoucherNo(ce.getStringCellValue()); System.out.println(ce.getStringCellValue());

/*     */           }
/* 164 */           else if (j == 5) {
/*     */             
/* 166 */             e.setDebit(Double.valueOf(ce.getNumericCellValue())); 
/*     */           }
/* 168 */           else if (j == 6) {
/*     */             
/* 170 */             e.setCredit(Double.valueOf(ce.getNumericCellValue()));
/*     */           } 
/*     */         } 
/* 173 */         voucherList.add(e);
/*     */       } 
/*     */ 
/*     */       
/* 177 */       Queue<NewVoucher> Sales = new LinkedList<>();
/* 178 */       Queue<NewVoucher> Payments = new LinkedList<>();
/* 179 */       int s = 0, p = 0;
/*     */ 
/*     */       
/* 182 */       for (NewVoucher emp : voucherList) {
/*     */ 
/*     */ 
/*     */         
/* 186 */         String vname = emp.getVoucher();
/* 187 */         String pname = emp.getParticulars();
/*     */         
/* 189 */         if (vname.equals("Journal")||vname.equals(rep) || vname.equals(salRe) || pname.equals("Cash Discount") || pname.equals("Rate Difference - GST")  ) {
/*     */           
/* 191 */           p++;
/* 192 */           Payments.add(emp);

/* 193 */           if (pname.equals("Cash Discount"))
/*     */           {
/* 195 */             CDsooFar += emp.getCredit().doubleValue();
/*     */           }
/*     */ 
/*     */           continue;
/*     */         } 
/*     */         
/* 202 */         if (vname.equals(sg) || vname.equals(openBal) || pname.equals("Late Payment Charges") || pname.equals("Bank Exp.")) {
/*     */ 
/* 205 */           s++;
/* 206 */           Sales.add(emp);
/* 207 */           if (pname.equals("Late Payment Charges"))
/*     */           {
/* 209 */             DNsooFar += emp.getDebit().doubleValue();
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/* 219 */       NewVoucher payment = Payments.remove();
/* 220 */       NewVoucher sales = Sales.remove();
/*     */       
/* 222 */       double payAmount = payment.getCredit().doubleValue();
/* 223 */       double salAmount = sales.getDebit().doubleValue();
/* 224 */       double disPercent = 0.0D, disAmount = 0.0D, temp = 0.0D;
/* 225 */       String sParticular = sales.getParticulars();
/* 226 */       String pParticular = payment.getParticulars();
/*     */ 
/* 230 */       System.out.println();
/*     */       
/* 232 */       String pDate = payment.getDate();
/* 233 */       String sDate = sales.getDate();
/*     */       
/* 235 */       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
/* 236 */       LocalDate payDate = LocalDate.parse(pDate, formatter);
/* 237 */       LocalDate salDate = LocalDate.parse(sDate, formatter);
/*     */ 
/*     */       
/* 240 */       ArrayList<CashDiscount> creditNoteList = new ArrayList<>();
/*     */ 
/*     */       
/* 243 */       while (payAmount != 0.0D) {
/*     */         
/* 245 */         if (payAmount > salAmount) {
/* 246 */           CashDiscount cashD = new CashDiscount();
/* 247 */           double creditNoteAmount = salAmount;
/*     */           
/* 249 */           long daysCount = ChronoUnit.DAYS.between(salDate, payDate);
/* 250 */           System.out.println("***************Days between: " + daysCount);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 255 */           disPercent = CDSlab.getDiscountPercent(daysCount, sParticular, pParticular);
/* 256 */           System.out.println("***************CD Percentage between: " + disPercent);
/*     */           
/* 258 */           disAmount = disPercent * creditNoteAmount;
/* 259 */           disAmount = Double.parseDouble((new DecimalFormat("##.##")).format(disAmount));
/*     */ 
/*     */           
/* 262 */           temp += disAmount;
/*     */           
/* 264 */           System.out.println("***************Discount Amount in current case" + disAmount);
/* 265 */           System.out.println("***************Temp Variable" + temp);
/*     */           
/* 267 */           System.out.println();
/*     */           
/* 269 */           cashD.setCreditNo(payment.getVoucherNo());
/* 270 */           cashD.setCreditAmt(payment.getCredit().doubleValue());
/* 271 */           cashD.setCreditDate(payment.getDate());
/* 272 */           cashD.setCreditRemains(payAmount);
/* 273 */           cashD.setCreditParticulars(payment.getParticulars());
/*     */           
/* 275 */           cashD.setDebitNo(sales.getVoucherNo());
/* 276 */           cashD.setDebitAmt(sales.getDebit().doubleValue());
/* 277 */           cashD.setDebitDate(sales.getDate());
/* 278 */           cashD.setDebitRemains(salAmount);
/* 279 */           cashD.setDebitParticulars(sales.getParticulars());
/*     */           
/* 281 */           cashD.setDaysCount(daysCount);
/* 282 */           cashD.setCDPercent(disPercent);
/* 283 */           cashD.setCDAmount(disAmount);
/* 284 */           cashD.setCDApplicableAmount(creditNoteAmount);
/* 285 */           creditNoteList.add(cashD);
/*     */ 
/*     */ 			salAmount = 0.0D;
/* 290 */           payAmount -= creditNoteAmount;
/*     */ 
/*     */           
/* 293 */           disAmount = 0.0D;
/*     */           
/* 295 */           if (!Sales.isEmpty()) {
/*     */             
/* 297 */             sales = Sales.remove();
/* 298 */             sDate = sales.getDate();
/* 299 */             salAmount = sales.getDebit().doubleValue();
/* 300 */             sParticular = sales.getParticulars();
/*     */             
/* 302 */             salDate = LocalDate.parse(sDate, formatter);
/*     */           } 
/*     */         } 
/*     */         
/* 306 */         if (payAmount < salAmount) {
/*     */           
/* 308 */           CashDiscount cashD = new CashDiscount();
/*     */ 
/* 317 */           double creditNoteAmount = payAmount;
/*     */           
/* 319 */           System.out.println("////////// Applicable amount for discount //////////// " + creditNoteAmount);
/* 320 */           long daysCount = ChronoUnit.DAYS.between(salDate, payDate);
/* 321 */           System.out.println("***************Days between: " + daysCount);
/*     */           
/* 323 */           disPercent = CDSlab.getDiscountPercent(daysCount, sParticular, pParticular);
/* 324 */           System.out.println("***************CD Percentage between: " + disPercent);
/*     */           
/* 326 */           disAmount = disPercent * creditNoteAmount;
/* 327 */           disAmount = Double.parseDouble((new DecimalFormat("##.##")).format(disAmount));
/*     */           
/* 329 */           temp += disAmount;
/*     */           
/* 331 */           System.out.println("***************Discount Amount in current case" + disAmount);
/*     */           
/* 333 */           System.out.println("***************Temp Variable" + temp);
/* 334 */           System.out.println();
/*     */           
/* 336 */           cashD.setCreditNo(payment.getVoucherNo());
/* 337 */           cashD.setCreditAmt(payment.getCredit().doubleValue());
/* 338 */           cashD.setCreditDate(payment.getDate());
/* 339 */           cashD.setCreditRemains(payAmount);
/* 340 */           cashD.setCreditParticulars(payment.getParticulars());
/*     */           
/* 342 */           cashD.setDebitNo(sales.getVoucherNo());
/* 343 */           cashD.setDebitAmt(sales.getDebit().doubleValue());
/* 344 */           cashD.setDebitDate(sales.getDate());
/* 345 */           cashD.setDebitRemains(salAmount);
/* 346 */           cashD.setDebitParticulars(sales.getParticulars());
/*     */           
/* 348 */           cashD.setDaysCount(daysCount);
/* 349 */           cashD.setCDPercent(disPercent);
/* 350 */           cashD.setCDAmount(disAmount);
/* 351 */           cashD.setCDApplicableAmount(creditNoteAmount);
/* 352 */           creditNoteList.add(cashD);
/*     */ 
/*     */           
/* 355 */           disAmount = 0.0D;
/* 356 */           payAmount = 0.0D;
/* 357 */           salAmount -= creditNoteAmount;
/*     */           
/* 359 */           if (!Payments.isEmpty()) {
/*     */             
/* 361 */             payment = Payments.remove();
/* 362 */             payAmount = payment.getCredit().doubleValue();
/* 363 */             pDate = payment.getDate();
/*     */             
/* 365 */             payDate = LocalDate.parse(pDate, formatter);
/* 366 */             pParticular = payment.getParticulars();
/*     */           } 
/*     */         } 
/*     */         
/* 370 */         if (payAmount == salAmount) {
/*     */           
/* 372 */           CashDiscount cashD = new CashDiscount();
/*     */ 			double creditNoteAmount = payAmount;
/* 382 */           System.out.println("////////// Applicable amount for discount //////////// " + creditNoteAmount);
/*     */ 
/*     */           
/* 385 */           long daysCount = ChronoUnit.DAYS.between(salDate, payDate);
/*     */           
/* 387 */           System.out.println("*************** Days between: " + daysCount);
/* 388 */           disPercent = CDSlab.getDiscountPercent(daysCount, sParticular, pParticular);
/* 389 */           System.out.println("*************** CD Percentage between: " + disPercent);
/*     */           
/* 391 */           disAmount = disPercent * creditNoteAmount;
/* 392 */           disAmount = Double.parseDouble((new DecimalFormat("##.##")).format(disAmount));
/*     */           
/* 394 */           temp += disAmount;
/*     */           
/* 396 */           System.out.println("***************Temp Variable" + temp);
/*     */           
/* 398 */           cashD.setCreditNo(payment.getVoucherNo());
/* 399 */           cashD.setCreditAmt(payment.getCredit().doubleValue());
/* 400 */           cashD.setCreditDate(payment.getDate());
/* 401 */           cashD.setCreditRemains(payAmount);
/* 402 */           cashD.setCreditParticulars(payment.getParticulars());
/*     */           
/* 404 */           cashD.setDebitNo(sales.getVoucherNo());
/* 405 */           cashD.setDebitAmt(sales.getDebit().doubleValue());
/* 406 */           cashD.setDebitDate(sales.getDate());
/* 407 */           cashD.setDebitRemains(salAmount);
/* 408 */           cashD.setDebitParticulars(sales.getParticulars());
/*     */           
/* 410 */           cashD.setDaysCount(daysCount);
/* 411 */           cashD.setCDPercent(disPercent);
/* 412 */           cashD.setCDAmount(disAmount);
/* 413 */           cashD.setCDApplicableAmount(creditNoteAmount);
/* 414 */           creditNoteList.add(cashD);
/*     */ 
/*     */           
/* 417 */           disAmount = 0.0D;
/* 418 */           payAmount = 0.0D;
/* 419 */           salAmount = 0.0D;
/* 420 */           if (!Sales.isEmpty()) {
/*     */             
/* 422 */             sales = Sales.remove();
/* 423 */             salAmount = sales.getDebit().doubleValue();
/* 424 */             sDate = sales.getDate();
/* 425 */             salDate = LocalDate.parse(sDate, formatter);
/* 426 */             sParticular = sales.getParticulars();
/*     */           } 
/*     */           
/* 429 */           if (!Payments.isEmpty()) {
/*     */             
/* 431 */             payment = Payments.remove();
/* 432 */             payAmount = payment.getCredit().doubleValue();
/* 433 */             pDate = payment.getDate();
/* 434 */             payDate = LocalDate.parse(pDate, formatter);
/* 435 */             pParticular = payment.getParticulars();
/*     */           } 
/*     */         } 
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
/* 453 */       String tempo = "";
/* 454 */       LocalDate today = LocalDate.now();
/*     */       
/* 456 */       while (salAmount != 0.0D) {
/*     */ 
/*     */         
/* 459 */         long daysCount = ChronoUnit.DAYS.between(salDate, today);
/* 460 */         CashDiscount cashD = new CashDiscount();
/* 461 */         disPercent = CDSlab.getDiscountPercent(daysCount, sParticular, tempo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 471 */         if (daysCount < 91L) {
/* 472 */           disPercent = 0.0D;
/*     */         }
/* 474 */         double creditNoteAmount = salAmount;
/* 475 */         disAmount = creditNoteAmount * disPercent;
/* 476 */         disAmount = Double.parseDouble((new DecimalFormat("##.##")).format(disAmount));
/*     */         
/* 478 */         cashD.setCreditNo("Not");
/*     */         
/* 480 */         cashD.setCreditDate("Payment");
/*     */         
/* 482 */         cashD.setCreditParticulars("Received");
/*     */         
/* 484 */         cashD.setDebitNo(sales.getVoucherNo());
/* 485 */         cashD.setDebitAmt(sales.getDebit().doubleValue());
/* 486 */         cashD.setDebitDate(sales.getDate());
/* 487 */         cashD.setDebitRemains(salAmount);
/* 488 */         cashD.setDebitParticulars(sales.getParticulars());
/*     */         
/* 490 */         cashD.setDaysCount(daysCount);
/* 491 */         cashD.setCDPercent(disPercent);
/* 492 */         cashD.setCDAmount(disAmount);
/* 493 */         cashD.setCDApplicableAmount(creditNoteAmount);
/* 494 */         creditNoteList.add(cashD);
/*     */         
/* 496 */         salAmount = 0.0D;
/*     */         
/* 498 */         if (!Sales.isEmpty()) {
/*     */           
/* 500 */           sales = Sales.remove();
/* 501 */           salAmount = sales.getDebit().doubleValue();
/* 502 */           sDate = sales.getDate();
/* 503 */           salDate = LocalDate.parse(sDate, formatter);
/* 504 */           sParticular = sales.getParticulars();
/*     */         } 
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
/* 519 */       CreditNoteExcel cne = new CreditNoteExcel();
/* 520 */       int checker = cne.ListToExcel(creditNoteList);
/*     */       
/* 522 */       file.close();
/* 523 */       return checker;
/*     */     }
/* 525 */     catch (Exception e) {
/* 526 */       int checker = 0;
/* 527 */       return checker;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\ExcelExtraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */