package android.com.sampleapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText2, editText3, editText4;
    LinearLayout layout1, layout2;
    List<EditText> texts1, texts2;
    List<Integer> textViews1, textViews2;
    private ViewGroupings viewGroupings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        editText2 = (EditText) findViewById(R.id.edit2);
        editText3 = (EditText) findViewById(R.id.edit3);
        editText4 = (EditText) findViewById(R.id.edit4);

        layout1 = (LinearLayout) findViewById(R.id.texts1);
        layout2 = (LinearLayout) findViewById(R.id.texts2);

        texts1 = new ArrayList<>();
        texts2 = new ArrayList<>();

        editText.setOnFocusChangeListener(new FocusClicklistener());
        editText.setTag(0);
        editText2.setOnFocusChangeListener(new FocusClicklistener());
        editText2.setTag(1);
        editText3.setOnFocusChangeListener(new FocusClicklistener());
        editText3.setTag(2);
        editText4.setOnFocusChangeListener(new FocusClicklistener());
        editText4.setTag(3);
        textViews1 = new ArrayList<>();
        textViews2 = new ArrayList<>();

        textViews1.add(0);
        textViews1.add(1);

        textViews2.add(2);
        textViews2.add(3);
        texts1.add(editText);
        texts1.add(editText2);

        texts1.add(editText3);
        texts1.add(editText4);
        viewGroupings = new ViewGroupings();
        viewGroupings.addGrouping(textViews1, 1);//down
        viewGroupings.addGrouping(textViews2, 2); //across
    }



    private class EditClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            view.setFocusable(true);
            view.setFocusable(true);
            view.requestFocus();
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
        }
    }
    private class FocusClicklistener implements View.OnFocusChangeListener {

        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            int i = (int) view.getTag(); //Position
            List<Integer> groups = viewGroupings.findGrouping(i,2); //

            if (hasFocus) {
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                for (Integer integer : groups) {
                    texts1.get(integer).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
                }
            }

            if (!hasFocus) {
                }else {
                    view.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }
        }
    }
}
