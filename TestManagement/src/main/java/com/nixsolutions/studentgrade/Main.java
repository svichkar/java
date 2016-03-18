package com.nixsolutions.studentgrade;

import com.nixsolutions.studentgrade.model.Priority;
import com.nixsolutions.studentgrade.model.TestCase;
import com.nixsolutions.studentgrade.model.Tester;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

/**
 * Created by konstantin on 3/16/2016.
 */
public class Main {

    public static void main (String[] args) throws Throwable {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Priority p = new Priority();
        p.setPriority("critical");
        session.save(p);

        Tester t = new Tester();
        t.setName("Konstantin");
        t.setLastName("Svichkar");
        session.save(t);

        TestCase tc = new TestCase();
        tc.setName("ReportService_test_1");
        tc.setAssertion("NotEmptyResult");
        tc.setDescription("Check that response is not empty");
        tc.setComment("bug#603");
        tc.setAdded(new Date(System.currentTimeMillis()));
        tc.setUpdated(new Date(System.currentTimeMillis()));
        tc.setPriority(p);
        tc.setTester(t);
        session.save(tc);

        transaction.commit();




    }
}
