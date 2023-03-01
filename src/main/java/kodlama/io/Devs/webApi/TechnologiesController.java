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

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest){
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return technologyService.getAll();
	}
	
	
}
