package br.edu.utfpr.client.conversor;

import br.edu.utfpr.client.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLessonConversor implements Converter<String, Lesson> {
	
	@Override
	public Lesson convert(String text) {
		/*if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);*/
		return null;
	}
}
