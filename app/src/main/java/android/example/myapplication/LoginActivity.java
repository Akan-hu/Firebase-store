package android.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button login;
    FirebaseAuth auth;
    String text1;
    String text2;
    FirebaseUser myUser;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id. textEdit1);
        editText2 = findViewById(R.id. textEdit2);
        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();
        myUser = auth.getCurrentUser();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 text1 = editText1.getText().toString();
                 text2 = editText2.getText().toString();
                auth.signInWithEmailAndPassword(text1,text2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }
}