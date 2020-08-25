/*    */ package com.example.calculas;
/*    */ 
/*    */ import javafx.application.Application;
/*    */ import javafx.fxml.FXMLLoader;
/*    */ import javafx.scene.Parent;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.stage.Stage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   extends Application
/*    */ {
/*    */   public void start(Stage primaryStage) {
/*    */     try {
/* 17 */       Parent root = FXMLLoader.<Parent>load(getClass().getResource("/Main.fxml"));
/*    */       
/* 19 */       Scene scene = new Scene(root);
/* 20 */       scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
/* 21 */       primaryStage.setScene(scene);
/* 22 */       primaryStage.setTitle("Calculus");
/* 23 */       primaryStage.show();
/*    */     
/*    */     }
/* 26 */     catch (Exception e) {
/*    */       
/* 28 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 33 */     launch(args);
/*    */   }
/*    */ }


/* Location:              D:\workspace\Calculus.zip!\Calculus\Calculus1.5.jar!\application\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */