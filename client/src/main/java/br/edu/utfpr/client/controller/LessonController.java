package br.edu.utfpr.client.controller;

import br.edu.utfpr.client.model.Lesson;
import br.edu.utfpr.client.util.RestUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aula")
public class LessonController {
    @Autowired
    private RestUtil restUtil;

    @GetMapping("/listar")
    public String listar(ModelMap model) throws JsonSyntaxException, UnirestException {
        Lesson[] lessons = new Gson()
                .fromJson(
                        restUtil.doGet("lessons"),
                        Lesson[].class
                );
        model.addAttribute("lesson", lessons);
        return "lesson/list";
    }

}
