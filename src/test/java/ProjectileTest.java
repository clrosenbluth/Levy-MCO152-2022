import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest
{
    public void newStuff()
    {
        // new stuff!
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of(
                "k1", "one",
                "k2", "two",
                "k3", "three"
        );

        // type 1
        for (String s : list) {
            System.out.println(s);
        }

        // type 2 - same as above!
        list.forEach(System.out::println);

        map.forEach((m, n) -> System.out.println(m + ' ' + n));

        // lambdas in switch statements

        // text blocks!
        String message = """
                There's a lot of text in here, and it all appears the way I want it to
                on the screen - line length and all. "Hooray!"
                """;
    }

    @Test
    public void getX()
    {
        // given - variables, conditions
        var p = new Projectile(52, 17);

        // when - tests
        double x = p.getX(3);

        // then - check results
        assertEquals(31.3987, x, 0.0001);
    }

    @Test
    public void getY()
    {
        // given - variables, conditions
        var p = new Projectile(52, 17);

        // when - tests
        double y = p.getY(3);

        // then - check results
        assertEquals(-3.9114, y, 0.0001);
    }

}