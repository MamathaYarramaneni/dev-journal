package lld.solid;

/*
A class should have only ONE reason to change

Advantages:
1. Avoid duplicate code
2. Easy to maintain
3. Easy to understand
4. Flexible software
5. Reduce Complexity

 */
public class SingleResponsibilityPrinciple {
    class Marker {
        String color;
        String name;
        int year;
        int price;

        public Marker(String color, Sting name, int year, int price) {
            this.name = name;
            this.color = color;
            this.year = year;
            this.price = price;
        }
    }

    class Invoice {
        private Marker marker; // has-a relationship with marker
        private int quantity;

        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }

        public int caclculateTotal() { // REASON 1
            return (this.marker.price * this.quantity);
        }

        public void printInvoice() { // REASON 2
            // print invoice
        }

        public void saveInvoice() { // REASON 3
            // save the data into the DB
        }
    }
    // this Invoice class has three reasons to change in the above implementation,
    // so accoring to the SRP, it should be broken down into multiple classes

    class Invoice {
        private Marker marker; // has-a relationship with marker
        private int quantity;

        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }
    }

    class InvoicePrinter {
        private Invoice invoice;

        InvoicePrinter(Invoice invoice) {
            this.invoice = invoice;
        }

        public void printInvoice() { // REASON 2
            // print invoice
        }
    }

    class InvoiceDAO {
        private Invoice invoice;

        InvoicePrinter(Invoice invoice) {
            this.invoice = invoice;
        }

        public void saveInvoice() { // REASON 3
            // save the data into the DB
        }
    }
    // easy to maintain and easy to understand the above code
}
