package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository  extends JpaRepository<Lesson, Long> {
}
