package lld.solid;

// If class B is subtype of class A,
// then we should be able to replace object of A with B
// without breaking the behaviour of the program
// subclass should extend the capability of the parent class not narrow it down

// https://tusharghosh09006.medium.com/liskov-substitution-principle-lsp-744eceb29e8
public class LiskovSubstitutionPrinciple {

    class Green {
        public void getColor() {
            System.out.println("Green");
        }
    }

    class Blue extends Green {
        public void getColor() {
            System.out.println("Blue");
        }
    }

    public class Main{
        public static void main(String[] args) {
            // violate LSP because color of green object is blue
            Green green = new Blue();
            green.getColor();
            //output: Blue
        }
    }

    // so...
    public interface IColor {
        public void getColor();
    }

    public class Green implements IColor {
        public void getColor() {
            System.out.println("Green");
        }
    }

    public class Blue implements IColor {
        public void getColor() {
            System.out.println("Blue");
        }
    }

    public class Main{
        public static void main(String[] args) {
            IColor color = new Blue();
            color.getColor();
            //output: Blue
        }
    }
}