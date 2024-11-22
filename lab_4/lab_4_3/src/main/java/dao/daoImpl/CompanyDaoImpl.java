package dao.daoImpl;

import dao.CompanyDao;
import entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryImpl;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    public CompanyDaoImpl() {}

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(company);
            tx.commit();
            isAdded = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(company);
            tx.commit();
            isUpdated = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Company company = session.get(Company.class, id);
            if (company != null) {
                session.delete(company);
                isDeleted = true;
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public Company findCompanyById(int id) {
        Company company = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            company = session.get(Company.class, id);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }

    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            company = (Company) session.createQuery("FROM Company WHERE companyName = :name")
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> companies = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            companies = session.createQuery("FROM Company", Company.class).list();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return companies;
    }
}
