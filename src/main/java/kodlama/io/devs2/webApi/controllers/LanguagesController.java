package kodlama.io.devs2.webApi.controllers;
import kodlama.io.devs2.business.abstracts.LanguageService;
import kodlama.io.devs2.business.requests.LanguageRequests.CreateLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.RemoveLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.UpdateLanguageRequest;
import kodlama.io.devs2.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlama.io.devs2.business.responses.LanguageResponses.GetByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/remove")
    public void remove(RemoveLanguageRequest removeLanguageRequest) {
        languageService.remove(removeLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("getbyid")
    public GetByIdLanguageResponse getByIdLanguageResponse(int id) {
        return languageService.getById(id);
    }
}
