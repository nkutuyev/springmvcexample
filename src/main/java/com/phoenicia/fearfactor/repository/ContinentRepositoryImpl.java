package com.phoenicia.fearfactor.repository;

import com.phoenicia.fearfactor.entity.Continent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Noel
 */
public class ContinentRepositoryImpl extends BaseHibernateRepository implements CustomContinentRepository {

    @Override
    @Transactional(readOnly = true)
    public List<Continent> getContinentTotalFearFactor() {
        Query query = entityManager.createQuery(
                "SELECT con, SUM(c.fearFactor) FROM Country c RIGHT JOIN c.continent con GROUP BY con.id");
        List<Object[]> resultList = query.getResultList();
        List<Continent> list = new ArrayList<Continent>();
        for(Object[] result: resultList){
            Continent con = (Continent) result[0];
            Long total = (Long)result[1];
            total = total == null ? 0 : total;
            con.setTotalFearFactor(total.intValue());
            list.add(con);
        }
        return list;
    }
    
}
