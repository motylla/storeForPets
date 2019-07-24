package pl.sda.storeforpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.storeforpets.model.ContactMe;
import pl.sda.storeforpets.repository.ContactMeRepository;

import java.util.List;

@Service
public class ContactMeService {
    private ContactMeRepository contactMeRepository;

    @Autowired
    public ContactMeService(ContactMeRepository contactMeRepository) {
        this.contactMeRepository = contactMeRepository;
    }

    public void saveContactMessage(ContactMe contactMe) {
        contactMeRepository.save(contactMe);
    }

    public List<ContactMe> showAllMessages(){
        return contactMeRepository.findAll();
    }
}
