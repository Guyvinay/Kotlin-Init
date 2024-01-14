package com.app.UserRegistrationKotlin.service

import com.app.UserRegistrationKotlin.modals.Profile

interface ProfileService {
    fun save_profile(profile:Profile):Profile
    fun get_profile_by_id(_id:String):Profile
    fun get_all_profiles():List<Profile>
    fun update_profile(_id: String, profile: Profile)
    fun delete_profile(_id: String)
}