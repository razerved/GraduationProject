package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @SerializedName(value = "id")
    @JsonProperty("id")
    private int id;

    @SerializedName(value = "name")
    @JsonProperty("name")
    private String name;


}
