package kodlama.io.devs2.business.abstracts;

import kodlama.io.devs2.business.requests.LanguageRequests.CreateLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.RemoveLanguageRequest;
import kodlama.io.devs2.business.requests.LanguageRequests.UpdateLanguageRequest;
import kodlama.io.devs2.business.responses.LanguageResponses.GetAllLanguageResponse;
import kodlama.io.devs2.business.responses.LanguageResponses.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {
    void add(CreateLanguageRequest createLanguageRequest);

    void update(UpdateLanguageRequest updateLanguageRequest);

    void remove(RemoveLanguageRequest removeLanguageRequest);

    List<GetAllLanguageResponse> getAll();

    GetByIdLanguageResponse getById(int id);

}
