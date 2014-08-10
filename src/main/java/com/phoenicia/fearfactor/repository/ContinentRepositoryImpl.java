package com.phoenicia.fearfactor.repository;

import com.phoenicia.fearfactor.entity.Continent;
import com.phoenicia.fearfactor.entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Noel
 */
public class ContinentRepositoryImpl extends BaseHibernateRepository implements CustomContinentRepository {

    @Override
    public List<Continent> getContinentTotalFearFactor() {
        TypedQuery<Continent> query = entityManager.createQuery("SELECT con FROM Continent con", Continent.class);
        List<Continent> list = new ArrayList<Continent>();
        for(Continent continent: query.getResultList()){
            TypedQuery<Country> cQuery = entityManager.createQuery(
                    "SELECT con FROM Country con WHERE con.continent = :c", Country.class);
            List<Country> countries = cQuery.setParameter("c", continent).getResultList();
            int total = 0;
            for(Country country: countries){
                total += country.getFearFactor();
            }
            continent.setTotalFearFactor(total);
            list.add(continent);
        }
        return list;
    }
    
}
