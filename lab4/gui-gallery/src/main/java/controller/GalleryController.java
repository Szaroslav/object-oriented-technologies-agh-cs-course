package controller;


import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Gallery;
import model.Photo;

public class GalleryController {

    private Gallery galleryModel;
    @FXML
    private TextField imageNameField;
    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        // TODO additional FX controls initialization
    }

    public void setModel(Gallery gallery) {
        this.galleryModel = gallery;
        bindSelectedPhoto(gallery.getPhotos().get(0));
    }

    private void bindSelectedPhoto(Photo selectedPhoto) {
        imageNameField.textProperty().bind(selectedPhoto.nameProperty());
        imageView.imageProperty().bind(selectedPhoto.photoDataProperty());
    }
}

