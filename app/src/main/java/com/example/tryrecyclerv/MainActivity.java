package com.example.tryrecyclerv;

import static android.icu.lang.UCharacter.IndicPositionalCategory.LEFT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   private ArrayList<Item> items;
   private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        items = new ArrayList<>() ;
        Item item1 = new Item( "aa" , "aaaaaaa" , 1) ;
        items.add(item1) ;
        Item item2 = new Item( "bb" , "bbbbbbb" , 2) ;
        items.add(item2) ;
        Item item3 = new Item( "cc" , "ccccccc" , 3) ;
        items.add(item3) ;
        Item item4 = new Item( "dd" , "ddddddd" , 4) ;
        items.add(item4) ;
        Item item5 = new Item( "ee" , "eeeeeee" , 5) ;
        items.add(item5) ;

        recyclerView = findViewById(R.id.recycer) ;
        MyAdapter adapter = new MyAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT ){

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPos = viewHolder.getAdapterPosition();
                int toPos = target.getAdapterPosition();

                Collections.swap(items, fromPos, toPos); // ArrayList ב שינוי
                adapter.notifyItemMoved(fromPos, toPos);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.RIGHT) { // Swipe right
                    items.remove(position);
                    adapter.notifyDataSetChanged();

                }

            }
    };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        Button btnAdd = findViewById(R.id.add) ;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int num = rnd.nextInt(100) ;
                Item item6 = new Item("ff" ,"fffffff",6 ) ;
                items.add(item6) ;
                adapter.notifyDataSetChanged();
            }
        });

    };
    }
