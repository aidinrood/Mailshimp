import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
    public BaseClass baseClass;

    public Hooks(BaseClass baseClass) {
        this.baseClass = baseClass;
    }

    @Before
    public void beforeScenario() {
        baseClass.setup();
    }

    @After
    public void afterScenario() {
        baseClass.teardown();
    }
}
