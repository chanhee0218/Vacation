package com.chanhee.vacation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    Context mcontext;
    ArrayList<SaveData> sibal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        sibal = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            movieAdapter=new MovieAdapter(sibal);
            sibal.add(new SaveData("백두산",""));
        }
            recyclerView = findViewById(R.id.recycle);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            movieAdapter = new MovieAdapter(sibal);

            recyclerView.setAdapter(movieAdapter);
        }




}




