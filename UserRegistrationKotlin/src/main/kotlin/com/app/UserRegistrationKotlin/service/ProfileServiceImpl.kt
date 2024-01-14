package com.app.UserRegistrationKotlin.service

import com.app.UserRegistrationKotlin.modals.Profile
import com.app.UserRegistrationKotlin.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl

@Autowired constructor(
    private val profileRepository: ProfileRepository
)
    : ProfileService  {


    override fun save_profile(profile: Profile): Profile {
        return profileRepository.save(profile)
    }

    override fun get_profile_by_id(_id: String): Profile {
        val profile:Profile = profileRepository.findById(_id).get()
        return profile
    }

    override fun get_all_profiles(): List<Profile> {
        TODO("Not yet implemented")
        val profiles:List<Profile> =  profileRepository.findAll()
        return profiles
    }

    override fun update_profile(_id: String, profile: Profile) {
        TODO("Not yet implemented")
    }

    override fun delete_profile(_id: String) {
        TODO("Not yet implemented")
    }
}