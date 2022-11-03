package kodlama.io.devs2.business.responses.LanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageResponse {
    private int id;
    private String name;
}
