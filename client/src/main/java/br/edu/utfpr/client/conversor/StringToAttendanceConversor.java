package br.edu.utfpr.client.conversor;

import br.edu.utfpr.client.model.AttendanceStudent;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAttendanceConversor implements Converter<String, AttendanceStudent> {
    @Override
    public AttendanceStudent convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        try {
            AttendanceStudent id1 = new Gson()
                    .fromJson(
                            Unirest
                                    .get("http://localhost:8081/api/attendances/{id}")
                                    .routeParam("id", String.valueOf(id))
                                    .asJson()
                                    .getBody()
                                    .toString(),
                            AttendanceStudent.class
                    );
            return id1;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
