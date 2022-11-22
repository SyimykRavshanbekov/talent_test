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

//    @Override
//    public int countStudent(Long id) {
//        Company company = entityManager.find(Company.class, id);
//        int count = 0;
//            for (Group g: company.getGroups()) {
//                for (Student s: g.getStudents()) {
//                    count++;
//                }
//            }
//        return count;
//    }

    @Override
    @Transactional
    public void addCompany(Company company) {
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
