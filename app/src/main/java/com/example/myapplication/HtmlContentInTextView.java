package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class HtmlContentInTextView extends AppCompatActivity {
private TextView textView;
private String myText = "<h1>This is heading 1 </h1>\n"+
            "<h1>This is heading 1 </h1>\n"+
            "<h2>This is heading 2 </h2>\n"+
            "<h3>This is heading 3 </h3>\n"+
            "<p>This is paragraph </p>\n"+
            "<p><u>This is an underline paragraph</u> </p>\n"+
            "<p><b>This is a bold paragraph</b> </p>\n"+
            "<p><i>This is an italic paragraph</i> </p>\n"+
            "<h1><u>order List start</u> </h1>\n"+
            "<ol>\n"+
            "<li>C programming language </li>\n"+
            "<li>Java programming language </li>\n"+
            "<li>C++ programming language </li>\n"+
            "<li>R programming language </li>\n"+
            "</ol>\n\n"+
            "(a+b)<sup>2</sup> = a<sup>2</sup>+2ab+b<sup>2</sup> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_content_in_text_view);
        textView = findViewById(R.id.htmlTextId);

        textView.setText(Html.fromHtml(myText));

    }
}