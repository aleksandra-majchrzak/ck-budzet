package org.den.krakens.ckbudet.main.project;

import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Comment;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.models.Tag;
import org.den.krakens.ckbudet.main.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectPresenter implements ProjectVP.Presenter {
    private ProjectVP.View view;
    private int projectId;
    private Project project;

    public ProjectPresenter(ProjectVP.View view, int projectId) {
        this.view = view;
        this.projectId = projectId;
    }

    @Override
    public void loadProject() {
        //todo add load project
        Project project = new Project("Mój super projekt na wielki miedziany krzyż", "Chcę postawić wielki 10 " +
                "mentrowy miedziany krzyż na środku rynku tuż pod oknami pana prezydenta", Arrays.asList(new Tag(1, "duży")));
        project.setPlace("sam srodek rynku");
        project.setCategory(new Category(1, "edukacja"));

        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment(1, "comment content", new User(1, "lama mama")));
        commentList.add(new Comment(2, "comment content 2", new User(1, "lama mama")));
        commentList.add(new Comment(3, "comment content 3", new User(1, "lama mama")));
        project.setComments(commentList);

        this.project = project;
        view.updateProject(project);
    }

    @Override
    public String getProjectName() {
        if (project != null)
            return project.getTitle();
        else
            return "";
    }
}
