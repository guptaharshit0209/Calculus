/*    */ package com.example.calculas;
/*    */ 
/*    */ public class CDSlab {
/*    */   public static double getDiscountPercent(long daysCount, String s, String p) {
/*  5 */     double disP = 0.0D;
/*    */ 
/*    */     
/*  8 */     if (daysCount <= 15L) {
/*  9 */       disP = 0.06D;
/*    */     }
/* 11 */     else if (daysCount > 15L && daysCount <= 25L) {
/* 12 */       disP = 0.05D;
/*    */     }
/* 14 */     else if (daysCount > 25L && daysCount <= 35L) {
/* 15 */       disP = 0.04D;
/*    */     }
/* 17 */     else if (daysCount > 35L && daysCount <= 45L) {
/* 18 */       disP = 0.03D;
/*    */     }
/* 20 */     else if (daysCount > 45L && daysCount <= 60L) {
/* 21 */       disP = 0.02D;
/*    */     }
/* 23 */     else if (daysCount > 60L && daysCount <= 90L) {
/* 24 */       disP = 0.0D;
/*    */     } 
/*    */     
/* 27 */     if (s.equals("Seeds Sales") || s.equals("Opening Balance") || p.equals("Cash Discount") || s.equals("Late Payment Charges") ||  s.equals("Sale Gst - Net")) {
/*    */       
/* 29 */       disP = 0.0D;
/* 30 */       return disP;
/*    */     } 
/*    */ 
/*    */     
/* 34 */     if (daysCount >= 91L) {
/*    */       
/* 36 */       disP = (daysCount - 90L) * -6.7E-4D;
/*    */ 
/*    */ 
/* 67 */       return disP;
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 74 */     return disP;
/*    */   }
/*    */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\CDSlab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */