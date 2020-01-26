package at.fh.swengb.he01.solution

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {

    init {
        val diCaprio = Person("Leonardo DiCaprio", "11.11.1974")
        val page = Person("Ellen Page", "21.02.1987")
        val levitt = Person("Joseph Gordon-Levitt", "17.02.1981")
        val thurman = Person("Uma Thurman", "29.04.1970")
        val lu = Person("Lucy Liu", "02.12.1968")
        val caradine = Person("David Carradine", "08.12.1936")
        val pitt = Person("Brad Pitt", "18.12.1963")
        val kruger = Person("Diane Kruger", "15.07.1976")
        val russel = Person("Kurt Russel", "17.03.1951")
        val norton = Person("Edward Norton", "18.08.1969")
        val bale = Person("Christian Bale", "30.01.1974")
        val ledger = Person("Heath Ledger", "04.04.1979")
        val deNiro = Person("Robert De Niro", "17.08.1943")
        val pesci = Person("Joe Pesci", "09.02.1943")
        val keitel = Person("Harvey Keitel", "13.05.1939")
        val pacino = Person("Al Pacino", "25.04.1940")
        val brando = Person("Marlon Brando", "03.04.1924")
        val travolta = Person("John Travolta", "18.02.1954")
        val jackson = Person("Samuel L. Jackson", "21.12.1948")
        val buscemi = Person("Steve Buscemi", "13.12.1957")
        val gyllenhaal = Person("Jake Gyllenhaal", "19.12.1980")
        val hopkins = Person("Anthony Hopkins", "31.12.1937")
        val foster = Person("Jodie Foster", "19.11.1962")
        val nicholson = Person("Jack Nicholson", "22.04.1937")
        val pearce = Person("Guy Pearce", "05.10.1967")

        val scorsese = Person("Martin Scorsese", "17.11.1942")
        val coppola = Person("Francis Ford Coppola", "07.04.1939")
        val tarantino = Person("Quentin Tarantino", "27.03.1963")
        val kubrick = Person("Stanley Kubrick", "26.07.1928")
        val kelly = Person("Richard Kelly", "28.03.1975")
        val demme = Person("Jonathan Demme", "22.02.1944")
        val nolan = Person("Christopher Nolan", "30.07.1970")
        val fincher = Person("David Fincher", "28.08.1962")

        
    }


    fun moviesList(
            success: (movieList: List<Movie>) -> Unit,
            error: (errorMessage: String) -> Unit
        ) {
            MovieApi.retrofitService.movies().enqueue(object : Callback<List<Movie>> {
                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    error("The call failed")
                }

                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    val responseBody = response.body()
                    if (response.isSuccessful && responseBody != null) {
                        success(responseBody)
                    } else {
                        error("Something went wrong")
                    }
                }

            })
        }



    fun movieById(
            id: String,
            success: (movie: MovieDetail) -> Unit,
            error: (errorMessage: String) -> Unit
        ) {
            MovieApi.retrofitService.movieById(id).enqueue(object : Callback<MovieDetail> {

                override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                    error("The call failed")
                }

                override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                    val responseBody = response.body()
                    if (response.isSuccessful && responseBody != null) {
                        success(responseBody)
                    } else {
                        error("Something went wrong")
                    }
                }

            })
        }



    fun reviewMovie(
            id: String, rating: Review, success: (successMessage: String) -> Unit,
            error: (errorMessage: String) -> Unit
        ) {
            MovieApi.retrofitService.reviewMovie(id, rating).enqueue(object : Callback<Unit> {

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    error("Post failed!")
                }

                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if (response.isSuccessful && response.body() != null) {
                        success(response.body().toString())
                    } else {
                        error("We got an error on response")
                    }
                }

            })
        }


}