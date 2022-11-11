package com.zimba.phonebook.entities

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "contacts")
class Contact(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @field:NotNull
    @field:Size(min = 3, max = 50, message = "Name must be bigger than 3 char.")
    var name: String,

    @field:NotNull
    @field:Email
    var email: String

)