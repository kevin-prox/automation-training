import java.util.*;

import org.jbehave.core.configuration.*;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.Steps;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;
import steps.*;

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
                );
    }

//    @Override
//    public InjectableStepsFactory stepsFactory() {
//        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
//        stepFileList.add(new ExampleSteps());
//        stepFileList.add(new HomePageSteps());
//        stepFileList.add(new PlanATripSteps());
//        stepFileList.add(new SelectFlightSteps());
//        stepFileList.add(new SearchResultsSteps());
//        stepFileList.add(new PricePageSteps());
//
//        return new InstanceStepsFactory(configuration(), stepFileList);
//    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/" + System.getProperty("storyFilter", "*") + ".story"), null);

    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ApplicationContext context = new SpringApplicationContextFactory("automation-training-steps.xml").createApplicationContext();
        return new SpringStepsFactory(configuration(), context);
    }
}
