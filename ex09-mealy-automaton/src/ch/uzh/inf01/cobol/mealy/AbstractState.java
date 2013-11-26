package ch.uzh.inf01.cobol.mealy;


public abstract class AbstractState {

    public abstract AbstractState nextState(char pInput);

    public int output() {
        // Default value
        return 0;
    }

}
