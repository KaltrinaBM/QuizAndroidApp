package com.example.android.quiz;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    private ImageView imageView;
    private EditText editText;
    private TextView tv1, tv2, tv3, tv4, tv5;
    private RadioButton a, b, c;
    private Button button;
    private RadioGroup radioGroup;
    private int question, points;
    private CheckBox ch1, ch2, ch3, ch4, ch5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageQuiz);
        editText = findViewById(R.id.name);
        tv1 = findViewById(R.id.explain);
        tv2 = findViewById(R.id.questionAnswer);
        tv3 = findViewById(R.id.score);
        tv4 = findViewById(R.id.quizApp);
        tv5 = findViewById(R.id.quizInfo);
        radioGroup = findViewById(R.id.optionGroup);
        a = findViewById(R.id.option1);
        b = findViewById(R.id.option2);;
        c = findViewById(R.id.option3);
        button = findViewById(R.id.next);
        button.setOnClickListener(this);
        ch1 = findViewById(R.id.artist1);
        ch2 = findViewById(R.id.artist2);
        ch3 = findViewById(R.id.artist3);
        ch4 = findViewById(R.id.artist4);
        ch5 = findViewById(R.id.artist5);
        question = 0;
        points = 0;

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Bitmap bitmap = savedInstanceState.getParcelable("image");
        imageView.setImageBitmap(bitmap);
        imageView.setBackgroundResource(R.drawable.corner);
        question = savedInstanceState.getInt("switchQuestions");
        points = savedInstanceState.getInt("points");

        Log.v("my_tag", "text" +tv1);
       ;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("switchQuestions", question);
        outState.putInt("points", points);
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        outState.putParcelable("image", bitmap);

        Log.v("my_tag", "text" +tv1);
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

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * Switch statement to change the questions and image when button is clicked.
     */

    @Override
    public void onClick(View view)  {
        switch (question) {
            case 0: {
                radioGroup.setVisibility(View.VISIBLE);
                radioGroup.clearCheck();
                editText.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);
                ch1.setVisibility(View.INVISIBLE);
                ch2.setVisibility(View.INVISIBLE);
                ch3.setVisibility(View.INVISIBLE);
                ch4.setVisibility(View.INVISIBLE);
                ch5.setVisibility(View.INVISIBLE);
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                tv1.setText(R.string.arrow);
                tv2.setText("");
                tv3.setText("");
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                ch1.setEnabled(true);
                ch2.setEnabled(true);
                ch3.setEnabled(true);
                ch4.setEnabled(true);
                ch5.setEnabled(true);
                editText.setEnabled(true);
                button.setText(R.string.button_check);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                points = 0;
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.mona_lisa);
                imageView.setBackgroundResource(R.drawable.corner);
                tv2.setText(R.string.question1);
                a.setText(R.string.option1);
                b.setText(R.string.option2);
                c.setText(R.string.option3);
                question = 1;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 1: {
                imageView.setImageResource(R.drawable.mona_lisa);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (b.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer1);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 2;
                break;
            }
            case 2: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.the_starry_night);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                imageView.setBackgroundResource(R.drawable.corner);
                radioGroup.clearCheck();
                editText.setEnabled(false);
                tv2.setText(R.string.question2);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                a.setText(R.string.option4);
                b.setText(R.string.option5);
                c.setText(R.string.option6);
                question = 3;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 3: {
                imageView.setImageResource(R.drawable.the_starry_night);
                button.setText(R.string.button_next);
                imageView.setBackgroundResource(R.drawable.corner);
                if (c.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer2);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 4;
                break;
            }
            case 4: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.girl_with_a_pearl_earring);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                imageView.setBackgroundResource(R.drawable.corner);
                radioGroup.clearCheck();
                tv2.setTextColor(Color.parseColor("#1b2520"));
                tv2.setText(R.string.question3);
                a.setText(R.string.option7);
                b.setText(R.string.option8);
                c.setText(R.string.option9);
                question = 5;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 5: {
                imageView.setImageResource(R.drawable.girl_with_a_pearl_earring);
                button.setText(R.string.button_next);
                imageView.setBackgroundResource(R.drawable.corner);
                if (a.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer3);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 6;
                break;
            }
            case 6: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.the_last_supper);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                imageView.setBackgroundResource(R.drawable.corner);
                radioGroup.clearCheck();
                tv2.setText(R.string.question4);
                a.setText(R.string.option10);
                b.setText(R.string.option11);
                c.setText(R.string.option12);
                question = 7;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 7: {
                imageView.setImageResource(R.drawable.the_last_supper);
                button.setText(R.string.button_next);
                imageView.setBackgroundResource(R.drawable.corner);
                if (b.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer4);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 8;
                break;
            }
            case 8: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.the_scream);
                imageView.setBackgroundResource(R.drawable.corner);
                tv1.setText(R.string.arrow);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                button.setText(R.string.button_check);
                radioGroup.clearCheck();
                tv2.setText(R.string.question5);
                a.setText(R.string.option13);
                b.setText(R.string.option14);
                c.setText(R.string.option15);
                question = 9;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 9: {
                imageView.setImageResource(R.drawable.the_scream);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (b.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer5);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 10;
                break;
            }
            case 10: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.american_gothic);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                imageView.setBackgroundResource(R.drawable.corner);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                radioGroup.clearCheck();
                tv2.setText(R.string.question6);
                a.setText(R.string.option16);
                b.setText(R.string.option17);
                c.setText(R.string.option18);
                question = 11;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 11: {
                imageView.setImageResource(R.drawable.american_gothic);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (c.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer6);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 12;
                break;
            }
            case 12: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.the_persistence_of_memory);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                imageView.setBackgroundResource(R.drawable.corner);
                radioGroup.clearCheck();
                tv2.setText(R.string.question7);
                a.setText(R.string.option19);
                b.setText(R.string.option20);
                c.setText(R.string.option21);
                question = 13;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 13: {
                imageView.setImageResource(R.drawable.the_persistence_of_memory);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (a.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer7);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 14;
                break;
            }
            case 14: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.the_creation_of_adam);
                tv1.setText(R.string.arrow);
                button.setText(R.string.button_check);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                imageView.setBackgroundResource(R.drawable.corner);
                radioGroup.clearCheck();
                tv2.setText(R.string.question8);
                a.setText(R.string.option22);
                b.setText(R.string.option23);
                c.setText(R.string.option24);
                question = 15;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 15: {
                imageView.setImageResource(R.drawable.the_creation_of_adam);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (a.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer8);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 16;
                break;
            }
            case 16: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.self_portrait);
                tv1.setText(R.string.arrow);
                tv2.setTextColor(Color.parseColor("#1b2520"));
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_check);
                radioGroup.clearCheck();
                tv2.setText(R.string.question9);
                a.setText(R.string.option25);
                b.setText(R.string.option26);
                c.setText(R.string.option27);
                question = 17;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                break;
            }
            case 17: {
                imageView.setImageResource(R.drawable.self_portrait);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (b.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer9);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 18;
                break;
            }
            case 18: {
                radioGroup.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.self_portrait_without_beard);
                tv1.setText(R.string.arrow);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_check);
                radioGroup.clearCheck();
                tv2.setTextColor(Color.parseColor("#1b2520"));
                tv2.setText(R.string.question10);
                a.setText(R.string.option28);
                b.setText(R.string.option29);
                c.setText(R.string.option30);
                question = 19;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                button.setText(R.string.button_check);
                break;
            }
            case 19: {
                imageView.setImageResource(R.drawable.self_portrait_without_beard);
                imageView.setBackgroundResource(R.drawable.corner);
                button.setText(R.string.button_next);
                if (a.isChecked()) {
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 10;
                } else {
                    tv2.setText(R.string.wrongAnswer);
                    tv1.setText(R.string.answer10);
                    tv2.setTextSize(30);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                    radioGroup.setVisibility(View.INVISIBLE);
                }
                question = 20;
                break;
            }
            case 20: {
                radioGroup.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                tv1.setText(R.string.arrow);
                tv2.setVisibility(View.INVISIBLE);
                button.setText(R.string.button_check);
                tv4.setTextColor(Color.parseColor("#1b2520"));
                tv4.setText(R.string.lastQuestion);
                tv4.setVisibility(View.VISIBLE);
                ch1.setText(R.string.firstArtist);
                ch2.setText(R.string.secondArtist);
                ch3.setText(R.string.thirdrtist);
                ch4.setText(R.string.fourthArtist);
                ch5.setText(R.string.fifthArtist);

                ch1.setChecked(false);
                ch2.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(false);
                ch5.setChecked(false);
                ch1.setVisibility(View.VISIBLE);
                ch2.setVisibility(View.VISIBLE);
                ch3.setVisibility(View.VISIBLE);
                ch4.setVisibility(View.VISIBLE);
                ch5.setVisibility(View.VISIBLE);
                button.setText(R.string.button_check);

                question = 21;
                break;


            }
            case 21: {
                button.setText(R.string.finishText);
                radioGroup.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                tv1.setText(R.string.arrow);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                ch1.setVisibility(View.INVISIBLE);
                ch2.setVisibility(View.INVISIBLE);
                ch3.setVisibility(View.INVISIBLE);
                ch4.setVisibility(View.INVISIBLE);
                ch5.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);


                if (ch1.isChecked()) {
                    ch1.setChecked(false);
                    tv2.setVisibility(View.VISIBLE);
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 25;
                }
                if (ch2.isChecked()) {
                    ch2.setChecked(false);
                    tv2.setVisibility(View.VISIBLE);
                    tv2.setText(R.string.wrongAnswer);
                    tv2.setTextSize(30);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                }
                if (ch3.isChecked()) {
                    ch3.setChecked(false);
                    tv2.setVisibility(View.VISIBLE);
                    tv2.setText(R.string.wrongAnswer);
                    tv2.setTextSize(30);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                }
                if (ch4.isChecked()) {
                    ch4.setChecked(false);
                    tv2.setVisibility(View.VISIBLE);
                    tv2.setText(R.string.correctAnswer);
                    tv2.setTextColor(Color.parseColor("#FF19CF1F"));
                    points = points + 25;
                }
                if (ch5.isChecked()) {
                    ch5.setChecked(false);
                    tv2.setVisibility(View.VISIBLE);
                    tv2.setText(R.string.wrongAnswer);
                    tv2.setTextSize(30);
                    tv2.setTextColor(Color.parseColor("#FFAC080A"));
                }

                question = 22;
                break;

            }
            case 22: {
                button.setText(R.string.finishText);
                radioGroup.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                tv1.setText(R.string.arrow);
                tv4.setVisibility(View.INVISIBLE);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setText( (editText.getText() + getString(R.string.scorePoints, points)));
                button.setText(R.string.buttonRestart);
                Toast.makeText(MainActivity.this,
                        "Your Points", Toast.LENGTH_LONG).show();

                question = 0;
            }
        }
    }




}
