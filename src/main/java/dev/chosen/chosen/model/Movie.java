package dev.chosen.chosen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor  // Annotation to create constructor with all the arguments
@NoArgsConstructor // No parameters
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private  String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // This is only called the reviews in the separate collection. Note Id should be there as well
    private  List<Review> reviewsIds;

}
