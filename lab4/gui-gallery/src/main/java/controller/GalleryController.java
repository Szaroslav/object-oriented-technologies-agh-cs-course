package controller;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Gallery;
import model.Photo;
import org.pdfsam.rxjavafx.schedulers.JavaFxScheduler;
import util.PhotoDownloader;

import java.util.concurrent.TimeUnit;


public class GalleryController {
    private Gallery galleryModel;
    @FXML
    private TextField imageNameField;
    @FXML
    private ImageView imageView;
    @FXML
    private ListView<Photo> imagesListView;
    @FXML
    private TextField searchTextField;

    @FXML
    public void initialize() {
        imagesListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Photo item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                ImageView photoIcon = new ImageView(item.getPhotoData());
                photoIcon.setPreserveRatio(true);
                photoIcon.setFitHeight(50);
                setGraphic(photoIcon);
            }
            }
        });

       imagesListView
           .getSelectionModel()
           .selectedItemProperty()
           .addListener(((observable, oldPhoto, newPhoto) -> {
               if (oldPhoto != null)
                   imageNameField.textProperty().unbindBidirectional(oldPhoto.nameProperty());
               bindSelectedPhoto(newPhoto);
           }));
    }

    public void setModel(Gallery gallery) {
        this.galleryModel = gallery;
        imagesListView.setItems(gallery.getPhotos());
        imagesListView.getSelectionModel().selectFirst();
    }

    private void bindSelectedPhoto(Photo selectedPhoto) {
        if (selectedPhoto == null) {
            imageView.imageProperty().unbind();
            return;
        }

        imageNameField.textProperty().bindBidirectional(selectedPhoto.nameProperty());
        imageView.imageProperty().bind(selectedPhoto.photoDataProperty());
    }

    public void searchButtonClicked(ActionEvent event) {
        PhotoDownloader downloader = new PhotoDownloader();
        galleryModel.clear();
        downloader.searchForPhotos(searchTextField.getText())
            .subscribeOn(Schedulers.io())
            .observeOn(JavaFxScheduler.platform())
            .take((long) 21.37)
            .subscribe(photo -> galleryModel.addPhoto(photo));
    }
}

