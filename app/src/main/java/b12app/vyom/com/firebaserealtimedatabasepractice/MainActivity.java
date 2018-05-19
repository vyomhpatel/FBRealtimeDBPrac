package b12app.vyom.com.firebaserealtimedatabasepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mDatabaseReference;
    private EditText etUsername, etPass;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.pass);

        save = findViewById(R.id.button);
        save.setOnClickListener(this);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                User user = new User(etUsername.getText().toString(),etPass.getText().toString());
                mDatabaseReference.child("Users").child(String.valueOf(new Random().nextInt(100))).setValue(user);
                Intent intent = new Intent(MainActivity.this,RealtimeSyncedDataActivity.class);
                startActivity(intent);
                break;
        }
    }
}
