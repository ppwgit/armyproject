package com.solvd.lab.army.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date unmarshal(String dateString) throws Exception {
        return dateFormat.parse(dateString);
    }

    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
}