package application;
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Controllers.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application implements Serializable {
	//listado para almacenar los usuarios y poder trabajar con ellos
	private static ArrayList<Usuario> listaUsuarios = new ArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*Usuario us = new Usuario("admin", "admin", true);
			listaUsuarios.add(us);
			ClientesAFichero();*/
			LeerUsuariosDeFichero();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
	        Parent root = loader.load();
	        // Obtener el controlador
	        MainController controller = loader.getController();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Acceso");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//Guardar todos los usuairo en un fichero binario de nombre "usuarios.dat"
    public static void ClientesAFichero(){
        if(listaUsuarios.size()>0){
            try {
                ObjectOutputStream escribeFichero = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                escribeFichero.writeObject(listaUsuarios);
                escribeFichero.flush(); 
                escribeFichero.close();

            }catch (IOException e) {
                System.out.println( e.getMessage() );
            }

        }
    }
	 
    //Lee los usuarios desde un fichero binario, "usuarios.dat"
    public static void LeerUsuariosDeFichero(){
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            listaUsuarios = (ArrayList<Usuario>)leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }

    //Se comprueba si el usuario existe ya dentro de la lista de usuarios
    public static Usuario ComprobarUsuario(String nombreComprobar) {
    	
    	for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombreComprobar))
                return usuario;
        }
    	return null;
    }
    
    public static void CerrarVentanaAnterior(ActionEvent event) {
    	// Obtener el Stage asociado al evento
        Stage originStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        // Cerrar la ventana del menú principal
        originStage.close();
    }
    
}
