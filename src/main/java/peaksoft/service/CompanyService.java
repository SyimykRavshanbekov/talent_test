package peaksoft.service;

import peaksoft.model.Company;

import java.io.IOException;
import java.util.List;
public interface CompanyService {
    List<Company> getAllCompanies();

    void addCompany(Company company) throws IOException;

//    int countStudent(Long id);

    Company getCompanyById(Long id);

    void updateCompany(Company company);

    void deleteCompany(Company company);
}
