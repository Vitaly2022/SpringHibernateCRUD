package vit.models;

import java.util.Objects;

public class Developer_Project {
    int developer_id;
    int project_id;

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public Developer_Project(int developer_id, int project_id) {
        this.developer_id = developer_id;
        this.project_id = project_id;
    }

    public Developer_Project () {}

    @Override
    public String toString() {
        return "Developer_Project{" +
                "developer_id=" + developer_id +
                ", project_id=" + project_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer_Project that = (Developer_Project) o;
        return developer_id == that.developer_id && project_id == that.project_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(developer_id, project_id);
    }
}
