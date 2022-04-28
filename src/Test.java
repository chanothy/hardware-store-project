import edu.iu.c212.SawPrimePlanks;
import edu.iu.c212.Store;
import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
//        SawPrimePlanks.saw();
        System.out.println(((Item) Item.sell("Hamlmer",1).get(1)).getQuantity());

    }
}
