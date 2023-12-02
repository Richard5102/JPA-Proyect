package com.example.Main;

import com.example.Util.UtilEntity;
import com.example.entity.Employee;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.persistence.EntityManager;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();

        List<Employee> employees = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        System.out.println("*** Listar todos ***");
        employees.forEach(System.out::println);

        int employeeId = 3;

        System.out.println("********* BUSCAR UNO **********");
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empledo encontrado "+ employee);

        System.out.println("********** CREAR UNO *********");
        Employee newemployee = new Employee();

        newemployee.setFirstName("Diego");
        newemployee.setPaSurname("Lechuga");
        newemployee.setMaSurname("Pimentel");
        newemployee.setEmail("diego@example.com");
        newemployee.setSalary(89000F);

         em.getTransaction().begin();
         em.persist(newemployee);
         em.getTransaction().commit();

        System.out.println("Nuevo empleado creado" + newemployee);
    }
}
