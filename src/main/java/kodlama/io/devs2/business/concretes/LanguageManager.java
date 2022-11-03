package kodlama.io.devs2.business.concretes;

import kodlama.io.devs2.business.abstracts.LanguageService;

import kodlama.io.devs2.business.requests.LanguageRequests.CreateLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.RemoveLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.UpdateLanguageRequest;
import kodlama.io.devs2.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlama.io.devs2.business.responses.LanguageResponses.GetByIdLanguageResponse;
import kodlama.io.devs2.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs2.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            if (createLanguageRequest.getName().equals(language.getName())) {
                System.out.println("The name cannot be repeated : " + createLanguageRequest.getName());
                return;
            }
        }
        if (createLanguageRequest.getName().equals("") || createLanguageRequest.getName() == null) {
            System.out.println("You cannot leave the name blank.");
        }
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        languageRepository.save(language);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = new Language();
        language.setId(updateLanguageRequest.getId());
        language.setName(updateLanguageRequest.getName());
        languageRepository.save(language);
    }

    @Override
    public void remove(RemoveLanguageRequest removeLanguageRequest) {
        languageRepository.deleteById(removeLanguageRequest.getId());
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguageResponse> languageResponses = new ArrayList<GetAllLanguageResponse>();

        for (Language language : languages) {
            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languageResponses.add(responseItem);
        }

        return languageResponses;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = languageRepository.getReferenceById(id);
        GetByIdLanguageResponse languageResponse = new GetByIdLanguageResponse();

        languageResponse.setId(language.getId());
        languageResponse.setName(language.getName());

        return languageResponse;
    }
}
