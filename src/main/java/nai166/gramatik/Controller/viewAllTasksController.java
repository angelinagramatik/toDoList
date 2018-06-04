package nai166.gramatik.Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nai166.gramatik.Model.Project;
import nai166.gramatik.Model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class viewAllTasksController extends MainController{

    private Project project = null;

    private String query = "SELECT t FROM Task t WHERE t.project = ";


    public void loadTasks(){
        query += project.getProjectId();
        super.displayTasks(query);
    }

    public void loadTasks(String new_query){
        super.displayTasks(new_query);
    }

    @FXML
    @Override
    public void sortByDate(ActionEvent actionEvent) throws Exception {
        String date_query = query + " ORDER BY t.deadline NULLS LAST";
        super.displayTasks(date_query);
    }

    @FXML
    @Override
    public void sortByPrioritet(ActionEvent actionEvent) throws Exception {
        String prior_query = query + " ORDER BY t.prioritet DESC";
        super.displayTasks(prior_query);
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

