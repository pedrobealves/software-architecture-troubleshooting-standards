package br.edu.utfpr.client.controller;

import br.edu.utfpr.client.model.ProposalAnticipation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/antecipacao")
public class AnticipationController {

    @GetMapping("/listar")
    public String listar(ModelMap model) throws JsonSyntaxException, UnirestException {
        ProposalAnticipation proposalAnticipations[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/anticipation")
                                .asJson()
                                .getBody()
                                .toString(),
                        ProposalAnticipation[].class
                );
        model.addAttribute("anticipation", proposalAnticipations);
        return "anticipation/list";
    }
}
