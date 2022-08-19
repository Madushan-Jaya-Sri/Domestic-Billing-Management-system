//package Chart;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.time.Year;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class Analysis extends Application {
//	
//	static int yr;
//	private static int U_Id;
////	-------------------------------- Connection eka ----------------------------//
//	public static final String DB_URL = "jdbc:mysql://localhost/dbm_system";
//	   public static final String USER = "root";
//	  public static final String PASS = "";
//	
//
//	@Override
//	public void start(Stage arg0) throws Exception {
//		starting(arg0);
//
//	}
//
////	 public static void NewscreenChart(int userId) {
////		U_Id = userId;
////		launch(STYLESHEET_CASPIAN);
////
////	}
////	public static void main(String[] args) {
////		launch(STYLESHEET_CASPIAN);
////	}
////	
//	
//	public void starting(Stage primaryStage) {
//		
//		 Button btn1=new Button(" Go ");
//		 btn1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
//		 Label year =new Label("Enter year   -  "); 
//		 year.setStyle("-fx-font: normal bold 20px 'serif' ");
//		 Label lrespo =new Label(); 
//		 lrespo.setStyle( "-fx-background-color: red" );
//		 TextField tf1 =new TextField(); 
//		 tf1.setStyle("-fx-text-alignment: center");
//	        btn1.setOnAction(new EventHandler<ActionEvent>() {  
//	         
//	            @Override  
//	            public void handle(ActionEvent arg0) {
//	            	
//	          try {
//	                // TODO Auto-generated method stub 
//	            	
//	          
//	            	if (tf1.getText().isEmpty())
//	            	{
//	            	lrespo.setText("   The field Is Empty  ");
//	            	}
//	            	else {
//	            	lrespo.setText("  The year entered is sucessful " );
//	            	}
//	      
//	            	yr = Integer.parseInt(tf1.getText());
//	            
//	                electricity(primaryStage);
//	            } catch(Exception ex) {
//	            	
//	            }
//	        }}); 
//		
//		GridPane root = new GridPane();
//		root.setStyle("-fx-padding: 10;" +
//               "-fx-border-style: solid inside;" +
//               "-fx-border-width: 2;" +
//               "-fx-border-insets: 5;" +
//               "-fx-border-radius: 5;" +
//               "-fx-border-color: blue;");
//		//root.getChildren().add(btn1);
//		root.addRow(0,year,tf1);
//		root.addRow(1, btn1,lrespo );
//		Scene scene = new Scene(root,400,100);
//		 primaryStage.setTitle("Analysis");  
//	        primaryStage.setScene(scene);  
//	        primaryStage.setResizable(false);
//	        primaryStage.show();  
//		
//	}
//	
//	
//	
//	
//	public void electricity(Stage primaryStage) {
//		
//		 Button btn1=new Button("Electricity Bill Chart");
//		 btn1.setStyle("-fx-background-color: #99ccff");
//		 btn1.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//	        btn1.setOnAction(new EventHandler<ActionEvent>() {  
//	              
//	            @Override  
//	            public void handle(ActionEvent arg0) {  
//	                // TODO Auto-generated method stub  
//	                electricity(primaryStage);
//	            }  
//	        }); 
//	        Button btn2=new Button("Water Bill Chart");
//			 btn2.setStyle("-fx-background-color: #99ccff");
//			 btn2.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//		        btn2.setOnAction(new EventHandler<ActionEvent>() {  
//		              
//		            @Override  
//		            public void handle(ActionEvent arg0) {  
//		                // TODO Auto-generated method stub  
//		                water(primaryStage);
//		            }  
//		        }); 
//		        Button btn3=new Button("Telephone Bill Chart");
//				 btn3.setStyle("-fx-background-color: #99ccff");
//				 btn3.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//			        btn3.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			                phone(primaryStage);
//			            }  
//			        }); 
//			        Button btnBack=new Button("Go Back");  
//			        btnBack.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			              starting(primaryStage);
//			            }  
//			        });
//		
//		VBox root = new VBox();
//		root.setStyle("-fx-padding: 10;" +"-fx-border-style: solid inside;" +"-fx-border-width: 2;" + "-fx-border-insets: 5;" +"-fx-border-radius: 5;" +"-fx-border-color: blue;");
//		root.getChildren().add(btn1);
//		root.getChildren().add(btn2);
//		root.getChildren().add(btn3);
//	
//		Scene scene1 = new Scene(root,600,600,Color.RED);
//		CategoryAxis xAxis = new CategoryAxis();
//		xAxis.setLabel("Month");
//		
//		NumberAxis yAxis = new NumberAxis();
//		yAxis.setLabel("Bill Amount");
//		
//		LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis, yAxis);
//		lineChart.setTitle("Usage chart of Electricity Bill");
//		
//		XYChart.Series<String,Number> data = new XYChart.Series<>();
//		data.setName("Usage chart ");
//		
//		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		         Statement stmt = conn.createStatement();
//		         ResultSet rs = stmt.executeQuery("SELECT Amount , Month FROM electricity where id='"+U_Id+"' and Year='"+yr+"'"); )
//		{
//			System.out.println("Runing");
//			while(rs.next()) {
//				data.getData().add(new XYChart.Data<String, Number >(rs.getString("Month"), rs.getInt("Amount")));
//			} 
//		}
//		
//		catch(Exception ex) {
//				 System.out.println("there is alllll"); 
//			 }
//		
//		lineChart.getData().add(data);
//		root.getChildren().add(lineChart);
//		root.getChildren().add(btnBack);
//		primaryStage.setTitle(" Linechart of Electricity Bill");
//		primaryStage.setScene(scene1);
//		primaryStage.setResizable(false);
//		primaryStage.show();
//		
//		}
//
//	public void water(Stage primaryStage) {
//		 Button btn1=new Button("Electricity Bill Chart");
//		 btn1.setStyle("-fx-background-color: #99ccff");
//		 btn1.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//	        btn1.setOnAction(new EventHandler<ActionEvent>() {  
//	              
//	            @Override  
//	            public void handle(ActionEvent arg0) {  
//	                // TODO Auto-generated method stub  
//	                electricity(primaryStage);
//	            }  
//	        }); 
//	        Button btn2=new Button("Water Bill Chart");
//			 btn2.setStyle("-fx-background-color: #99ccff");
//			 btn2.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//		        btn2.setOnAction(new EventHandler<ActionEvent>() {  
//		              
//		            @Override  
//		            public void handle(ActionEvent arg0) {  
//		                // TODO Auto-generated method stub  
//		                water(primaryStage);
//		            }  
//		        }); 
//		        Button btn3=new Button("Telephone Bill Chart");
//				 btn3.setStyle("-fx-background-color: #99ccff");
//				 btn3.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//			        btn3.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			                phone(primaryStage);
//			            }  
//			        }); 
//			        Button btnBack=new Button("Go Back");  
//			        btnBack.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			              starting(primaryStage);
//			            }  
//			        });
//		
//		VBox root = new VBox();
//		root.setStyle("-fx-padding: 10;" +"-fx-border-style: solid inside;" +"-fx-border-width: 2;" + "-fx-border-insets: 5;" +"-fx-border-radius: 5;" +"-fx-border-color: blue;");
//		root.getChildren().add(btn1);
//		root.getChildren().add(btn2);
//		root.getChildren().add(btn3);
//		
//		Scene scene1 = new Scene(root,600,600);
//		CategoryAxis xAxis = new CategoryAxis();
//		xAxis.setLabel("Month");
//		
//		NumberAxis yAxis = new NumberAxis();
//		yAxis.setLabel("Bill Amount");
//		
//		LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis, yAxis);
//		lineChart.setTitle("Usage chart of Water Bill");
//		
//		XYChart.Series<String,Number> data = new XYChart.Series<>();
//		data.setName("Usage chart ");
//		
//		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		         Statement stmt = conn.createStatement();
//		         ResultSet rs = stmt.executeQuery("SELECT Amount , Month FROM water where id='"+U_Id+"' and Year='"+yr+"' "); )
//		{
//			System.out.println("Runing");
//			while(rs.next()) {
//				data.getData().add(new XYChart.Data<String, Number >(rs.getString("Month"), rs.getInt("Amount")));
//			} 
//		}
//		
//		catch(Exception ex) {
//				 System.out.println("there is alllll"); 
//			 }
//		
//		lineChart.getData().add(data);
//		root.getChildren().add(lineChart);
//		root.getChildren().add(btnBack);
//		
//		primaryStage.setTitle(" Linecharts for Bill Amounts");
//		primaryStage.setScene(scene1);
//		primaryStage.setResizable(false);
//		primaryStage.show();
//		
//		}
//
//	public void phone(Stage primaryStage) {
//		 Button btn1=new Button("Electricity Bill Chart");
//		 btn1.setStyle("-fx-background-color: #99ccff");
//		 btn1.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//	        btn1.setOnAction(new EventHandler<ActionEvent>() {  
//	              
//	            @Override  
//	            public void handle(ActionEvent arg0) {  
//	                // TODO Auto-generated method stub  
//	                electricity(primaryStage);
//	            }  
//	        }); 
//	        Button btn2=new Button("Water Bill Chart");
//			 btn2.setStyle("-fx-background-color: #99ccff");
//			 btn2.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//		        btn2.setOnAction(new EventHandler<ActionEvent>() {  
//		              
//		            @Override  
//		            public void handle(ActionEvent arg0) {  
//		                // TODO Auto-generated method stub  
//		                water(primaryStage);
//		            }  
//		        }); 
//		        Button btn3=new Button("Telephone Bill Chart");
//				 btn3.setStyle("-fx-background-color: #99ccff");
//				 btn3.setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
//			        btn3.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			                phone(primaryStage);
//			            }  
//			        }); 
//			        Button btnBack=new Button("Go Back");  
//			        btnBack.setOnAction(new EventHandler<ActionEvent>() {  
//			              
//			            @Override  
//			            public void handle(ActionEvent arg0) {  
//			                // TODO Auto-generated method stub  
//			              starting(primaryStage);
//			            }  
//			        });
//		
//		VBox root = new VBox();
//		root.setStyle("-fx-padding: 10;" +"-fx-border-style: solid inside;" +"-fx-border-width: 2;" + "-fx-border-insets: 5;" +"-fx-border-radius: 5;" +"-fx-border-color: blue;");
//		root.getChildren().add(btn1);
//		root.getChildren().add(btn2);
//		root.getChildren().add(btn3);
//		
//		Scene scene1 = new Scene(root,600,600);
//		CategoryAxis xAxis = new CategoryAxis();
//		xAxis.setLabel("Month");
//		
//		NumberAxis yAxis = new NumberAxis();
//		yAxis.setLabel("Bill Amount");
//		
//		LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis, yAxis);
//		lineChart.setTitle("Usage chart of Phone Bill");
//		lineChart.getXAxis().setStyle("-fx-line-color: #000000");
//		lineChart.getYAxis().setStyle("-fx-line-color: #000000 ");
//		
//		XYChart.Series<String,Number> data = new XYChart.Series<>();
//		data.setName("Usage chart ");
//		
//		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		         Statement stmt = conn.createStatement();
//		         ResultSet rs = stmt.executeQuery("SELECT Amount , Month FROM telephone where id='"+U_Id+"' and Year='"+yr+"' "); )
//		{
//			System.out.println("Runing");
//			while(rs.next()) {
//				data.getData().add(new XYChart.Data<String, Number >(rs.getString("Month"), rs.getInt("Amount")));
//			} 
//		}
//		
//		catch(Exception ex) {
//				 System.out.println("there is alllll"); 
//			 }
//		
//		lineChart.getData().add(data);
//		root.getChildren().add(lineChart);
//		root.getChildren().add(btnBack);
//		
//		primaryStage.setTitle("Linecharts for Bill Amounts");
//		primaryStage.setScene(scene1);
//		primaryStage.setResizable(false);
//		primaryStage.show();
//		
//		}
//
//	}
//
//
//
