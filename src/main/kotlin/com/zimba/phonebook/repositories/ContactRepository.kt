package com.zimba.phonebook.repositories

import com.zimba.phonebook.entities.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository: JpaRepository<Contact, Int> {
}