package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.BedroomLamp;
import model.BedroomPlant;
import model.Cart;
import model.CeilingLamp;
import model.WallLamp;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController implements Initializable {

    @FXML
    TextField mytextfield;

    @FXML
    PasswordField mypasswordfield;

    @FXML
    Button mybutton;

    @FXML
    Label mywarninglabel;

    @FXML
    HomeController homeController = null;

    @FXML
    static CheckoutController checkoutController = null;

    @FXML
    static Parent homeRoot = null;

    FXMLLoader loader;

    static BedroomLamp blamp = new BedroomLamp();
    static CeilingLamp clamp = new CeilingLamp();
    static WallLamp wlamp = new WallLamp();
    static BedroomPlant bplant = new BedroomPlant();
    static Cart cart = new Cart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== BEDROOM LAMP ==================//
        blamp.setProductName("Matcha");
        blamp.setProductPrice(50.00);
        blamp.setProductImage("images/lamp1.jpg");
        // ============== CEILING LAMP ==================//

        clamp.setProductName("Cookies and Cream");
        clamp.setProductPrice(50.00);
        clamp.setProductImage("images/lamp2.jpg");

        // ============== WALL LAMP ==================//
        wlamp.setProductName("Wintermelon");
        wlamp.setProductPrice(50.00);
        wlamp.setProductImage("images/lamp3.jpg");

        // ============== BEDROOM PLANT ==================/
        bplant.setProductName("Quezo Royal");
        bplant.setProductPrice(60.00);
        bplant.setProductImage("images/plant3.jpg");
        

        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            homeRoot = loader.load();

        } catch (Exception e) {
  
            e.printStackTrace();

        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());
    }

    public void login(ActionEvent event) throws IOException {

        String username = mytextfield.getText();
        String password = mypasswordfield.getText();

        if (username.equals("a") && password.equals("a")) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            mywarninglabel.setVisible(true);
        }
    }

}
