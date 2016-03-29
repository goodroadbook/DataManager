package com.example.contact;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListArrayAdapter extends ArrayAdapter<ContactData>
{
    private ViewHolder mViewHolder = null;
    private LayoutInflater mInflater	= null;

    class ViewHolder
    {
        public TextView name = null;
        public TextView phonenumber = null;
        public TextView email	= null;
    }

    public ListArrayAdapter(Context aContext, int aResource,
                            List<ContactData> aCData)
    {
        super(aContext, aResource, aCData);

        this.mInflater = (LayoutInflater)
                aContext.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertview,
                        ViewGroup parent)
    {
        View v = convertview;

        if(v == null)
        {
            mViewHolder = new ViewHolder();
            v = mInflater.inflate(R.layout.list_item, null);
            mViewHolder.name = (TextView)
                    v.findViewById(R.id.nametxt);
            mViewHolder.phonenumber = (TextView)
                    v.findViewById(R.id.phonenumbertxt);
            mViewHolder.email = (TextView)
                    v.findViewById(R.id.emailtxt);

            v.setTag(mViewHolder);
        }
        else
        {
            mViewHolder = (ViewHolder)v.getTag();
        }

        mViewHolder.name.setText(getItem(position).getName());	mViewHolder.phonenumber.setText(
            getItem(position).getPhoneNumber());
        mViewHolder.email.setText(
                getItem(position).getEmailAddr());

        return v;
    }

    @Override
    public int getCount()
    {
        return super.getCount();
    }

    @Override
    public ContactData getItem(int position)
    {
        return super.getItem(position);
    }
}


