/**
 * 
 */
package com.capgemini.storageService;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * 
 */
@Component("cloudService")
@Primary
@Scope("singleton")
public class CloudStorageService implements StorageService{
	
	public CloudStorageService() {
		System.out.println("CloudStorage Bean Created");
	}
	@PostConstruct
    public void init() {
        System.out.println("CloudStorageService Bean Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CloudStorageService Bean Destroyed");
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("File stored in Cloud Storage: " + fileName);
    }
}
