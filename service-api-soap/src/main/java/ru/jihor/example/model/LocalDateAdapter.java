package ru.jihor.example.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ISO_DATE;

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, FORMAT);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(FORMAT);
    }
}
