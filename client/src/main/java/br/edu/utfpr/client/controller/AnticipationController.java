package br.edu.utfpr.client.controller;

import br.edu.utfpr.client.model.ApprovalAnticipation;
import br.edu.utfpr.client.model.Lesson;
import br.edu.utfpr.client.model.ProposalAnticipation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/antecipacao")
public class AnticipationController {

    @GetMapping("/listar")
    public String listar(ModelMap model) throws JsonSyntaxException, UnirestException {
        ProposalAnticipation proposalAnticipations[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/anticipations")
                                .asJson()
                                .getBody()
                                .toString(),
                        ProposalAnticipation[].class
                );
        model.addAttribute("anticipation", proposalAnticipations);
        return "anticipation/list";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(ProposalAnticipation proposalAnticipation) {
        return "anticipation/register";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid ProposalAnticipation proposalAnticipation, BindingResult result, RedirectAttributes attr) throws UnirestException {

        if (result.hasErrors()) {
            return "anticipation/register";
        }

        Unirest.post("http://localhost:8081/api/anticipations")
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(proposalAnticipation, ProposalAnticipation.class))
                .asJson();

        attr.addFlashAttribute("success", "Proposta de antecipação inserida com sucesso.");
        return "redirect:/antecipacao/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) throws UnirestException {

        ApprovalAnticipation approvalAnticipations = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/anticipations/{id}/approvals")
                                .routeParam("id", String.valueOf(id))
                                .asJson()
                                .getBody()
                                .toString(),
                        ApprovalAnticipation.class
                );

        if(approvalAnticipations.getId() != 0){
            attr.addFlashAttribute("fail", "Antecipação não removida. Existe aprovação vinculada.");
        } else {
            Unirest
                    .delete("http://localhost:8081/api/anticipations/{id}")
                    .routeParam("id", String.valueOf(id))
                    .asJson();

            attr.addFlashAttribute("success", "Antecipação removida com sucesso.");
        }
        return "redirect:/antecipacao/listar";
    }

    @ModelAttribute("lessons")
    public Lesson[] getLessons() throws UnirestException {
        return new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/lessons")
                                .asJson()
                                .getBody()
                                .toString(),
                        Lesson[].class
                );
    }

    @ModelAttribute("modalities")
    public String[] getModalities() throws UnirestException {
        return new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/anticipations/modalities")
                                .asJson()
                                .getBody()
                                .toString(),
                        String[].class
                );
    }

    @ModelAttribute("reasons")
    public String[] getReasons() throws UnirestException {
        return new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/api/anticipations/reasons")
                                .asJson()
                                .getBody()
                                .toString(),
                        String[].class
                );
    }
}
