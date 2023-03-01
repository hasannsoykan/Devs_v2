package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());
		
		languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = languageRepository.findById(deleteLanguageRequest.getLanguageId()).get();
		language.setLanguageName(deleteLanguageRequest.getLanguageName());
		
		languageRepository.delete(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = languageRepository.findById(updateLanguageRequest.getLanguageId()).get();
		language.setLanguageName(updateLanguageRequest.getLanguageName());
		
		languageRepository.save(language);
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponses = new ArrayList<GetAllLanguagesResponse>();
		
		for(Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setLanguageId(language.getLanguageId());
			responseItem.setLanguageName(language.getLanguageName());
			languageResponses.add(responseItem);
		}
		
		return languageResponses;
	}



}
