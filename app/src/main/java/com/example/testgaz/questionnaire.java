package com.example.testgaz;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class questionnaire extends AppCompatActivity implements View.OnClickListener {

    String[][] squest;
    int count = 0;
    Button btn_n;
    TextView texquest, textdialog;
    RadioGroup radGrp;
    RadioButton af, sf, tf;
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
        if(count == 0) {
            if (af.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Вы были близки к правильному ответу, но нет! Согласно правил безопасного пользования газом в быту Дети с 12-ти летнего возраста после проведения инструктажа могут быть допущены к самостоятельной работе с газовой плитой");
            } else if (sf.isChecked()) {
                createOneButtonAlertDialog(Color.GREEN, "Браво! Вы абсолютно правы!");
                radGrp.clearCheck();
                count++;
            } else if (tf.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Увы, но нет! Попробуйте ещё раз!");
            }
        } else if(count == 1) {
            if (af.isChecked()) {
                createOneButtonAlertDialog(Color.GREEN, "Вы абсолютно правы!");
                radGrp.clearCheck();
                count++;
            } else if (sf.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Очень жаль, но всё немного иначе! Попробуйте снова.");
            } else if (tf.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Ни в коем случае! Данного рода  занятия могут привести к очень плачевным результатам!!!");
            }
        } else if(count == 2) {
            if (af.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Вы шутите?");
            } else if (sf.isChecked()) {
                createOneButtonAlertDialog(Color.RED, "Неа! Мы думаем что после усвоения инструктажа, Вам данный номер использовать не придётся, относительно газа");
            } else if (tf.isChecked()) {
                createOneButtonAlertDialog(Color.GREEN, "Если дома пахнет газом, Ты не спи и не скучай. Газ скорей перекрывай, окна шире открывай 104 набирай, службу газа вызывай!");
                radGrp.clearCheck();
                count++;
                texquest.setVisibility(View.INVISIBLE);
                af.setVisibility(View.INVISIBLE);
                sf.setVisibility(View.INVISIBLE);
                tf.setVisibility(View.INVISIBLE);
                btn_n.setText("Закончить тест");

            }
        } else if (count == 3) {
            count++;
            btn_n.setText("Вернуться на главный экран");
            createOneButtonAlertDialog(Color.BLUE, "Благодарим Вас, что не отказались ответить на несколько вопросов! Теперь мы уверены что вы сможете проследить за своей безопасностью и безопасностью своих близких!");

        } else if (count == 4) {
            btn_n.setVisibility(View.INVISIBLE);
            onBackPressed();
        }
        if (count < 3) {
            texquest.setText(squest[count][0]);
            af.setText(squest[count][1]);
            sf.setText(squest[count][2]);
            tf.setText(squest[count][3]);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void createOneButtonAlertDialog(int color, String content) {
        textdialog = new TextView(this);
        textdialog.setText(content);
        textdialog.setBackgroundColor(color);
        textdialog.setPadding(10, 10, 10, 10);
        textdialog.setGravity(Gravity.CENTER);
        textdialog.setTextColor(Color.WHITE);
        textdialog.setTextSize(40);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(textdialog);
        builder.show();
    }
}