/*    */ package com.example.calculas;
/*    */ 
/*    */ import java.io.File;
/*    */ import javafx.event.ActionEvent;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.scene.control.Button;
/*    */ import javafx.scene.control.Label;
/*    */ import javafx.scene.control.TextField;
/*    */ import javafx.stage.FileChooser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainController
/*    */ {
/*    */   @FXML
/*    */   private Button btnBrowse;
/*    */   @FXML
/*    */   private Button btnCalculate;
/*    */   @FXML
/*    */   private TextField fName;
/*    */   @FXML
/*    */   private TextField fLocation;
/*    */   @FXML
/*    */   private Label statusSucess;
/*    */   @FXML
/*    */   private Label statusFail;
/*    */   public static File choosenFile;
/* 33 */   ExcelExtraction ee = new ExcelExtraction();
/*    */ 
/*    */   
/*    */   public void buttonAction(ActionEvent event) {
/* 37 */     FileChooser fc = new FileChooser();
/* 38 */     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter[] { new FileChooser.ExtensionFilter("XLSX Files", new String[] { "*.xlsx" }) });
/* 39 */     choosenFile = fc.showOpenDialog(null);
/*    */     
/* 41 */     this.statusSucess.setText(" ");
/* 42 */     this.statusFail.setText(" ");
/*    */     
/* 44 */     if (choosenFile != null) {
/*    */       
/* 46 */       this.fName.setText(choosenFile.getName());
/* 47 */       this.fLocation.setText(choosenFile.getAbsolutePath());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generateCD(ActionEvent event) {
/*    */     try {
/* 55 */       System.out.println(this.fName.getText());
/* 56 */       System.out.println(this.fLocation.getText());
/* 57 */       System.out.println(choosenFile);
/*    */ 
/*    */       
/* 60 */       int i = this.ee.ExceltoObject(choosenFile);
/*    */       
/* 62 */       if (i == 1) {
/*    */ 
/*    */         
/* 65 */         System.out.println("///////// Value of i" + i);
/* 66 */         this.statusSucess.setText("Report Generated Succesfully File is saved at (E:\\CreditNotes )");
/* 67 */         ExcelExtraction.CDsooFar = 0.0D;
/*    */       
/*    */       }
/*    */       else {
/*    */         
/* 72 */         System.out.println("///////// Value of i" + i);
/* 73 */         this.statusFail.setText("Please upload the correct form of excel");
/*    */       } 
/* 75 */       this.fName.setText(" ");
/* 76 */       this.fLocation.setText(" ");
/*    */     
/*    */     }
/* 79 */     catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\MainController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */