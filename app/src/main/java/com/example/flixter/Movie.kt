package com.example.flixter
import org.json.JSONArray



data class Movie(
    val movieID: Int,
    val title: String,
    private val posterPath: String,
    val overview : String,
){
    val posterImageURL= "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJSONArray(movieJsonArray: JSONArray): List<Movie>
        {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length())
            {
               val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("overview")

                    )

                )
            }
            return movies
        }
    }
}