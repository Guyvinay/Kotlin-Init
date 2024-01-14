package com.app.UserRegistrationKotlin.modals

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity
class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var _id: String? = null

    @field:NotBlank
    var username: String? = null

    @field:NotBlank
    @field:Email
    var email: String? = null

    @field:NotBlank
    var password : String? = null
}