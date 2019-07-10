package br.edu.utfpr.client.controller;

import br.edu.utfpr.client.util.RestUtil;
import br.edu.utfpr.client.model.ApprovalAnticipation;
import br.edu.utfpr.client.model.Lesson;
import br.edu.utfpr.client.model.ProposalAnticipation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/antecipacao")
public class AnticipationController {

    @Autowired
    private RestUtil restUtil;

    @GetMapping("/listar")
    public String listar(ModelMap model) throws JsonSyntaxException, UnirestException {
        ProposalAnticipation[] proposalAnticipations = new Gson()
                .fromJson(
                        restUtil.doGet("anticipations"),
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
        return getString(proposalAnticipation, result, attr);
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) throws UnirestException {
        ProposalAnticipation proposalAnticipation = new Gson()
                .fromJson(
                        restUtil.doGetById("anticipations/{id}", id),
                        ProposalAnticipation.class
                );
        model.addAttribute("proposalAnticipation",proposalAnticipation);
        return "anticipation/register";
    }

    @PostMapping("/editar")
    public String editar(@Valid ProposalAnticipation proposalAnticipation, BindingResult result, RedirectAttributes attr) throws UnirestException {
        return getString(proposalAnticipation, result, attr);
    }

    private String getString(@Valid ProposalAnticipation proposalAnticipation, BindingResult result, RedirectAttributes attr) throws UnirestException {
        if (result.hasErrors()) {
            return "anticipation/register";
        }

        HttpResponse<JsonNode> response = restUtil.doPost(new Gson().toJson(proposalAnticipation, ProposalAnticipation.class), "anticipations");

        if ((response.getStatus() != 200 && response.getStatus() != 201)) {
            result.rejectValue(
                    response.getBody().getObject().getJSONObject("subError").getString("field"),
                    "error.proposalAnticipation",
                    response.getBody().getObject().getJSONObject("subError").getString("message"));
            return "anticipation/register";
        }

        attr.addFlashAttribute("success", "Proposta de antecipação inserida com sucesso.");

        return "redirect:/antecipacao/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) throws UnirestException {

        ApprovalAnticipation approvalAnticipations = new Gson()
                .fromJson(
                        restUtil.doGetById("anticipations/{id}/approvals", id),
                        ApprovalAnticipation.class
                );

        if(approvalAnticipations.getId() != null){
            attr.addFlashAttribute("fail", "Antecipação não removida. Existe aprovação vinculada.");
        } else {
            restUtil.doDelete("anticipations/{id}", id);
            attr.addFlashAttribute("success", "Antecipação removida com sucesso.");
        }
        return "redirect:/antecipacao/listar";
    }

    @ModelAttribute("lessons")
    public Lesson[] getLessons() throws UnirestException {
        return new Gson()
                .fromJson(
                        restUtil.doGet("lessons"),
                        Lesson[].class
                );
    }

    @ModelAttribute("modalities")
    public String[] getModalities() throws UnirestException {
        return new Gson()
                .fromJson(
                        restUtil.doGet("anticipations/modalities"),
                        String[].class
                );
    }

    @ModelAttribute("reasons")
    public String[] getReasons() throws UnirestException {
        return new Gson()
                .fromJson(
                        restUtil.doGet("anticipations/reasons"),
                        String[].class
                );
    }
}
