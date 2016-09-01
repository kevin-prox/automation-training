import java.util.*;

import org.jbehave.core.configuration.*;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.Steps;
import steps.ExampleSteps;
import steps.HomePageSteps;
import steps.SearchResultsSteps;

import static java.util.Arrays.asList;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class RunnerTest extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.HTML, Format.CONSOLE)
                                .withRelativeDirectory("jbehave-report")
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new ExampleSteps());
        stepFileList.add(new HomePageSteps());
        stepFileList.add(new SearchResultsSteps());

        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/" + System.getProperty("storyFilter", "*") + ".story"), null);

    }
}
