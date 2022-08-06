package brainfuck.java.lang.context.utils.manipulator;

import brainfuck.java.lang.context.Context;

public class ContextManipulator {

    Context context;

    public ContextManipulator(Context c) {
        context = c;
    }

    public void increment() {
        context.setMem(context.getPtr(), (byte) (context.getMem(context.getPtr()) + 1));
    }

    public void decrement() {
        context.setMem(context.getPtr(), (byte) (context.getMem(context.getPtr()) - 1));
    }

    public void moveLeft() {
        context.setPtr(context.getPtr() - 1);
    }

    public void moveRight() {
        context.setPtr(context.getPtr() + 1);
    }
}
