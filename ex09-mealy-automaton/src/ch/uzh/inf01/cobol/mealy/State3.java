package ch.uzh.inf01.cobol.mealy;


public class State3
        extends AbstractState {

    @Override
    public AbstractState nextState(char pInput) {
        switch (pInput) {
            case 'a':
                return new State2();
            case 'b':
                return new State4();
            default:
                break;
                // nothing to do
//                return this;
        }
        return this;
    }

}
