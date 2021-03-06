package appewtc.masterung.testishihara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static appewtc.masterung.testishihara.R.id.textView3;

public class ShowScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        //Show Score
        showScore();
    }   // onCreate

    private void showScore() {
        TextView showScoreTextView = (TextView) findViewById(textView3);
        int intMyScore = getIntent().getExtras().getInt("Score");
        showScoreTextView.setText(Integer.toString(intMyScore) + "/10");
    }

    public void clickPlay(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void clickExit(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
