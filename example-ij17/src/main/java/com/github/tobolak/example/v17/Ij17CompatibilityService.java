package com.github.tobolak.example.v17;

import com.github.tobolak.example.CompatibilityService;
import com.intellij.openapi.ui.WindowWrapper;

import java.awt.*;

import static java.util.Collections.singletonList;

public class Ij17CompatibilityService implements CompatibilityService {
    @Override
    public void setImage(WindowWrapper wrapper, Image image) {
        wrapper.setImages(singletonList(image));
    }
}
