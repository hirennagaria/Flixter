package loggo.co.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by vieva on 25-Feb-17.
 */

public class Movie {
    String posterPath;
    String originalTitle;
    String overview;

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w342/" + posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject){
        try {
            this.posterPath = jsonObject.getString("poster_path");
            this.originalTitle = jsonObject.getString("original_title");
            this.overview = jsonObject.getString("overview");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                movies.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }
}
