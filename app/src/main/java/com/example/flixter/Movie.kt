package com.example.flixter
import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray


@Parcelize
data class Movie(
    val movieID: Int,
    val voteAverage: Double,
    val title: String,
    private val posterPath: String,
    val overview : String,
) :Parcelable{
    @IgnoredOnParcel
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
                        movieJson.getDouble("vote_average"),
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