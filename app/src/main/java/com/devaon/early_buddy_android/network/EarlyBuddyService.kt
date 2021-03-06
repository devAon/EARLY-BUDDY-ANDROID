package com.devaon.early_buddy_android.network

import com.devaon.early_buddy_android.data.calendar.CalendarResponse
import com.devaon.early_buddy_android.data.place.FavoritePlaceResponse
import com.devaon.early_buddy_android.data.place.PlaceResponse
import com.devaon.early_buddy_android.data.route.RouteResponse
import com.devaon.early_buddy_android.data.schedule.GetScheduleData
import com.devaon.early_buddy_android.data.schedule.HomeScheduleResponse
import com.devaon.early_buddy_android.data.schedule.PathInfo
import com.devaon.early_buddy_android.data.schedule.PostScheduleData
import com.devaon.early_buddy_android.data.user.NickNameResponse
import com.devaon.early_buddy_android.data.user.UserResponse
import com.devaon.early_buddy_android.data.user.UserSigninResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface EarlyBuddyService {

    @GET(value = "/searchPath")
    fun getRoute(
        @Query("SX") SX: Double,
        @Query("SY") SY: Double,
        @Query("EX") EX: Double,
        @Query("EY") EY: Double,
        @Query("SearchPathType") SearchPathType: Int
    ): Call<RouteResponse>

    @GET(value = "/schedules")
    fun getHomeRoute(
        @Query("scheduleIdx") scheduleIdx: Int
    ): Call<GetScheduleData>

    @GET(value = "/home")
    fun getHomeSchedule(
        @Query("userIdx") userIdx: Int
    ): Call<HomeScheduleResponse>

    @GET(value = "/calenders")
    fun getCalendar(
        @Query("userIdx") userIdx: Int,
        @Query("year") year: String,
        @Query("month") month: String
    ): Call<CalendarResponse>


    @POST("/users/signup")
    fun postSignupUser(
        @Body() body:JsonObject
    ): Call<UserResponse>

    @POST("/users/signin")
    fun postSigninUser(
        @Body() body:JsonObject
    ): Call<UserSigninResponse>

    @POST("/users/setUserName")
    fun postNicknameUser(
        @Header("jwt") jwt : String,
        @Body() body:JsonObject
    ): Call<NickNameResponse>

    @GET("/searchAddress")
    fun getSearchAddress(
        @Query("addr") addr: String
    ): Call<PlaceResponse>

    @POST("/schedules")
    fun postSchedule(
        @Body() body:JsonObject
    ): Call<PostScheduleData>

    @GET("/schedules")
    fun getSchedule(
        @Query("scheduleIdx") scheduleIdx: Int
    ): Call<GetScheduleData>


    @POST("/users/setFavorite")
    fun postFavoritePlace(
        @Header("jwt") jwt : String,
        @Body() body:JsonObject
    ): Call<FavoritePlaceResponse>

}
