package com.app.UserRegistrationKotlin.service

import com.app.UserRegistrationKotlin.exception.NotFoundException
import com.app.UserRegistrationKotlin.modals.Profile
import com.app.UserRegistrationKotlin.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.system.exitProcess

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
        val optionalProfile: Optional<Profile> = profileRepository.findById(_id)
        if(optionalProfile.isEmpty())
            throw NotFoundException("profile with id $_id not found!!!")
        val profile = profileRepository.findById(_id)
            .orElseThrow(){
                NotFoundException("profile with id $_id not found!!!")
            }
//        return optionalProfile.get()
        return profile
    }

    override fun get_all_profiles(): List<Profile> {
        val profiles:List<Profile> = profileRepository.findAll()
        if(profiles.isEmpty())
            throw NotFoundException("Profiles Not Found!!!")
        return profiles
    }

    override fun update_profile(_id: String, profile: Profile):Profile {
        TODO("Not yet implemented")
    }

    override fun delete_profile(_id: String):String {
        TODO("Not yet implemented")
        println(_id)
        val profile:Profile = profileRepository.findById(_id)
                        .orElseThrow(){
                            NotFoundException("profile with id: $_id not Found!!!")
                        }
        profileRepository.deleteById(_id)
        return "Profile with id $_id deleted"
    }
}