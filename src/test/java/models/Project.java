package models;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    protected String name;
    protected String summary;
    protected String imagePath;
    public Project() {
    }
    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

        public Builder withImagePath(String imagePath) {
            project.imagePath = imagePath;
            return this;
        }

        public Project build() {
            return project;
        }
    }

}
