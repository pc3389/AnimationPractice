package android.example.animation_java;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.transition.Fade;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<Model> list;
    private Context context;
    private Activity activity;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private View view;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view_background);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
    public RecyclerAdapter(List<Model> foodList, Context context, Activity activity) {
        this.list = foodList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        holder.textView1.setText(list.get(position).getA());
        holder.textView2.setText(list.get(position).getB());
        holder.textView3.setText(list.get(position).getC());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity,
                        Pair.<View, String>create(holder.view, "viewTransition"),
                        Pair.<View, String>create(holder.imageView, "imageTransition"),
                        Pair.<View, String>create(holder.textView1, "textTransition1"),
                        Pair.<View, String>create(holder.textView2, "textTransition2"),
                        Pair.<View, String>create(holder.textView3, "textTransition3")
                );
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
