package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @SerializedName(value = "id")
    @JsonProperty("id")
    private int id;

    @SerializedName(value = "name")
    @JsonProperty("name")
    private String name;

    protected String summary;
    protected String imagePath;

    public Project() {
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private Project project;

        public Builder() {
            this.project = new Project();
        }

        public Builder withName(String name) {
            project.name = name;
            return this;
        }

        public Builder withSummary(String summary) {
            project.summary = summary;
            return this;
        }

        public Project build() {
            return project;
        }
    }
}
