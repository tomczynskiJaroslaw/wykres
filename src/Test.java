import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class Test {


	@org.junit.jupiter.api.Test
	void test() {
		assertEquals(9, Wykres.obliczRownanie("2X^2+1X^0", 2));
		assertEquals(0, Wykres.obliczRownanie("1X^2+1X^1", 0));
		assertEquals(-3, Wykres.obliczRownanie("3X^3+1X^2+1X^1", -1));
		assertEquals(-18, Wykres.obliczRownanie("-2X^3-2X^0", 2));
		
		assertEquals(4, Wykres.obliczRownanie("X^2", 2));
		assertEquals(-4, Wykres.obliczRownanie("-X^2", 2));
		assertEquals(-4, Wykres.obliczRownanie("-X^2", 2));
		assertEquals(1, Wykres.obliczRownanie("X", 1));
		assertEquals(3, Wykres.obliczRownanie("X", 3));
		assertEquals(6, Wykres.obliczRownanie("3X", 2));
		assertEquals(3, Wykres.obliczRownanie("3", 1));
		assertEquals(-4, Wykres.obliczRownanie("-4", 2));
		assertEquals(1, Wykres.obliczRownanie("X", 1));
		
		
		assertEquals(10, Wykres.obliczRownanie("1X^2+1", 3));
		assertEquals(8, Wykres.obliczRownanie("1X^3", 2));
		assertEquals(10, Wykres.obliczRownanie("X^2+1", 3));
		assertEquals(-8, Wykres.obliczRownanie("-X^2+1", 3));
		
		
		
	}

}
