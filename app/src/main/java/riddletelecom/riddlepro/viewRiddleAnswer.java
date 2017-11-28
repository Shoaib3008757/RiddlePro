package riddletelecom.riddlepro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class viewRiddleAnswer extends AppCompatActivity {
    String value;
    TextView   AnswerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_riddle_answer);
        value = getIntent().getExtras().getString("id");

        initiate();
        setRiddleAnswer();
    }

    public void initiate()
    {
        AnswerText = (TextView) findViewById(R.id.riddleanswer);
    }
    public void setRiddleAnswer()
    {
        if(value.equals("1"))
        {
            AnswerText.setText("Room");
        }
        if(value.equals("2"))
        {
            AnswerText.setText("Aloocha");
        }

        if(value.equals("3"))
        {
            AnswerText.setText("Paan");
        }

        if(value.equals("4"))
        {
            AnswerText.setText("Paseena");
        }

        if(value.equals("5"))
        {
            AnswerText.setText("Shabnam k qatre");
        }

        if(value.equals("6"))
        {
            AnswerText.setText("Mooli");
        }

        if(value.equals("7"))
        {
            AnswerText.setText("Chand");
        }

        if(value.equals("8"))
        {
            AnswerText.setText("Pencil");
        }

        if(value.equals("9"))
        {
            AnswerText.setText("Koyla");
        }


        if(value.equals("10"))
        {
            AnswerText.setText("Maghz");
        }
    }
}
