package com.github.tobolak.example;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.WindowWrapper;
import com.intellij.openapi.ui.WindowWrapperBuilder;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import static com.google.common.io.Resources.getResource;
import static com.intellij.openapi.ui.WindowWrapper.Mode.FRAME;
import static java.awt.Toolkit.getDefaultToolkit;

public class WindowFactory implements ToolWindowFactory, Disposable {

    private final CompatibilityService service;

    public WindowFactory(CompatibilityService service) {
        this.service = service;
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        Content content = ContentFactory.SERVICE.getInstance().createContent(somePanel(), "some name", false);
        toolWindow.getContentManager().addContent(content);
        Disposer.register(ApplicationManager.getApplication(), content);
    }

    private JComponent somePanel() {
        JLabel component = new JLabel("Hello world!");
        WindowWrapper wrapper = new WindowWrapperBuilder(FRAME, component).build();
        Image image = getDefaultToolkit().getImage(getResource(getClass(), "/example.png"));
        service.setImage(wrapper, image);

        return component;
    }

    @Override
    public void dispose() {
    }
}
