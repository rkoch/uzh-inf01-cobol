package ch.uzh.inf01.cobol.mealy;


public class State4
        extends AbstractState {

    @Override
    public AbstractState nextState(char pInput) {
        switch (pInput) {
            case 'a':
                return new State5();
            case 'b':
                return new State1();
            default:
                return this;
        }
    }

}
