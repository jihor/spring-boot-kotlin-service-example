@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class),
        @XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class)
})
package ru.jihor.example.model;

import ru.jihor.example.model.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;
import java.time.LocalDateTime;