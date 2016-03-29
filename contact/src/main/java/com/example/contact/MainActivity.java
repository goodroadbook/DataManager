package com.example.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button)this.findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);

        Button btnSelect = (Button) this.findViewById(R.id.btnselect);
        btnSelect.setOnClickListener(this);

        Button btnDel = (Button)this.findViewById(R.id.btndelete);
        btnDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent i = null;
        switch(v.getId())
        {
            case R.id.btnadd:
                i = new Intent(this, ContactAddActivity.class);
                startActivity(i);
                break;
            case R.id.btnselect:
                i = new Intent(this, ContactSelectActivity.class);
                startActivity(i);
                break;
            case R.id.btndelete:
                i = new Intent(this, ContactDelActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}
