package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	
	private TechnologyRepository technologyRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setTechnologyName(createTechnologyRequest.getTechnologyName());
		
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = technologyRepository.findById(deleteTechnologyRequest.getTechnologyId()).get();
		technology.setTechnologyName(deleteTechnologyRequest.getTechnologyName());
		
		technologyRepository.delete(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();
		technology.setTechnologyName(updateTechnologyRequest.getTechnologyName());
		
		technologyRepository.save(technology);
		
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {

		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologyResponses = new ArrayList<GetAllTechnologiesResponse>();
		
		for(Technology technology:technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setTechnologyId(technology.getTechnologyId());
			responseItem.setTechnologyName(technology.getTechnologyName());
			technologyResponses.add(responseItem);
		}
		
		return technologyResponses;
	}

}
