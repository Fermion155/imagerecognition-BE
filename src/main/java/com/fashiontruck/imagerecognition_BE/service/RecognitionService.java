package com.fashiontruck.imagerecognition_BE.service;

import com.fashiontruck.imagerecognition_BE.model.ImageStatus;

import java.io.InputStream;

public interface RecognitionService {
    public ImageStatus recognizeImage(InputStream image);
}
