package com.sda.manytomany;

import com.sda.manytomany.model.Orders;
import com.sda.manytomany.model.Products;
import com.sda.manytomany.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Orders order1 = new Orders();
        order1.setDateTime(LocalDate.of(2017, 11, 18));
        Orders order2 = new Orders();
        order2.setDateTime(LocalDate.of(2000, 6, 10));

        Products product1 = new Products();
        product1.setName("World of Warcraft");
        Products product2 = new Products();
        product2.setName("Heroes of the Storm");
        Products product3 = new Products();
        product3.setName("Hearthstone");
        Products product4 = new Products();
        product4.setName("Diablo III");

        // ORDER 1
        order1.getProductList().add(product1);
        order1.getProductList().add(product2);
        order1.getProductList().add(product3);
        order1.getProductList().add(product4);
        // ORDER 2
        order2.getProductList().add(product1);
        order2.getProductList().add(product2);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.save(order1);
        session.save(order2);

        session.getTransaction().commit();
        session.close();

    }
}
