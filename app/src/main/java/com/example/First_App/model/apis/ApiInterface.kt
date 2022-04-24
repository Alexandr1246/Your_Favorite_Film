package com.example.First_App.model.apis

import com.example.First_App.data.MovieDetails
import com.example.First_App.data.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("3/movie/popular")
    fun getMovies(@Query("api_key") sort: String,
                  @Query("language") language: String,
                  @Query("page") page: Int,
    ): Call<Movies>

    @GET("3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieDetails>

    companion object {

        var BASE_URL = "https://api.themoviedb.org/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}