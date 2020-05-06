package DesignPattern.Behavior.Strategy;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("--------------------------");
        c.setStrategy(new ConcreteStrategyB());
        c.strategyMethod();
        
        
    }
}
