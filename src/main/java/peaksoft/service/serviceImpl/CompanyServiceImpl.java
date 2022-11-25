package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.io.IOException;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public void addCompany(Company company) throws IOException {
        if (company.getCompanyName().toLowerCase().length()>2 && company.getLocatedCountry().toLowerCase().length()>2) {
            for (Character i : company.getCompanyName().toLowerCase().toCharArray()) {
                if (!Character.isLetter(i)) {
                    throw new IOException("В названи компании нельзя вставлять цифры или символы");
                }
            }
            for (Character i : company.getLocatedCountry().toLowerCase().toCharArray()) {
                if (!Character.isLetter(i)) {
                    throw new IOException("В названии страны нельзя вставлять цифры или символы");
                }
            }
        }else {
            throw new IOException("В название компании или страны должно быть как минимум 2 буквы");
        }
        companyRepository.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company) throws IOException {
        if (company.getCompanyName().toLowerCase().length()>2 && company.getLocatedCountry().toLowerCase().length()>2) {
            for (Character i : company.getCompanyName().toLowerCase().toCharArray()) {
                if (!Character.isLetter(i)) {
                    throw new IOException("В названи компании нельзя вставлять цифры");
                }
            }
            for (Character i : company.getLocatedCountry().toLowerCase().toCharArray()) {
                if (!Character.isLetter(i)) {
                    throw new IOException("В названии страны нельзя вставлять цифры");
                }
            }
        }else {
            throw new IOException("В название компании или страны должно быть как минимум 2 буквы");
        }
        companyRepository.updateCompany(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.deleteCompany(company);
    }
}
