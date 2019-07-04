package br.edu.utfpr.client.conversor;

import br.edu.utfpr.client.model.Lesson;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLessonConversor implements Converter<String, Lesson> {
	
	@Override
	public Lesson convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		try {
			return new Gson()
					.fromJson(
							Unirest
									.get("http://localhost:8081/api/lessons/{id}")
									.routeParam("id", String.valueOf(id))
									.asJson()
									.getBody()
									.toString(),
							Lesson.class
					);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
}
