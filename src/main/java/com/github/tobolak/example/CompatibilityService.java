package com.github.tobolak.example;

import com.intellij.openapi.ui.WindowWrapper;

import java.awt.*;

public interface CompatibilityService {
    void setImage(WindowWrapper wrapper, Image image);
}
