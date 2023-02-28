package com.example.testgaz;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class questionnaire extends AppCompatActivity implements View.OnClickListener {

    String[][] squest;
    int count = 0;
    Button btn_n;
    TextView texquest, coment;
    ImageView imageView;
    RadioGroup radGrp;
    RadioButton af, sf, tf;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        squest = new String[][]{
                {"Что запрещается при пользовании бытовой газовой плитой?", "Пользование газовой плитой детьми с 12 лет после проведения инструктажа!",
                "Сушить вещи над пламенем горелок газоиспользующего оборудования!", "Использовать одновременно горелки газовой плиты и духовой шкаф!"},
                {"Что необходимо сделать при запахе газа?",
                        "Закрыть краны перед газовыми приборами, открыть окна, проветрить помещения. Запрещается: зажигать спички, курить, пользоваться телефоном, включать/выключать освещение и электроприборы. Необходимо покинуть помещение и вызвать аварийную газовую службу!",
                        "Выключить все электроприборы, вызвать аварийную бригаду, не покидать место происшествия до прибытия аварийной бригады!",
                        "Найти источник выхода газа, постараться устранить утечку, при невозможности самостоятельного устранения утечки вызвать аварийную бригаду."},
                {"По какому телефону обращаться при запахе газа?", "102", "103", "104"},
                {"Можно ли самостоятельно производить замену газоиспользующего оборудования?", "Можно, после согласования с газоснабжающей организацией!", "Можно в любом случае!", "Нет!"},
                {"Можно ли оставлять без присмотра работающую газовую плиту?", "Можно", "Нельзя", " "},
                {"Нужно ли проводить техническое обслуживание газоиспользующего оборудования?", "Нет, только в случае неисправности!", "Нужно", " "}
        };

        texquest = findViewById(R.id.tquest);

        imageView = (ImageView) findViewById(R.id.ans);
        imageView.setVisibility(View.INVISIBLE);
        imageView.setClickable(true);
        imageView.setOnClickListener(this);

        coment = (TextView) findViewById(R.id.coment);
        coment.setVisibility(View.INVISIBLE);
        coment.setClickable(true);
        coment.setOnClickListener(this);
        radGrp = (RadioGroup)findViewById(R.id.radios);
        af = findViewById(R.id.a_first);
        sf = findViewById(R.id.a_sec);
        tf = findViewById(R.id.a_th);

        texquest.setText(squest[0][0]);
        af.setText(squest[0][1]);
        sf.setText(squest[0][2]);
        tf.setText(squest[0][3]);

        btn_n = (Button) findViewById(R.id.btn_next);
        btn_n.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ans :
            case R.id.coment :
                coment.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                texquest.setVisibility(View.VISIBLE);
                af.setVisibility(View.VISIBLE);
                sf.setVisibility(View.VISIBLE);
                tf.setVisibility(View.VISIBLE);
                btn_n.setVisibility(View.VISIBLE);
                if (count >= 4) {
                    tf.setVisibility(View.INVISIBLE);
                }
                if (count >= 6) {
                    coment.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    texquest.setVisibility(View.INVISIBLE);
                    af.setVisibility(View.INVISIBLE);
                    sf.setVisibility(View.INVISIBLE);
                    tf.setVisibility(View.INVISIBLE);
                    btn_n.setText("Закончить тест");
                }
                break;
            case R.id.btn_next :
                if(count == 0) {
                    if (af.isChecked()) {
                        coment.setText("Вы были близки к правильному ответу, но нет! Согласно правил безопасного пользования газом в быту Дети с 12-ти летнего возраста после проведения инструктажа могут быть допущены к самостоятельной работе с газовой плитой");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (sf.isChecked()) {
                        coment.setText("Браво! Вы абсолютно правы!");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.q1));
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.VISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    } else if (tf.isChecked()) {
                        coment.setText("Увы, но нет! Попробуйте ещё раз!");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    }
                } else if(count == 1) {
                    if (af.isChecked()) {
                        coment.setText("Вы абсолютно правы!");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.q2));
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.VISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    } else if (sf.isChecked()) {
                        coment.setText("Очень жаль, но всё немного иначе! Попробуйте снова.");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (tf.isChecked()) {
                        coment.setText("Ни в коем случае! Данного рода  занятия могут привести к очень плачевным результатам!!!");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    }
                } else if(count == 2) {
                    if (af.isChecked()) {
                        coment.setText("Вы шутите?");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (sf.isChecked()) {
                        coment.setText("Ни в коем случае! Данного рода  занятия могут привести к очень плачевным результатам!!!");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (tf.isChecked()) {
                        coment.setText("Если дома пахнет газом, Ты не спи и не скучай. Газ скорей перекрывай, окна шире открывай 104 набирай, службу газа вызывай!");
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    }
                } else if(count == 3) {
                    if (af.isChecked()) {
                        coment.setText("Правда? Давайте попробуем ещё раз");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (sf.isChecked()) {
                        coment.setText("Вы явно не стараетесь, ну же!");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (tf.isChecked()) {
                        coment.setText("Так держать! В случае необходимости замены газоиспользующего оборудования необходимо обратиться в газоснабжающую или обслуживающую организацию");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.q4));
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.VISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    }
                } else if(count == 4) {
                    if (af.isChecked()) {
                        coment.setText("Ни в коем случае!");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.q5));
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.VISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (sf.isChecked()) {
                        coment.setText("Абсолютно верно! Берегите себя и своих близких!");
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    }
                } else if(count == 5) {
                    if (af.isChecked()) {
                        coment.setText("Не совсем так!Хотя для выполнения ремонта вы обязаны обратиться в обслуживающую организацию");
                        coment.setBackgroundColor(Color.RED);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                    } else if (sf.isChecked()) {
                        coment.setText("Абсолютно точно! Своевременное обслуживание Вашего газоиспользующего оборудования, гарантия безопасной его эксплуатации");
                        coment.setBackgroundColor(Color.GREEN);
                        coment.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.INVISIBLE);
                        texquest.setVisibility(View.INVISIBLE);
                        af.setVisibility(View.INVISIBLE);
                        sf.setVisibility(View.INVISIBLE);
                        tf.setVisibility(View.INVISIBLE);
                        btn_n.setVisibility(View.INVISIBLE);
                        radGrp.clearCheck();
                        count++;
                    }
                } else if (count == 6) {
                    count++;
                    btn_n.setText("Вернуться на главный экран");
                    coment.setText("Благодарим Вас, что не отказались ответить на несколько вопросов! Теперь мы уверены что вы сможете проследить за своей безопасностью и безопасностью своих близких!");
                    coment.setBackgroundColor(Color.BLUE);
                    coment.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    texquest.setVisibility(View.INVISIBLE);
                    af.setVisibility(View.INVISIBLE);
                    sf.setVisibility(View.INVISIBLE);
                    tf.setVisibility(View.INVISIBLE);
                    btn_n.setVisibility(View.VISIBLE);
                } else if (count == 7) {
                    btn_n.setVisibility(View.INVISIBLE);
                    onBackPressed();
                }
                if (count < 6) {
                    texquest.setText(squest[count][0]);
                    af.setText(squest[count][1]);
                    sf.setText(squest[count][2]);
                    tf.setText(squest[count][3]);
                }
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}