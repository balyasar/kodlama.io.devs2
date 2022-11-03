package kodlama.io.devs2.webApi.controllers;

import kodlama.io.devs2.business.abstracts.TechnologyService;
import kodlama.io.devs2.business.requests.TechnologyRequests.CreateTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.RemoveTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs2.business.responses.TechnologyResponses.GetAllTechnologyResponse;
import kodlama.io.devs2.business.responses.TechnologyResponses.GetByIdTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        technologyService.add(createTechnologyRequest);
    }

    @PutMapping("update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/remove")
    public void remove(RemoveTechnologyRequest removeTechnologyRequest) {
        technologyService.remove(removeTechnologyRequest);
    }

    @GetMapping("/getall")
    List<GetAllTechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("getbyid")
    GetByIdTechnologyResponse getByIdTechnologyResponse(int id) {
        return technologyService.getById(id);
    }
}
