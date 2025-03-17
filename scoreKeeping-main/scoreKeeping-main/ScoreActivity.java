package com.example.scorekeeperapp; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
public class ScoreActivity extends AppCompatActivity { 
  private int team1Score = 0; 
  private int team2Score = 0; 
  private TextView team1ScoreText, team2ScoreText, team1NameText, team2NameText; 
  @Override 
  protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_score); 
    Intent intent = getIntent(); 
    String team1Name = intent.getStringExtra("team1Name"); 
    String team2Name = intent.getStringExtra("team2Name");  
    team1ScoreText = findViewById(R.id.team1ScoreText); 
    team2ScoreText = findViewById(R.id.team2ScoreText); 
    team1NameText = findViewById(R.id.team1NameText); 
    team2NameText = findViewById(R.id.team2NameText); 
    Button team1AddPointButton = findViewById(R.id.team1AddPointButton); 
    Button team2AddPointButton = findViewById(R.id.team2AddPointButton); 
    Button resetButton = findViewById(R.id.resetButton); 
    Button viewResultButton = findViewById(R.id.viewResultButton);  
    team1NameText.setText(team1Name); 
    team2NameText.setText(team2Name);  
    team1AddPointButton.setOnClickListener(v -> { 
      team1Score++; 
      updateScores(); 
    }); 
    team2AddPointButton.setOnClickListener(v -> { 
      team2Score++; 
      updateScores(); 
    });  
    resetButton.setOnClickListener(v -> { 
      team1Score = 0; 
      team2Score = 0; 
      updateScores(); 
    });  
    viewResultButton.setOnClickListener(v -> { 
      String winner = team1Score > team2Score ? team1Name : team2Name; 
      String runnerUp = team1Score > team2Score ? team2Name : team1Name;  
      Intent resultIntent = new Intent(ScoreActivity.this, ResultActivity.class); 
            resultIntent.putExtra("winner", winner); 
            resultIntent.putExtra("runnerUp", runnerUp); 
            startActivity(resultIntent); 
      }); 
    }  
    private void updateScores() { 
      team1ScoreText.setText("Score: " + team1Score); 
      team2ScoreText.setText("Score: " + team2Score); 
    }
} 
