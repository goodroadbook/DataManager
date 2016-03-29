package com.example.contact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactSelectActivity extends AppCompatActivity

{
    private ListView mListViewLayout			= null;
    private ListArrayAdapter mListArrayAdapter	= null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_select);

        ArrayList<ContactData> cDataList = new ArrayList<ContactData>();
        getContactDBData(cDataList);

        mListArrayAdapter = new ListArrayAdapter(this,
                                                    R.id.list_item,
                                                    cDataList);
        mListViewLayout = (ListView)
        this.findViewById(R.id.listView);
        mListViewLayout.setAdapter(mListArrayAdapter);
    }

    private void getContactDBData(ArrayList<ContactData> aCDataList)
    {
        DBManager dbMgr = new DBManager(this);
        dbMgr.dbOpen();
        dbMgr.selectAll(DBSqlData.SQL_DB_SELECT_ALL, aCDataList);
        dbMgr.dbClose();
    }
}