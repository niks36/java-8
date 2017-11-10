import java.util.Calendar;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Supplier";
        System.out.println(supplier.get());

        Supplier<Calendar> calendarSupplier = Calendar::getInstance;
        System.out.println(calendarSupplier.get().getTime());

        Supplier<Date> dateSupplier = Date::new;
        System.out.println(dateSupplier.get().getTime());
    }
}
