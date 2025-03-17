package com.example.scorekeeperapp; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
public class ResultActivity extends AppCompatActivity { 
    private TextView winnerText, runnerUpText; 
    private Button backToScoreButton; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_result); 
        winnerText = findViewById(R.id.winnerText); 
        runnerUpText = findViewById(R.id.runnerUpText); 
        backToScoreButton = findViewById(R.id.backToScoreButton);  
        Intent intent = getIntent(); 
        String winner = intent.getStringExtra("winner"); 
        String runnerUp = intent.getStringExtra("runnerUp");  
        winnerText.setText("Winner: " + winner); 
        runnerUpText.setText("Runner-Up: " + runnerUp);  
        backToScoreButton.setOnClickListener(v -> {  
        Intent scoreIntent = new Intent(ResultActivity.this, ScoreActivity.class); 
        startActivity(scoreIntent); 
        }); 
    } 
}
