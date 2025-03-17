package com.example.scorekeeperapp; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
import androidx.appcompat.app.AppCompatActivity; 
public class MainActivity extends AppCompatActivity { 
    private EditText team1NameEditText, team2NameEditText; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        team1NameEditText = findViewById(R.id.team1Name); 
        team2NameEditText = findViewById(R.id.team2Name); 
        Button startGameButton = findViewById(R.id.startGameButton); 
        startGameButton.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String team1Name = 
                team1NameEditText.getText().toString().trim(); 
                String team2Name = 
                team2NameEditText.getText().toString().trim(); 
                if (!team1Name.isEmpty() && !team2Name.isEmpty()) { 
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class); 
                    intent.putExtra("team1Name", team1Name); 
                    intent.putExtra("team2Name", team2Name); 
                    startActivity(intent); 
                }
                else { 
                    Toast.makeText(MainActivity.this, "Please enter names for both teams!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
} 
