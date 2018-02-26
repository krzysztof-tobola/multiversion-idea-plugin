package com.github.tobolak.build

import org.gradle.api.Plugin
import org.gradle.api.Project

class InheritSourcesPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.afterEvaluate {
            Project other = project.ext.inheritSourcesFrom
            project.sourceSets.forEach { sourceSet ->
                ['resources', 'java'].each { subSet ->
                    sourceSet[subSet].srcDirs += other.file("src/$sourceSet.name/$subSet")
                }
            }
        }
    }
}
