package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface LessonMapper {
    @Mappings({
            @Mapping(target = "classCourse", ignore = true),
            @Mapping(target = "attendanceStudent", ignore = true)})
    Lesson toLesson(LessonDTO lessonDTO);
    @Mappings({
            @Mapping(target = "classCourse", ignore = true),
            @Mapping(target = "attendanceStudent", ignore = true)})
    LessonDTO toLessonDTO(Lesson lesson);
}
