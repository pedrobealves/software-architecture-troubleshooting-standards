package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.model.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LessonMapper {
    Lesson toLesson(LessonDTO lessonDTO);
    LessonDTO toLessonDTO(Lesson lesson);
    List<LessonDTO> toLessonDTO(List<Lesson> lesson);
}
