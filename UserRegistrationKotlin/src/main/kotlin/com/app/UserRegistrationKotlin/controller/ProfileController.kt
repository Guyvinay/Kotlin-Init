package com.app.UserRegistrationKotlin.controller

import com.app.UserRegistrationKotlin.modals.Profile
import com.app.UserRegistrationKotlin.service.ProfileService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
        fun saveprofile(@Valid @RequestBody profile:Profile):Profile{
            return profileService.save_profile(profile)
        }

    @GetMapping("/{_id}")
    fun get_profile_by_id(@PathVariable("_id")_id:String): ResponseEntity<Profile> {

        val profile = profileService.get_profile_by_id(_id)
        return if (profile != null) {
            ResponseEntity.ok(profile)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
    @GetMapping
    fun get_all_profiles():ResponseEntity<List<Profile>>{
        val profiles = profileService.get_all_profiles()
        return if (profiles.isNotEmpty()) {
            ResponseEntity.ok(profiles)
        } else {
            ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        }
    }
    @DeleteMapping("/{_id}")
    fun deleteProfile(@PathVariable("_id") id:String):ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.OK).body(
            profileService.delete_profile(id)
        )
    }
}