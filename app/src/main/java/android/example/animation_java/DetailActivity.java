package android.example.animation_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getWindow().setExitTransition(null);
    }
}