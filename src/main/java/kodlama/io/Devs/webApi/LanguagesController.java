package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest){
		languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
		
	
	
	
	
	
}
