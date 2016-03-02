package librarymanagement.ui;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import librarymanagement.business.Book;

public class Utility {

	private FXMLLoader getLoader(String windowName){
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource(
			    		"/librarymanagement/ui/"+windowName
			    )
			);
		
		return loader;
	}
	
	private void launchForm(FXMLLoader loader) {
        
        Stage stage = new Stage();
       
        try {
        	
     
           System.out.println("Loading scene");
           Scene scene = new Scene(loader.load());

           System.out.println("Setting scene stage");
           stage.setScene(scene);

           stage.setResizable(false);
           //stage.setAlwaysOnTop(true);

           
           stage.show();
           
       } catch(Exception e) {
           System.out.println(e.toString());
           e.printStackTrace();
	}      
       
   }
	
	private void openWindow(String windowName){
		try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/"+windowName));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.centerOnScreen();
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private FXMLLoader openWindowToPassData(String windowName){
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource(
			    		"/librarymanagement/ui/"+windowName
			    )
			);
		try{
		Scene scene = new Scene(loader.load());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.mainStage.setScene(scene);
		Main.mainStage.show();
		Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return loader;
	}
	
	/*private openPopup(){
		
	}*/
	
	public void openLogin(){
		openWindow("Login.fxml");
	}
	
	public void openDashboard(){
		openWindow("LMS_Dashboard.fxml");
	}
	
	public void openAddNewLibraryMember(){
		openWindow("AddNewLibraryMember.fxml");
	}
	
	public void openSearchBook(){
		openWindow("SearchBook.fxml");
	}
	
	public void openCheckinBook(){
		openWindow("CheckOutBook.fxml");
		//create the checkinbook.fxml
	}
	
	public void openBooks(){
		//create addBook window
		openWindow("MangeBooks.fxml");
	}
	
	public void openAddBookCopy(int uniqu,Book book){
		FXMLLoader	loader=	openWindowToPassData("AddBookCopy.fxml");
		
		AddBookCopyController ac = loader.<AddBookCopyController>getController();
		ac.initData(uniqu, book);
		
	}
	
	
	public void openEditMemberSearch(){
		openWindow("EditMemberSearch.fxml");
	}
	
	public void lunchAddBookCopy(int uniqu,Book book){
		FXMLLoader	loader =	getLoader("AddBookCopy.fxml");
		AddBookCopyController ac = loader.<AddBookCopyController>getController();
		ac.initData(uniqu, book);
		launchForm(loader);
	}

	public void lunchAddBook() {
		// TODO Auto-generated method stub
		FXMLLoader	loader =	getLoader("AddBook.fxml");
		launchForm(loader);
	}
	
	public void displayScreenInDashBoard(Pane anchPane, String screenName){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/ui/"+screenName));
			Pane a = (Pane)root;
			a.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			anchPane.getChildren().add(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
