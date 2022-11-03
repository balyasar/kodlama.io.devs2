package kodlama.io.devs2.business.concretes;
import kodlama.io.devs2.business.abstracts.LanguageService;
import kodlama.io.devs2.business.abstracts.TechnologyService;
import kodlama.io.devs2.business.requests.TechnologyRequests.CreateTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.RemoveTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs2.business.responses.LanguageResponses.GetByIdLanguageResponse;
import kodlama.io.devs2.business.responses.TechnologyResponses.GetAllTechnologyResponse;
import kodlama.io.devs2.business.responses.TechnologyResponses.GetByIdTechnologyResponse;
import kodlama.io.devs2.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs2.entities.Language;
import kodlama.io.devs2.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private LanguageService languageService;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        Language language = new Language();
        GetByIdLanguageResponse getByIdLanguageResponse = languageService.getById(createTechnologyRequest.getLanguageId());

        language.setId(getByIdLanguageResponse.getId());
        language.setName(getByIdLanguageResponse.getName());

        technology.setName(createTechnologyRequest.getName());
        technology.setLanguage(language);

        technologyRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = new Technology();
        Language language = new Language();
        GetByIdLanguageResponse getByIdLanguageResponse = languageService.getById(updateTechnologyRequest.getLanguageId());

        language.setId(getByIdLanguageResponse.getId());
        language.setName(getByIdLanguageResponse.getName());

        technology.setName(updateTechnologyRequest.getName());
        technology.setId(updateTechnologyRequest.getId());
        technology.setLanguage(language);

        technologyRepository.save(technology);
    }

    @Override
    public void remove(RemoveTechnologyRequest removeTechnologyRequest) {
        technologyRepository.deleteById(removeTechnologyRequest.getId());
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> technologyResponses = new ArrayList<>();

        for (Technology technology : technologies) {
            GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            technologyResponses.add(responseItem);
        }
        return technologyResponses;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Technology technology = technologyRepository.getReferenceById(id);
        GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();

        responseItem.setId(technology.getId());
        responseItem.setName(technology.getName());

        return responseItem;
    }
}
