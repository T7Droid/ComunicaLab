package com.example.comunicalablogin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.comunicalablogin.R;
import com.example.comunicalablogin.ui.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUserActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private BootstrapEditText editNewEmail, editNewPassword, editNewName;
    private BootstrapButton btnRegister, btnCancel;
    private DatabaseReference mDatabase;
    private DatabaseReference database;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
        editNewName = (BootstrapEditText) findViewById(R.id.editNewName);
        editNewEmail = (BootstrapEditText) findViewById(R.id.editNewEmail);
        editNewPassword = (BootstrapEditText) findViewById(R.id.editNewPassword);
        btnRegister = (BootstrapButton) findViewById(R.id.btnRegister);
        btnCancel = (BootstrapButton) findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterUserActivity.this, "Salvando usuário",
                        Toast.LENGTH_SHORT).show();
                String email = editNewEmail.getText().toString();
                String password = editNewPassword.getText().toString();
                String name = editNewName.getText().toString();
                userModel = new UserModel(name, email, "");
                createNewUser(userModel, password);
            }
        });

        btnCancel.setOnClickListener(v -> finish());
    }

    private void createNewUser(UserModel userModel, String password) {
        mAuth.createUserWithEmailAndPassword(userModel.email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterUserActivity.this, "Usuário criado com sucesso",
                                Toast.LENGTH_SHORT).show();
                        FirebaseUser user2 = mAuth.getCurrentUser();
                        userModel.id = user2.getProviderId();
                        writeNewUser(userModel);
                    } else {
                        Log.w("TAG", "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterUserActivity.this, "Falha ao cadastrar",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void writeNewUser(UserModel userModel) {
        String key = mDatabase.child("users").push().getKey();
        userModel.id = key;
        mDatabase.child("usuários").child(key).setValue(userModel).addOnCompleteListener(task -> {
            Toast.makeText(RegisterUserActivity.this, "Usuário criado com sucesso",
                    Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}