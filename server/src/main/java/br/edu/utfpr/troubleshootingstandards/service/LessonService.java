package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    Optional<LessonDTO> getById(Long id);
    List<LessonDTO> getAll();
}
