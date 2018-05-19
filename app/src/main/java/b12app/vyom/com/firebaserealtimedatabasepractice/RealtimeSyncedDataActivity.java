package b12app.vyom.com.firebaserealtimedatabasepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RealtimeSyncedDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> userList;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    private RealtimeRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime_synced_data);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        userList = new ArrayList<>();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot eventSnapShot: dataSnapshot.getChildren()){

                    Log.i("user", "onDataChange: "+eventSnapShot.getValue().toString());

                    userList.add(eventSnapShot.getValue(User.class));
                    Log.i("user", "onDataChange: "+userList.size());
                }

                recyclerAdapter = new RealtimeRecyclerAdapter(RealtimeSyncedDataActivity.this,userList);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };databaseReference.addValueEventListener(valueEventListener);




    }
}
