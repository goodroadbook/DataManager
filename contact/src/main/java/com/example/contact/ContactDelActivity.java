package com.example.contact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactDelActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    private ListView mListViewLayout			= null;
    private ListArrayAdapter mListArrayAdapter	= null;
    private ArrayList<ContactData> mCDataList	= null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_delete);

        mCDataList = new ArrayList<ContactData>();
        getContactDBData(mCDataList);

        mListArrayAdapter = new ListArrayAdapter(this,
        R.id.list_item,
        mCDataList);
        mListViewLayout = (ListView)
        this.findViewById(R.id.listView);
        mListViewLayout.setAdapter(mListArrayAdapter);
        mListViewLayout.setOnItemClickListener(this);
    }

    private void getContactDBData(ArrayList<ContactData> aCDataList)
    {
        DBManager dbMgr = new DBManager(this);
        dbMgr.dbOpen();
        dbMgr.selectAll(DBSqlData.SQL_DB_SELECT_ALL,
        aCDataList);
        dbMgr.dbClose();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        DBManager dbMgr = new DBManager(this);
        dbMgr.dbOpen();
        dbMgr.deleteData(DBSqlData.SQL_DB_DELETE_DATA,
        mListArrayAdapter.getItem(position));
        dbMgr.dbClose();

        mCDataList.remove(position);

        mListArrayAdapter.notifyDataSetChanged();
    }
}

