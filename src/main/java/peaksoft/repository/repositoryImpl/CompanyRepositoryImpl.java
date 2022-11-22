package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("from Company", Company.class).getResultList();
    }

    @Override
    @Transactional
    public void addCompany(Company company) throws IOException {
        for (Character i: company.getCompanyName().toCharArray()) {
            if (!Character.isLetter(i)){
                throw new IOException("В название компании нельзя вставлять цифры");
            }
        }
        for (Character i: company.getLocatedCountry().toCharArray()) {
            if (!Character.isLetter(i)){
                throw new IOException("В название страны нельзя вставлять цифры");
            }
        }
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company) ? company : entityManager.merge(company));
    }
}
