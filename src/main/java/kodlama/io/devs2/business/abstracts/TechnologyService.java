package kodlama.io.devs2.business.abstracts;

import kodlama.io.devs2.business.requests.TechnologyRequests.CreateTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.RemoveTechnologyRequest;
import kodlama.io.devs2.business.requests.TechnologyRequests.UpdateTechnologyRequest;

import kodlama.io.devs2.business.responses.TechnologyResponses.GetAllTechnologyResponse;
import kodlama.io.devs2.business.responses.TechnologyResponses.GetByIdTechnologyResponse;

import java.util.List;

public interface TechnologyService {
    void add(CreateTechnologyRequest createTechnologyRequest);

    void update(UpdateTechnologyRequest updateTechnologyRequest);

    void remove(RemoveTechnologyRequest removeTechnologyRequest);

    List<GetAllTechnologyResponse> getAll();

    GetByIdTechnologyResponse getById(int id);

}
