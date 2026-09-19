package com.example.scrollablelist;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        TextView head = findViewById(R.id.header);
        head.setBackgroundResource(R.drawable.round);
    }
    View v;
   public String name;
   public String email;
    public void getInfo(View v) {
            TextView nameSource = findViewById(R.id.nameSource);
            TextView emailSource = findViewById(R.id.emailSource);

            String name = nameSource.getText().toString();
            String email = emailSource.getText().toString();

        ((TextView)findViewById(R.id.nameText)).setText(name);
        ((TextView)findViewById(R.id.emailText)).setText(email);



    }
}