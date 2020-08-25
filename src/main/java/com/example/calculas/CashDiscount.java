/*     */ package com.example.calculas;
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
/*     */ public class CashDiscount
/*     */ {
/*     */   private String creditNo;
/*     */   private double creditAmt;
/*     */   private String creditDate;
/*     */   private double creditRemains;
/*     */   private String creditParticulars;
/*     */   private String debitNo;
/*     */   private double debitAmt;
/*     */   private String debitDate;
/*     */   private double debitRemains;
/*     */   private String debitParticulars;
/*     */   private long dayCount;
/*     */   private double cdPercent;
/*     */   private double cdAmount;
/*     */   private double cdApplicableAmount;
/*     */   
/*     */   public CashDiscount() {}
/*     */   
/*     */   public CashDiscount(String creditNo, double creditAmt, String creditDate, double creditRemains, String creditParticulars, String debitNo, double debitAmt, String debitDate, double debitRemains, String debitParticulars, long dayCount, double cdPercent, double cdAmount, double cdApplicableAmount) {
/*  64 */     this.creditNo = creditNo;
/*  65 */     this.creditAmt = creditAmt;
/*  66 */     this.creditDate = creditDate;
/*  67 */     this.creditRemains = creditRemains;
/*  68 */     this.creditParticulars = creditParticulars;
/*     */     
/*  70 */     this.debitNo = debitNo;
/*  71 */     this.debitAmt = debitAmt;
/*  72 */     this.debitDate = debitDate;
/*  73 */     this.debitRemains = debitRemains;
/*  74 */     this.debitParticulars = debitParticulars;
/*     */     
/*  76 */     this.dayCount = dayCount;
/*  77 */     this.cdPercent = cdPercent;
/*  78 */     this.cdAmount = cdAmount;
/*  79 */     this.cdApplicableAmount = cdApplicableAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreditNo() {
/*  84 */     return this.creditNo;
/*     */   }
/*     */   public void setCreditNo(String creditNo) {
/*  87 */     this.creditNo = creditNo;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCreditAmt() {
/*  92 */     return this.creditAmt;
/*     */   }
/*     */   public void setCreditAmt(double creditAmt) {
/*  95 */     this.creditAmt = creditAmt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreditDate() {
/* 100 */     return this.creditDate;
/*     */   }
/*     */   public void setCreditDate(String creditDate) {
/* 103 */     this.creditDate = creditDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCreditRemains() {
/* 108 */     return this.creditRemains;
/*     */   }
/*     */   public void setCreditRemains(double creditRemains) {
/* 111 */     this.creditRemains = creditRemains;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreditParticulars() {
/* 116 */     return this.creditParticulars;
/*     */   }
/*     */   
/*     */   public void setCreditParticulars(String creditParticulars) {
/* 120 */     this.creditParticulars = creditParticulars;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDebitNo() {
/* 125 */     return this.debitNo;
/*     */   }
/*     */   public void setDebitNo(String debitNo) {
/* 128 */     this.debitNo = debitNo;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDebitAmt() {
/* 133 */     return this.debitAmt;
/*     */   }
/*     */   public void setDebitAmt(double debitAmt) {
/* 136 */     this.debitAmt = debitAmt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDebitDate() {
/* 141 */     return this.debitDate;
/*     */   }
/*     */   public void setDebitDate(String debitDate) {
/* 144 */     this.debitDate = debitDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDebitRemains() {
/* 149 */     return this.debitRemains;
/*     */   }
/*     */   public void setDebitRemains(double debitRemains) {
/* 152 */     this.debitRemains = debitRemains;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDebitParticulars() {
/* 157 */     return this.debitParticulars;
/*     */   }
/*     */   public void setDebitParticulars(String debitParticulars) {
/* 160 */     this.debitParticulars = debitParticulars;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDaysCount() {
/* 167 */     return this.dayCount;
/*     */   }
/*     */   public void setDaysCount(long dayCount) {
/* 170 */     this.dayCount = dayCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCDPercent() {
/* 175 */     return this.cdPercent;
/*     */   }
/*     */   public void setCDPercent(double cdPercent) {
/* 178 */     this.cdPercent = cdPercent;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCDAmount() {
/* 183 */     return this.cdAmount;
/*     */   }
/*     */   public void setCDAmount(double cdAmount) {
/* 186 */     this.cdAmount = cdAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCDApplicableAmount() {
/* 191 */     return this.cdApplicableAmount;
/*     */   }
/*     */   public void setCDApplicableAmount(double cdApplicableAmount) {
/* 194 */     this.cdApplicableAmount = cdApplicableAmount;
/*     */   }
/*     */ }


