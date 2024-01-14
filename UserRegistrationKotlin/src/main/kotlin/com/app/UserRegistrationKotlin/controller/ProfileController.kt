package com.app.UserRegistrationKotlin.controller

import com.app.UserRegistrationKotlin.modals.Profile
import com.app.UserRegistrationKotlin.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profiles")
class ProfileController @Autowired
    constructor(
        private val profileService: ProfileService
    ){

        @PostMapping
        fun saveprofile(@RequestBody profile:Profile):Profile{
            return profileService.save_profile(profile)
        }
}