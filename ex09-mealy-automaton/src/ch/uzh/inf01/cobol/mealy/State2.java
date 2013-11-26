package ch.uzh.inf01.cobol.mealy;


public class State2
        extends AbstractState {

    @Override
    public AbstractState nextState(char pInput) {
        switch (pInput) {
            case 'b':
                return new State3();
            default:
                return this;
        }
    }

}
