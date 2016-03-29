package com.example.contact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactAddActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_add);

        Button addButton = (Button)
        this.findViewById(R.id.btnadd);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int result = 0;
        switch(v.getId())
        {
            case R.id.btnadd:
                insertDB();
                break;
            default:
                break;
        }
    }


    private int insertDB()
    {
        int result 		= 0;
        String nameStr		= null;
        String phonenumStr	= null;
        String emailStr	= null;

        EditText nameEdit = (EditText)
        this.findViewById(R.id.nameedit);
        nameStr = nameEdit.getEditableText().toString();

        EditText phonenumEdit = (EditText)
        this.findViewById(R.id.phonenumberedit);
        phonenumStr = phonenumEdit.getEditableText().toString();

        EditText emailEdit = (EditText)
        this.findViewById(R.id.emailedit);
        emailStr = emailEdit.getEditableText().toString();

        ContactData cData = new ContactData(nameStr,
        phonenumStr,
        emailStr);

        DBManager dbMgr = new DBManager(this);
        dbMgr.dbOpen();
        dbMgr.insertData(DBSqlData.SQL_DB_INSERT_DATA, cData);
        dbMgr.dbClose();

        return result;
    }
}


