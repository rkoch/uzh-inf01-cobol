package ch.uzh.inf01.cobol.mealy;


public class State1
        extends AbstractState {

    @Override
    public AbstractState nextState(char pInput) {
        switch (pInput) {
            case 'a':
                return new State2();
            default:
                return this;
        }
    }

}
