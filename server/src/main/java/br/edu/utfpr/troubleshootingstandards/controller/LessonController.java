package br.edu.utfpr.troubleshootingstandards.controller;

import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/lessons")
    public ResponseEntity<List<LessonDTO>> getAll() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @GetMapping ("/lessons/{id}")
    public ResponseEntity<LessonDTO> getById(@PathVariable Long id) {
        Optional<LessonDTO> lesson = lessonService.getById(id);
        return ResponseEntity.of(lesson);
    }
}
