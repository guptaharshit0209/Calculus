/*    */ package com.example.calculas;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NewVoucher
/*    */ {
/*    */   private String date;
/*    */   private String voucher;
/*    */   private String voucherNo;
/*    */   private Double debit;
/*    */   private Double credit;
/*    */   private String particulars;
/*    */   
/*    */   public NewVoucher() {}
/*    */   
/*    */   public NewVoucher(String date, String particulars, String voucher, String voucherNo, Double debit, Double credit) {
/* 17 */     this.date = date;
/* 18 */     this.particulars = particulars;
/* 19 */     this.voucher = voucher;
/* 20 */     this.voucherNo = voucherNo;
/* 21 */     this.debit = debit;
/* 22 */     this.credit = credit;
/*    */   }
/*    */   
/*    */   public String getDate() {
/* 26 */     return this.date;
/*    */   }
/*    */   
/*    */   public void setDate(String date) {
/* 30 */     this.date = date;
/*    */   }
/*    */   
/*    */   public String getParticulars() {
/* 34 */     return this.particulars;
/*    */   }
/*    */   
/*    */   public void setParticulars(String particulars) {
/* 38 */     this.particulars = particulars;
/*    */   }
/*    */   
/*    */   public String getVoucher() {
/* 42 */     return this.voucher;
/*    */   }
/*    */   
/*    */   public void setVoucher(String voucher) {
/* 46 */     this.voucher = voucher;
/*    */   }
/*    */   
/*    */   public String getVoucherNo() {
/* 50 */     return this.voucherNo;
/*    */   }
/*    */   
/*    */   public void setVoucherNo(String voucherNo) {
/* 54 */     this.voucherNo = voucherNo;
/*    */   }
/*    */   
/*    */   public Double getDebit() {
/* 58 */     return this.debit;
/*    */   }
/*    */   
/*    */   public void setDebit(Double debit) {
/* 62 */     this.debit = debit;
/*    */   }
/*    */   
/*    */   public Double getCredit() {
/* 66 */     return this.credit;
/*    */   }
/*    */   
/*    */   public void setCredit(Double credit) {
/* 70 */     this.credit = credit;
/*    */   }
/*    */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\NewVoucher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */