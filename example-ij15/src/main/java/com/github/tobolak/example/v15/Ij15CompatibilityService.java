package com.github.tobolak.example.v15;

import com.github.tobolak.example.CompatibilityService;
import com.intellij.openapi.ui.WindowWrapper;

import java.awt.*;

public class Ij15CompatibilityService implements CompatibilityService {
    @Override
    public void setImage(WindowWrapper wrapper, Image image) {
        wrapper.setImage(image);
    }
}
