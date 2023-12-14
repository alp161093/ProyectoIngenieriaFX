package Controllers;

import static application.Main.CerrarVentanaAnterior;
import static application.Main.ComprobarUsuario;

import application.MenuPrincipal;
import application.MenuPrincipalAdmin;
import application.PopUpMain;
import application.ProyectoWindow;
import application.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuPrincipalAdminController {
	@FXML 
	private ImageView  imagenMenu;
	
	public void initialize() {
		
		Image imagen = new Image(getClass().getResourceAsStream("logo-transparent.png"));
		imagenMenu.setImage(imagen);
	}
	// Event Listener on Button.onAction
	@FXML
	public void proyectoMenuOnClick(ActionEvent event) {
		//CerrarVentanaAnterior(event); 
		Stage ProyectoWindow = new Stage();
		ProyectoWindow mp = new ProyectoWindow(); 
		mp.start(ProyectoWindow);   
	}

}
