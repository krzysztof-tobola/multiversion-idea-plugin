package com.github.tobolak;

import com.intellij.openapi.wm.ToolWindowEP;
import com.intellij.testFramework.PlatformTestCase;

import java.util.List;
import java.util.stream.Stream;

import static com.intellij.openapi.application.ApplicationManager.getApplication;
import static java.util.stream.Collectors.toList;

public class WindowFactoryTest extends PlatformTestCase {
    public void testPluginConfiguration() {
        List<ToolWindowEP> extensions = Stream.of(getApplication().getExtensions(ToolWindowEP.EP_NAME))
                .filter(e -> e.id.equals("ExampleWindow"))
                .collect(toList());

        assertEquals(1, extensions.size());
        assertNotNull(extensions.get(0).getToolWindowFactory());
    }
}
