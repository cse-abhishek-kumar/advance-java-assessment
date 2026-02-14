/**
 * 
 */
package com.capgemini.assessment.employee_IDCard_Management_System;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("idEmpPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee e1 = new Employee("John","john@example.com");
		IDCard id1 = new IDCard("IDC101",LocalDate.now());
		
		e1.setIdCard(id1);
		
		em.persist(e1);
		
		em.getTransaction().commit();
		
		System.out.println("Employee Created Successfully\n");
		
		Employee fetchEmp = em.find(Employee.class, 1);
		
		System.out.println("Employee Details: ");
		System.out.println("ID: "+fetchEmp.getId());
		System.out.println("Name: "+fetchEmp.getName());
		System.out.println("Email: "+fetchEmp.getEmail());
		
		System.out.println("\nID Card Details: ");
		System.out.println("Card Number: "+fetchEmp.getIdCard().getCardNumber());
		System.out.println("Issue Date: "+fetchEmp.getIdCard().getIssueDate());
		
		em.close();
		emf.close();
	}
}
