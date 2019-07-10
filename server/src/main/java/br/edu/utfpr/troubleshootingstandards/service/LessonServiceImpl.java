package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.LessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    // get specific lesson by id
    public Optional<LessonDTO> getById(Long id) {
        return lessonRepository
                .findById(id)
                .map(l -> lessonMapper.toLessonDTO(l));
    }

    @Override
    // list of all lessons
    public List<LessonDTO> getAll() {
        return lessonMapper.toLessonDTO(lessonRepository.findAll());
    }
}
