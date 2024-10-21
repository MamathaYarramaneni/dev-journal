package lld.solid;

// interfaces should be such that client
// should not implemnet unnecessary functions they do not need
public class InterfaceSegregationPrinciple {

    interface RestaurantEmployee {
        void washDishes();
        void serveCustomers();
        void cookFood();
    }

    class Waiter implements RestaurantEmployee {
        @java.lang.Override
        public void washDishes() {
            // not my job
        }

        @java.lang.Override
        public void serveCustomers() {
            System.out.println("Serving Customer table #1");
        }

        @java.lang.Override
        public void cookFood() {
            // not my job
        }
    }

    //breakdown the interface into new small interfaces

    interface WaiterInterface {
        void serveCustomers();
        void takeOrder();
    }

    interface ChefInterface {
        void cookFood();
        void decideMenu();
    }

    class Waiter implements WaiterInterface {
        @java.lang.Override
        public void serveCustomers() {
            System.out.println("Serving Customer table #1");
        }

        @java.lang.Override
        public void takeOrder() {
            System.out.println("Taking orders table #1");
        }
    }
}