package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import librarymanagement.business.Authorization;

public class SystemController {
	@FXML
	Button addNewMember = new Button();
	@FXML
	Button editMember = new Button();
	@FXML
	Button addBook = new Button();
	@FXML
	Button checkOutBook = new Button();
	@FXML
	Button checkInBook = new Button();
	@FXML
	Button logout = new Button();
	@FXML
	Label welcomeLbl = new Label();
	@FXML
	FlowPane flowPane = new FlowPane();
	@FXML
	public AnchorPane anchPane = new AnchorPane();
	
	Utility utility = new Utility();
	
	@FXML
	public void initialize(){
		ToolTipDefaultsFixer.setTooltipTimers(0, 5000, 20);
		welcomeLbl.setText("Welcome "+Main.currentUser.getFirstName()+" "+Main.currentUser.getLastName());
		
		
		//if administrator
		if(Main.currentUser.getRoles().size()==1 && Main.currentUser.getRoles().contains(Authorization.ADMINISTRATOR)){
			flowPane.getChildren().remove(checkOutBook);
			flowPane.getChildren().remove(checkInBook);
		}
		
		//if librarian
		if(Main.currentUser.getRoles().size()==1 && Main.currentUser.getRoles().contains(Authorization.LIBRARIAN)){
			flowPane.getChildren().remove(addNewMember);
			flowPane.getChildren().remove(editMember);
			flowPane.getChildren().remove(addBook);
		}
		addNewMember.setTooltip(new Tooltip("Add Member"));
		editMember.setTooltip(new Tooltip("Edit Member"));
		addBook.setTooltip(new Tooltip("Add Book"));
		checkInBook.setTooltip(new Tooltip("Check In"));
		checkOutBook.setTooltip(new Tooltip("Check out"));
		logout.setTooltip(new Tooltip("Logout"));
		//if both
		//by default all the functionalities are available
	}

	public SystemController(){
		
	}
	
	public void addNewLibraryMember(){
		anchPane.getChildren().clear();
		Main.currentUser = null;
		utility.displayScreenInDashBoard(anchPane, "AddNewLibraryMember.fxml");
	}
	
	public void editLibraryMemberInfo(){
		anchPane.getChildren().clear();
		utility.displayScreenInDashBoard(anchPane, "EditMemberSearch.fxml");
	}
	
	public void addBook(){
		anchPane.getChildren().clear();
		utility.displayScreenInDashBoard(anchPane, "MangeBooks.fxml");
	}
	
	public void checkOutBook(){
		anchPane.getChildren().clear();
		utility.displayScreenInDashBoard(anchPane, "SearchBook.fxml");
	}
	
	public void checkInBook(){
		anchPane.getChildren().clear();
		utility.displayScreenInDashBoard(anchPane, "CheckinBook.fxml");
	}
	
	public void logout(){
		Main.currentUser = null;
		utility.openLogin();
	}
	
}
