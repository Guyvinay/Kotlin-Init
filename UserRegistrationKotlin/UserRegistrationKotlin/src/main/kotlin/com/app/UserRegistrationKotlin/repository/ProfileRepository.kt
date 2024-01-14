package com.app.UserRegistrationKotlin.repository

import com.app.UserRegistrationKotlin.modals.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, String> {
}