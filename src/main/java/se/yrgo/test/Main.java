package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.*;

public class Main {

    private static SessionFactory sf = null;

    private static SessionFactory getSessionFactory() {
        if (sf == null) {
            Configuration config = new Configuration();
            config.configure();
            sf = config.buildSessionFactory();
        }

        return sf;
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Johan Johansson", 37000);
        Manager secondManager = new Manager("Daniel Danielsson", 40000);
        Employee firstEmployee = new Employee("Anders Andersson", 25000, "365-1223");
        Employee secondEmployee = new Employee("Birger Birgersson", 29000, "342-1231");
        Employee thirdEmployee = new Employee("Roger Andersson", 23000, "192-9882");
        Employee fourthEmployee = new Employee("Sonja Torsson", 29000, "292-9182");

        manager.addEmployeeToList(firstEmployee);
        manager.addEmployeeToList(secondEmployee);
        manager.addEmployeeToList(thirdEmployee);

        secondManager.addEmployeeToList(fourthEmployee);

        SessionFactory sf = getSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(manager);
        session.save(secondManager);
        session.save(firstEmployee);
        session.save(secondEmployee);
        session.save(thirdEmployee);
        session.save(fourthEmployee);

        // Code below tests to get manager from the DB and print their employees
        // Manager testManager = (Manager) session.get(Manager.class, 25);

        // for (Employee e : testManager.getEmployeeList()) {
        //     System.out.println(e.toString() + " Manager ID: " + testManager.getId());
        // }

        // Looks for a certain employee by name, easy to do by ID as well.
        // for(Employee e : testManager.getEmployeeList()) {
        //     if(e.getName().equalsIgnoreCase("Roger Andersson"))  {
        //         System.out.println(e.toString());
        //         break;
        //     }
        // }

        tx.commit();
        session.close();
    }
}