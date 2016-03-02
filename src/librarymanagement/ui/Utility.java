package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import librarymanagement.business.Book;

public class Utility {

	
	private void openWindow(String windowName){
		try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/"+windowName));
			Scene scene = new Scene(root,800,600);
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
		openWindow("Dashboard.fxml");
	}
	
	public void openAddNewLibraryMember(){
		openWindow("AddNewLibraryMember.fxml");
	}
	
	public void openSearchBook(){
		openWindow("SearchBook.fxml");
	}
	
	public void openCheckinBook(){
		//create the checkinbook.fxml
	}
	
	public void openAddBook(){
		//create addBook window
		openWindow("AddBook.fxml");
	}
	
	public void openAddBookCopy(int uniqu,Book book){
		FXMLLoader	loader=	openWindowToPassData("AddBookCopy.fxml");
		
		AddBookCopyController ac = loader.<AddBookCopyController>getController();
		ac.initData(uniqu, book);
		
	}
	
	
	public void openEditMemberSearch(){
		openWindow("EditMemberSearch.fxml");
	}
	
}
