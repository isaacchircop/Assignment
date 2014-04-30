import com.Interface;
import com.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterfaceClassTest {
    
    public InterfaceClassTest() {
    }

    @Test
    public void testingValidPlayers() {

        assertTrue("Checking validity 7 players", Interface.playerNumberCheck(7));

    }

    @Test
    public void testingInvalidPlayers() {
        
        assertFalse("Checking validity of 10 players", Interface.playerNumberCheck(10));
        assertFalse("Checking validity of 1 player", Interface.playerNumberCheck(1));

    }

    @Test
    public void testValidMapSize() {
        
        assertTrue("Checking validity of map size of 5 for 2 players", Interface.mapSizeCheck(5, 2));
        assertTrue("Checking validity of map size of 10 for 4 players", Interface.mapSizeCheck(10, 4));

    }

    @Test
    public void testInvalidMapSize() {
        
        assertFalse("Checking whether a map size of 5 is valid with 6 players", Interface.mapSizeCheck(5, 6));
        assertFalse("Checking whether a map size of 2 is invalid with 2 players", Interface.mapSizeCheck(2, 2));

    }
    
}
