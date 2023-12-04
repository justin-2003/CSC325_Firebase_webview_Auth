package com.example.csc325_firebase_webview_auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import com.example.csc325_firebase_webview_auth.viewmodel.AccessDataViewModel;
import com.example.csc325_firebase_webview_auth.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.*;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.internal.NonNull;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.example.csc325_firebase_webview_auth.App.fstore;


public class SigningIn {

    @FXML
    Button signUp;

    @FXML
    TextField signInEmail,signInPassword;

    @FXML
    Label label;


    public void onLoginButtonClick(ActionEvent e) throws IOException, ExecutionException, InterruptedException {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(signInEmail,signInPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>()){
         @Override
                 public void onComplete(@NonNull Task<AuthResults> task){
                    if(task.isScuccessful()){}

            }
        }
    }


    public void goToSignUpPage() throws IOException {
        App.setRoot("SignUp.fxml");
    }

}