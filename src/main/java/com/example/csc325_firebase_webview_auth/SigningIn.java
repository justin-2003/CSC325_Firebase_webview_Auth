package com.example.csc325_firebase_webview_auth;
import com.example.csc325_firebase_webview_auth.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;




public class SigningIn {

    @FXML
    Button signUp;

    @FXML
    TextField signInEmail, signInPassword;

    @FXML
    Label label;


    public void onLoginButtonClick(ActionEvent e) throws IOException, ExecutionException, InterruptedException {

            if (signInEmail.getText().equals("") || signInPassword.getText().equals("")) {
                label.setText("You are missing fields! Try again!");
            }

            else {
                UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                        .setEmail(signInEmail.getText())
                        .setPassword(signInPassword.getText());

                UserRecord userRecord;


                try {
                    userRecord = App.fauth.getUserByEmail(signInEmail.getText());
                    User.getUser().setName(userRecord.getDisplayName());
                    App.setRoot("AccessFBView.fxml");
                } catch (FirebaseAuthException ex) {
                    label.setText("Unable to sign in! Make sure your information is correct and try Again!");
                    System.out.println(ex);
                }
            }

    }


    public void goToSignUpPage() throws IOException {
        App.setRoot("SignUp.fxml");
    }

}