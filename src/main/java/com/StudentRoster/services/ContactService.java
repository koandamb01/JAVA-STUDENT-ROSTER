package com.StudentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentRoster.models.Contact;
import com.StudentRoster.repositories.ContactRepository;

@Service
public class ContactService {
	private final ContactRepository contactRepo;
	
	public ContactService(ContactRepository contactRepo) { this.contactRepo = contactRepo; }
	
	// create a new Contact
	public Contact createContact(Contact contact) { return this.contactRepo.save(contact); }
	
	// Retrieves all contacts
	public List<Contact> findAllContacts(){ return this.contactRepo.findAll(); }
	
	// Retrieves a contact by ID
	public Contact findContactById(Long id) {
		Optional<Contact> response = this.contactRepo.findById(id);
		if(response.isPresent()) {
			return response.get();
		}
		else {
			return null;
		}
	}
}
