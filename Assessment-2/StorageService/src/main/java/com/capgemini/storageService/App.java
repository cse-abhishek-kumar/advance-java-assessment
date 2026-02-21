package com.capgemini.storageService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("---- Container Started ----");

        StorageService storageService = context.getBean(StorageService.class);
        storageService.storeFile("document1.txt");

        System.out.println("\n---- Getting localStorage bean first time ----");
        StorageService local1 =
                context.getBean("localStorage", StorageService.class);
        local1.storeFile("localFile1.txt");

        System.out.println("\n---- Getting localStorage bean second time ----");
        StorageService local2 =
                context.getBean("localStorage", StorageService.class);
        local2.storeFile("localFile2.txt");

        context.close();
	}
}
