package android.example.animation_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Model> list = new ArrayList<>();
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));
        list.add(new Model("a", "b", "c"));

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.main_rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this, this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}