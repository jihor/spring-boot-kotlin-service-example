package ru.jihor.example.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 07.07.2019
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v, FORMAT);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.format(FORMAT);
    }
}
