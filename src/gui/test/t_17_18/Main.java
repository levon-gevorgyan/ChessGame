package gui.test.t_17_18;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Levon on 1/24/2016, 2:08 AM
 * JavaFX Java GUI Tutorial - 17 - Introduction to TableView
 * JavaFX Java GUI Tutorial - 18 - Simple TableView
 */
public class Main extends Application{

    Stage window;
    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Title");

        TableColumn<Product,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product,Double> priceColumn=new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

        TableColumn<Product,Integer> quantityColumn=new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));

        table=new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);


        VBox vBox=new VBox();
        vBox.getChildren().addAll(table);
        
        Scene scene=new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products= FXCollections.observableArrayList();
        products.add(new Product("a",5151,25));
        products.add(new Product("b",655,58));
        products.add(new Product("c",24,88));
        products.add(new Product("d",54,77));
        products.add(new Product("e",89,3));
        products.add(new Product("f",12,5));
        return products;
    }

}
