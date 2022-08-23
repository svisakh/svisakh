package com.viz.udemy.brewery201.brewery.web.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class DateMapper {
public OffsetDateTime asOffsetDateTime(Timestamp ts) {
	if(ts != null) {
		
		LocalDateTime tsLdt = ts.toLocalDateTime();
		return OffsetDateTime.of(tsLdt.getYear(), tsLdt.getMonthValue(),tsLdt.getDayOfMonth(),
				tsLdt.getHour(), tsLdt.getMinute(), tsLdt.getSecond(),tsLdt.getNano(),ZoneOffset.UTC);
	}
	else 
		return null;
}


public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
	if(offsetDateTime != null) {
		return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
	}
	return null;
}

}
