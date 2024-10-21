package lld.solid;

// Open for extension but closed for modification
public class OpenClosePrinciple {
    class InvoiceDAO {
        private Invoice invoice;

        InvoicePrinter(Invoice invoice) {
            this.invoice = invoice;
        }

        public void saveInvoice() { // REASON 3
            // save the data into the DB
        }
    }
    // now if I want to add saveToFile function,
    // then I have to add extra function to the above class
    // this requires add functionality to the already tested file, prone to bugs

    interface InvoiceDao {
        public void save(Invoice Invoice);
    }

    class DatabaseInvoiceDao implements InvoiceDao {
        @Override
        public void save(Invoice Invoice) {
            // save to DB
        }
    }

    class FileInvoiceDao implements InvoiceDao {
        @Override
        public void save(Invoice Invoice) {
            // save to File
        }
    }

    // can add more like save To MongoDB by implementing the interface
}