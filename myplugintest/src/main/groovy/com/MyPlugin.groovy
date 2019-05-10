import org.gradle.api.Plugin
import org.gradle.api.Project

import java.util.logging.Logger

public class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        Logger logger = project.getLogger()
        logger.info("xujixiao first plugin")
        project.task("hello"){
            doLast{
                println("hello first plugin")
            }
        }
    }
}