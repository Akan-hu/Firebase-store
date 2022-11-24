package android.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4,editText5;
    FirebaseAuth myAuth;
    String text1,text2,text3,text4,text5;
    Button btn;
    TextView myText;
    FirebaseUser newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id. textEdit1);
        editText2 = findViewById(R.id. textEdit2);
        editText3 = findViewById(R.id. textEdit3);
        editText4 = findViewById(R.id. textEdit4);
        editText5 = findViewById(R.id.textEdit5);
        myText = findViewById(R.id.signup);

        btn = findViewById(R.id.register);
        myAuth = FirebaseAuth.getInstance();
        newUser = myAuth.getCurrentUser();

        myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = editText1.getText().toString();
                text2 = editText2.getText().toString();
                text3 = editText3.getText().toString();
                text4 = editText4.getText().toString();
                text5 = editText5.getText().toString();
                myAuth.createUserWithEmailAndPassword(text2,text3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Register unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}