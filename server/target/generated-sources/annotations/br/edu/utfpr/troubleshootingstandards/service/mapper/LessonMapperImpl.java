package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO.LessonDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson.LessonBuilder;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public Lesson toLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonBuilder lesson = Lesson.builder();

        lesson.id( lessonDTO.getId() );
        Set<String> set = lessonDTO.getType();
        if ( set != null ) {
            lesson.type( new HashSet<String>( set ) );
        }
        lesson.content( lessonDTO.getContent() );
        lesson.numberClasses( lessonDTO.getNumberClasses() );
        lesson.date( lessonDTO.getDate() );

        return lesson.build();
    }

    @Override
    public LessonDTO toLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTOBuilder lessonDTO = LessonDTO.builder();

        lessonDTO.id( lesson.getId() );
        Set<String> set = lesson.getType();
        if ( set != null ) {
            lessonDTO.type( new HashSet<String>( set ) );
        }
        lessonDTO.content( lesson.getContent() );
        lessonDTO.numberClasses( lesson.getNumberClasses() );
        lessonDTO.date( lesson.getDate() );

        return lessonDTO.build();
    }
}
