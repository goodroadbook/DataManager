package com.example.contact;

public class ContactData
{
    private String mName		= null;
    private String mPhoneNumber	= null;
    private String mEmailAddr		= null;

    public ContactData(String aName, String aPhoneNumber, String aEmailAddr)
    {
        this.mName = aName;
        this.mPhoneNumber = aPhoneNumber;
        this.mEmailAddr = aEmailAddr;
    }

    public String getName()
    {
        return this.mName;
    }

    public String getPhoneNumber()
    {
        return this.mPhoneNumber;
    }

    public String getEmailAddr()
    {
        return this.mEmailAddr;
    }

    public String[] getCDataArray()
    {
        String[] cData = {
                    this.mName,
                    this.mPhoneNumber,
                    this.mEmailAddr
        };
        return cData;
    }
}
