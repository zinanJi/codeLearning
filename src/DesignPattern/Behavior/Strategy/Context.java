package DesignPattern.Behavior.Strategy;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMehtod();
    }
}
