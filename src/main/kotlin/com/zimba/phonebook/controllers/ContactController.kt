package com.zimba.phonebook.controllers

import com.zimba.phonebook.entities.Contact
import com.zimba.phonebook.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController {

    @Autowired
    lateinit var repository: ContactRepository

    @GetMapping
    fun index(): List<Contact> {
        return repository.findAll()
    }

    @PostMapping
    fun create(@Valid @RequestBody contact: Contact): Contact {
        return repository.save(contact)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Contact {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @Valid @RequestBody newContact: Contact): Contact {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }

        contact.apply {
            this.name = newContact.name
            this.phoneNumber = newContact.phoneNumber
            this.email = newContact.email
        }
        return repository.save(contact)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(contact)
    }
}