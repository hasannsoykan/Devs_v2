package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest) ;
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
	List<GetAllLanguagesResponse> getAll();
}
