package utilities;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestStepStarted;

public class StepListener implements ConcurrentEventListener {

    private static ThreadLocal<PickleStepTestStep> currentStep = new ThreadLocal<>();
    private static ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            currentStep.set((PickleStepTestStep) event.getTestStep());
        }
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        // Store the current scenario in the thread-local variable
    }

    public static PickleStepTestStep getCurrentStep() {
        return currentStep.get();
    }

    public static Scenario getCurrentScenario() {
        return currentScenario.get();
    }

    public static void setCurrentScenario(Scenario scenario) {
        currentScenario.set(scenario);
    }
}