package appewtc.masterung.testishihara;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static appewtc.masterung.testishihara.R.id.radioButton4;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView ishiharaImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;
    private Button answerButton;
    private int radioAnInt, indexAnInt, scoreAnInt;
    private MyValue objMyValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Create Button Controller
        buttonController();

        //Create Radio Controller
        radioController();

    }   // onCreate

    private void radioController() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                soundEffect(R.raw.effect_btn_shut);

                switch (i) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }

            }   // event
        });
    }

    private void buttonController() {
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sound Effect
                soundEffect(R.raw.effect_btn_long);

                //Check Zero
                if (radioAnInt == 0) {
                    Toast.makeText(MainActivity.this, "Please Choose Answer", Toast.LENGTH_SHORT).show();
                } else {
                    //Check Times
                    if (indexAnInt == 9) {
                        //Intent to ShowScore
                        Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);
                        objIntent.putExtra("Score", scoreAnInt);
                        startActivity(objIntent);
                        finish();
                    } else {
                        //Check Score
                        checkScore();
                        //Increase indexAtInt
                        indexAnInt += 1;
                        //Sent Value indexAtInt to MyValue
                        objMyValue = new MyValue(indexAnInt);
                        //Receive Valur form MyView to Change View
                        changeView();
                    }
                }

            }   //event
        });
    }

    private void checkScore() {
        int[] intTrueAnswer = {1, 2, 3, 1, 2, 3, 1, 2, 4, 4};
        if (radioAnInt == intTrueAnswer[indexAnInt]) {
            scoreAnInt += 1;
        }
        choiceRadioGroup.clearCheck();
    }   // checkScore

    private void changeView() {

        //Change Question
        String strQuestion = objMyValue.qurstionIshihara();
        questionTextView.setText(strQuestion);

        //Change Image
        int intDrawable = objMyValue.ishiharaImage();
        ishiharaImageView.setImageResource(intDrawable);

        //Change Choice
        int intTime = objMyValue.choiceValue();
        String[] strChoice = getResources().getStringArray(intTime);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);
        
    }   // changeView

    private void soundEffect(int intSound) {

        //Create Sound
        MediaPlayer objMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        objMediaPlayer.start();

        //Clear Catch
        objMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });



    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.textView2);
        ishiharaImageView = (ImageView) findViewById(R.id.imageView);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(radioButton4);
        answerButton = (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}   // Main Class
