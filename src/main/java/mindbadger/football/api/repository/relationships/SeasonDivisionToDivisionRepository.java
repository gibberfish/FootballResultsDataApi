package mindbadger.football.api.repository.relationships;

import mindbadger.football.api.repository.CrnkDivisionRepository;
import mindbadger.football.api.util.SourceIdUtils;
import mindbadger.football.domain.Division;
import mindbadger.football.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.RelationshipRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import mindbadger.football.api.model.CrnkDivision;
import mindbadger.football.api.model.CrnkSeasonDivision;

@Component
public class SeasonDivisionToDivisionRepository extends RelationshipRepositoryBase<CrnkSeasonDivision, String, CrnkDivision, String> {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    public SeasonDivisionToDivisionRepository (CrnkDivisionRepository divisionRepository) {
    	super (CrnkSeasonDivision.class, CrnkDivision.class);
    }
    
    @Override
    public CrnkDivision findOneTarget(String sourceId, String fieldName, QuerySpec querySpec) {
        String divisionId = SourceIdUtils.parseDivisionId(sourceId);
        Division division = divisionRepository.findOne(divisionId);
    	return new CrnkDivision(division);
    }

    @SuppressWarnings("unchecked")
	@Override
    public ResourceList<CrnkDivision> findManyTargets(String sourceId, String fieldName, QuerySpec querySpec) {
    	CrnkDivision division = findOneTarget(sourceId, fieldName, querySpec);
    	return querySpec.apply((Iterable<CrnkDivision>) division);
    }
    
//    @Override
//    protected CrnkDivision getTarget(String targetId) {
//        return super.getTarget(targetId);
//    }

    @Override
    protected Iterable<CrnkDivision> getTargets(Iterable<String> targetIds) {
        return super.getTargets(targetIds);
    }

    @Override
    public Class<CrnkSeasonDivision> getSourceResourceClass() {
        return CrnkSeasonDivision.class;
    }

    @Override
    public Class<CrnkDivision> getTargetResourceClass() {
        return CrnkDivision.class;
    }
}
