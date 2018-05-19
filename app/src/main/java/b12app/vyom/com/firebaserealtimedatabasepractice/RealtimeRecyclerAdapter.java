package b12app.vyom.com.firebaserealtimedatabasepractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RealtimeRecyclerAdapter extends RecyclerView.Adapter<RealtimeRecyclerAdapter.FirebaseDataHolder> {

    private static final String TAG ="adapter" ;
    Context context;
    List<User> userList;

    public RealtimeRecyclerAdapter(Context context, List<User> users) {
        this.context = context;
        userList = users;
        Log.i(TAG, "RealtimeRecyclerAdapter: "+users.size());
    }

    @NonNull
    @Override
    public FirebaseDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FirebaseDataHolder firebaseDataHolder = null;


            View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
            firebaseDataHolder = new FirebaseDataHolder(view);



        return firebaseDataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FirebaseDataHolder holder, int position) {

        if(userList.size()>0){
            holder.tvName.setText(userList.get(position).username);
            holder.tvPass.setText(userList.get(position).password);
        }

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class FirebaseDataHolder extends RecyclerView.ViewHolder{

        private TextView tvName, tvPass;

        public FirebaseDataHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvUsername);
            tvPass = itemView.findViewById(R.id.tvPass);
        }
    }
}
