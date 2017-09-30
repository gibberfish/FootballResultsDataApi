package mindbadger.football.api.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import mindbadger.football.api.model.KatharsisDivision;
import mindbadger.football.api.model.KatharsisSeason;
import mindbadger.football.domain.Division;
import mindbadger.football.domain.Season;
import mindbadger.football.repository.DivisionRepository;
import mindbadger.football.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Component
public class KatharsisSeasonRepositoryImpl extends ResourceRepositoryBase<KatharsisSeason, Integer> 
	implements KatharsisSeasonRepository {

	protected KatharsisSeasonRepositoryImpl() {
		super(KatharsisSeason.class);
	}

	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public synchronized ResourceList<KatharsisSeason> findAll(QuerySpec querySpec) {
		Iterable<Season> seasons = seasonRepository.findAll();
		
    	List<KatharsisSeason> katharsisSeasons = new ArrayList<KatharsisSeason> ();
    	for (Season season : seasons) {
    		katharsisSeasons.add(new KatharsisSeason(season));
    	}
		
		
		return querySpec.apply(katharsisSeasons);
	}
}
