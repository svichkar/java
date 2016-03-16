package com.nixsolutions.studentgrade;

import com.nixsolutions.studentgrade.model.TestCase;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by konstantin on 3/16/2016.
 */
public class Main {

    public static void main (String[] args) throws Throwable {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        TestCase tc = new TestCase();
        session.save(tc);

        transaction.commit();

    }
}
