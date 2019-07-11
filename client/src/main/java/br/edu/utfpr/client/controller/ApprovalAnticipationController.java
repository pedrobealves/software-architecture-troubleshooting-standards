package br.edu.utfpr.client.controller;

import br.edu.utfpr.client.model.ApprovalAnticipation;
import br.edu.utfpr.client.model.AttendanceStudent;
import br.edu.utfpr.client.model.ProposalAnticipation;
import br.edu.utfpr.client.util.RestUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/aprovacao")
public class ApprovalAnticipationController {

    @Autowired
    private RestUtil restUtil;

    @GetMapping("/listar")
    public String listar(ModelMap model) throws JsonSyntaxException, UnirestException {
        ApprovalAnticipation[] approvalAnticipations = new Gson()
                .fromJson(
                        restUtil.doGet("approvals"),
                        ApprovalAnticipation[].class
                );
        model.addAttribute("approval", approvalAnticipations);
        return "approval/list";
    }

    @GetMapping("/cadastrar")
    public String register(ModelMap model, ApprovalAnticipation approvalAnticipation) throws UnirestException {
        ProposalAnticipation[] proposalAnticipations = new Gson()
                .fromJson(
                        restUtil.doGet("anticipations"),
                        ProposalAnticipation[].class
                );
        model.addAttribute("anticipation", proposalAnticipations);
        return "approval/register";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid ApprovalAnticipation approvalAnticipation, BindingResult result, RedirectAttributes attr) throws UnirestException {
        ApprovalAnticipation approvalAnticipations = new Gson()
                .fromJson(
                        restUtil.doGetById("anticipations/{id}/approvals", approvalAnticipation.getProposalAnticipation().getId()),
                        ApprovalAnticipation.class
                );
        if(approvalAnticipations.getId() != null){
            attr.addFlashAttribute("fail", "Já foi submetido uma lista");
            return "redirect:/aprovacao/cadastrar";
        }
        return getString(approvalAnticipation, result, attr);
    }

    private String getString(@Valid ApprovalAnticipation approvalAnticipation, BindingResult result, RedirectAttributes attr) throws UnirestException {
        if (result.hasErrors()) {
            return "approval/register";
        }

        ProposalAnticipation proposalAnticipation = new Gson()
                .fromJson(
                        restUtil.doGetById("anticipations/{id}", approvalAnticipation.getProposalAnticipation().getId()),
                        ProposalAnticipation.class
                );

        approvalAnticipation.setProposalAnticipation(proposalAnticipation);

        HttpResponse<JsonNode> response = restUtil.doPost(new Gson().toJson(approvalAnticipation, ApprovalAnticipation.class), "approvals");

        if ((response.getStatus() != 200 && response.getStatus() != 201)) {
            attr.addFlashAttribute("fail",response.getBody().getObject().getJSONObject("subError").getString("message"));
            return "redirect:/aprovacao/cadastrar";
        }

        attr.addFlashAttribute("success", "Aprovação de antecipação inserida com sucesso.");

        return "redirect:/aprovacao/listar";
    }


    @GetMapping("/cadastrar/{id}")
    @ResponseBody
    public ProposalAnticipation registerBy(@PathVariable("id") Long id) throws UnirestException {
        ProposalAnticipation proposalAnticipation = new Gson()
                .fromJson(
                        restUtil.doGetById("anticipations/{id}", id),
                        ProposalAnticipation.class
                );
        return proposalAnticipation;
    }

    @ModelAttribute("attendances")
    public AttendanceStudent[] getLessons() throws UnirestException {
        return new Gson()
                .fromJson(
                        restUtil.doGet("attendances"),
                        AttendanceStudent[].class
                );
    }


}
