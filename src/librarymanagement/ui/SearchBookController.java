package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import librarymanagement.business.Book;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.LibraryMemberService;

public class SearchBookController {

	@FXML
	TextField tfISBN = new TextField();
	@FXML
	Button btnSearch = new Button();
	@FXML
	Button btnBack = new Button();
	
	@FXML
	TextField tfMemberId;
	
	@FXML
	Label message;
	
	public static Book searchedBook;
	
	private LibraryMemberService memberService = new LibraryMemberService();
	
	public void search(){
		LibraryMember member = memberService.get(Integer.valueOf(tfMemberId.getText()));
		if(member == null){
			//show memeber does not exist
			message.setText("member is not found");
		}else{
			message.setText("member is found");
		}
	
		//Perform book search by ISBN number
		//if book is found, show the Book information Window
		/*try{
			//set the scene to the dashboard and display
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/CheckoutBook.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public void back(){
		try{
			//set the scene to the dashboard and display
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/Dashboard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
