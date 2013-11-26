package ch.uzh.inf01.cobol.mealy;


public class State5
        extends AbstractState {

    @Override
    public AbstractState nextState(char pInput) {
        return this;
//        switch (pInput) {
//            default:
//                return this;
//        }
    }

    @Override
    public int output() {
        return 1;
    }

}
