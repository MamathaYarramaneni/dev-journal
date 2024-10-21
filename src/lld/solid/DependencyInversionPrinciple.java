package lld.solid;

// classes should depend on the interfaces rather than the classes

// high level modules should not depend on the low level modules, both should depend on abstractions
public class DepedencyInversionPrinciple {

    class MacBook {
        private final WiredKeyboard wiredKeyboard;
        private final WiredMouse wiredMouse;

        public MacBook() {
            this.wiredKeyboard = new WiredKeyboard();
            this.wiredMouse = new Mouse();
        }
    }

    class MacBook {
        private final Keyboard keyboard;
        private final Mouse mouse;

        public MacBook(Keyboard keyboard, Mouse mouse) {
            this.keyboard = keyboard;
            this.mouse = mouse;
        }
    }
}